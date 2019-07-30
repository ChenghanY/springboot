package com.james.signature.util.ExcelUtil;

import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.metadata.Sheet;
import com.alibaba.excel.support.ExcelTypeEnum;
import com.james.signature.model.SignRecordInfo;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.List;

/**
 * @Author james
 * @Date 2019/7/29
 * @Description 读取MySQL的数据，到出到Excel文件
 */
public class ExportRecord {

    public void export(List<SignRecordInfo> data) throws IOException {
        // 本地测试
        try (OutputStream out = new FileOutputStream("E:\\excel\\sign_record.xlsx");) {
            ExcelWriter writer = new ExcelWriter(out, ExcelTypeEnum.XLSX);
            Sheet sheet1 = new Sheet(1, 0, SignRecordInfo.class);
            sheet1.setSheetName("sheet1");
/*            测试数据
          for (int i = 0; i < 100; i++) {
                SignRecordInfo item = new SignRecordInfo();
                item.name = "name" + i;
                item.age = "age" + i;
                item.email = "email" + i;
                item.address = "address" + i;
                item.sax = "sax" + i;
                item.heigh = "heigh" + i;
                item.last = "last" + i;
                data.add(item);
            }
*/
            writer.write(data, sheet1);
            writer.finish();
        }
    }

}
