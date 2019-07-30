package com.james.signature.util.ExcelUtil;

import com.james.signature.model.SignRecordInfo;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;

/**
 * @Author james
 * @Date 2019/7/27
 * @Description
 */
@Service
public class ExcelUtil {

    private ExportRecord exportRecord;

    // 暂时不使用poi
    /*public void poi() throws Exception {
        //1.读取Excel文档对象
        HSSFWorkbook hssfWorkbook = new HSSFWorkbook(new FileInputStream("E:\\excel\\test.xls"));
        //2.获取要解析的表格（第一个表格）
        HSSFSheet sheet = hssfWorkbook.getSheetAt(0);
        //获得最后一行的行号
        int lastRowNum = sheet.getLastRowNum();
        for (int i = 0; i <= lastRowNum; i++) {//遍历每一行
            //3.获得要解析的行
            HSSFRow row = sheet.getRow(i);
            //4.获得每个单元格中的内容（String）
            String stringCellValue0 = row.getCell(0).getStringCellValue();
            String stringCellValue1 = row.getCell(1).getStringCellValue();
            String stringCellValue2 = row.getCell(2).getStringCellValue();
            String stringCellValue3 = row.getCell(3).getStringCellValue();
            System.out.println(stringCellValue0 + "--" + stringCellValue1 + "--" + stringCellValue2 + "--" + stringCellValue3 );
        }

    }*/

    public void exportSignRecord(List<SignRecordInfo> data) throws IOException {
        if (exportRecord != null) {
            exportRecord = new ExportRecord();
        }
        exportRecord.export(data);
    }


}
