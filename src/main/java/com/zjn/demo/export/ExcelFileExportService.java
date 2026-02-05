package com.zjn.demo.export;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.ExcelWriter;
import com.alibaba.excel.write.metadata.WriteSheet;
import com.zjn.demo.export.template.TestLaptop;

import java.io.InputStream;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

/**
 * excel文件导出
 */
public class ExcelFileExportService {

    public void exportByTemplate() {
        String fileName = "test_" + LocalDate.now().format(DateTimeFormatter.ofPattern("yyyyMMdd")) + System.currentTimeMillis() + ".xlsx";
        ExcelWriter excelWriter = null;
        try {
            InputStream resourceAsStream = getClass().getClassLoader().getResourceAsStream("template/test_laptop.xlsx");

            excelWriter = EasyExcel.write(fileName, TestLaptop.class)
                    .withTemplate(resourceAsStream).build();
            WriteSheet writeSheet = EasyExcel.writerSheet().needHead(false).build();
            List<TestLaptop> testLaptops = TestLaptop.generationTestData();
            excelWriter.write(testLaptops, writeSheet);
//            EasyExcel.write(fileName, TestLaptop.class)
//                    .withTemplate(resourceAsStream).sheet().needHead(false).doWrite(TestLaptop.generationTestData());
        } finally {
            if (excelWriter != null) {
                excelWriter.finish();
            }
        }
    }

    public static void main(String[] args) {
        new ExcelFileExportService().exportByTemplate();
    }
}
