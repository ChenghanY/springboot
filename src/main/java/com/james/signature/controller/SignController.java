package com.james.signature.controller;

import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.james.signature.Constants;
import com.james.signature.domain.SignRecordEntity;
import com.james.signature.model.SignRecordInfo;
import com.james.signature.model.worker.WorkerId;
import com.james.signature.service.SignService;
import com.james.signature.util.StatusJsonForAndroid;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Api(value = "用户签到控制器")
@RestController
@RequestMapping(value = Constants.URI_SIGN)
public class SignController {

    @Autowired
    SignService signService;

    @GetMapping(value = "/record/list")
    @ApiOperation(value = "获取所有员工签到记录")
    private SignRecordInfo[] getAllRecordByWorkerId() {

        List<SignRecordInfo> signRecordInfoList = signService.getAllSignInfo();
        return signRecordInfoList.toArray(new SignRecordInfo[signRecordInfoList.size()]);
    }

    @PostMapping(value = "/record")
    @ApiOperation(value = "根据员工Id获取考勤记录")
    private SignRecordInfo[] getByWorkerId(@RequestBody WorkerId workerIdObject){
        List<SignRecordInfo> signRecordInfoList = signService.getAllByWorkerId(workerIdObject.getWorkerId());
        return signRecordInfoList.toArray(new SignRecordInfo[signRecordInfoList.size()]);
    }


    @PostMapping(value = "in/morning", consumes = "application/json")
    @ApiOperation(value = "用户早上完成签到")
    private StatusJsonForAndroid userSignInMorning(@RequestBody @ApiParam(name = "签到记录", value = "传入Json格式") SignRecordEntity signRecordEntity) {
        signService.signInMorning(signRecordEntity);
        return new StatusJsonForAndroid(signRecordEntity);
    }

    @PostMapping(value = "in/afternoon", consumes = "application/json")
    @ApiOperation(value = "用户下午完成签到")
    private StatusJsonForAndroid userSignInAfternoon(@RequestBody @ApiParam(name = "签到记录", value = "传入Json格式") SignRecordEntity signRecordEntity) {
        signService.signInAfternoon(signRecordEntity);
        return new StatusJsonForAndroid(signRecordEntity);
    }

    @GetMapping(value = "export")
    @ApiOperation(value = "导出所有签到记录")
    private void exportAllRecord(HttpServletRequest request, HttpServletResponse response) {

        ServletOutputStream out = null;
        try {
            out = response.getOutputStream();

            // 设置浏览器头
            response.setContentType("multipart/form-data");
            response.setCharacterEncoding("utf-8");
            String fileName = new String(("UserInfo " + new SimpleDateFormat("yyyy-MM-dd").format(new Date()))
                    .getBytes(), "UTF-8");
            response.setHeader("Content-disposition", "attachment;filename="+fileName+".xlsx");


            ExcelWriter writer = new ExcelWriter(out, ExcelTypeEnum.XLSX, true);

            boolean flag = signService.exportAllSignRecord(out);
            if(flag != true) {
                writer.finish();

            }
            out.flush();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("ServletOutputStream 发送IO异常");
        } finally {
            // 释放空间
            if(out != null) {
                out = null;
            }
        }

    }

}

