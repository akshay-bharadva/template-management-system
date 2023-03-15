/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.finlogic.util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.apache.commons.collections.map.ListOrderedMap;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

/**
 *
 * @author njuser
 */
@Service
public class ExcelUtil {

    private final String excelPath = CommonUtil.storageFilePath();

    public String generateExcelFromList(String title, List<String> placeholderList) throws FileNotFoundException, IOException {

        String titleWithHypn = title.replace(" ", "-");
        String fileName = titleWithHypn + "-" + CommonUtil.currentDate() + ".xlsx";

        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("Placeholder Data");

        String filePath = excelPath + fileName;

        Map<String, String> data = new ListOrderedMap();

        for (String placeholderName : placeholderList) {
            data.put(placeholderName, "");
        }

        int rowno = 0;
        XSSFRow row = sheet.createRow(rowno);
        int columnno = 0;

        for (Map.Entry entry : data.entrySet()) {
            row.createCell(columnno++).setCellValue((String) entry.getKey());
//            row.createCell(1).setCellValue((String) entry.getValue());
        }

        FileOutputStream fos = new FileOutputStream(filePath);

        workbook.write(fos);
        fos.close();
        CommonMember.appendLogFile("Excel written succesfully");
        return fileName;
    }

}
