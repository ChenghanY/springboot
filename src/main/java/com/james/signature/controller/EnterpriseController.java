package com.james.signature.controller;

import com.james.signature.Constants;
import com.james.signature.aspect.StatusJson;
import com.james.signature.domain.EnterpriseEntity;
import com.james.signature.model.enterprise.LngLat;
import com.james.signature.model.enterprise.Scope;
import com.james.signature.model.enterprise.StartTimeEndTime;
import com.james.signature.service.EnterpriseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Api(tags = "企业信息服务")
@RequestMapping(value = Constants.URI_ENTERISE)
public class EnterpriseController {

    @Autowired
    EnterpriseService enterpriseService;

    @GetMapping()
    @ApiOperation(value = "获取企业信息")
    private EnterpriseEntity getEnterpriseInfo() {
        EnterpriseEntity enterpriseEntity = enterpriseService.getEnterpriseInfo();
        return enterpriseEntity;
    }

    @GetMapping(value = "/lnglat")
    @ApiOperation(value = "获取企业定位坐标")
    private StatusJson getLngLat() {
        String lngLatStr = enterpriseService.getLntLat();
        return new StatusJson(new LngLat(lngLatStr));
    }

    @PutMapping(value = "/lnglat")
    @ApiOperation(value = "更新企业定位坐标")
    private StatusJson updateLnglat(@RequestBody LngLat lngLatObject) {
        String result = enterpriseService.updateLntLat(lngLatObject.getLngLat());
        return new StatusJson(result);
    }

    @PutMapping(value = "/time")
    @ApiOperation(value = "更新企业上下班时间")
    private StatusJson updateTime(@RequestBody StartTimeEndTime startTimeEndTimeObject) {
        String result = enterpriseService.updateStartEndTime(startTimeEndTimeObject.getStartTime(),
                startTimeEndTimeObject.getEndTime());
        return new StatusJson(result);
    }

    @PutMapping(value = "/update/scope")
    @ApiOperation(value = "更新企业签到范围")
    private StatusJson updateTime(@RequestBody Scope scopeObject) {
        String result = enterpriseService.updateScope(scopeObject.getScope());
        return new StatusJson(result);
    }
}
