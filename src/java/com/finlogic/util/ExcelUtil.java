/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.finlogic.util;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import org.apache.commons.collections.map.ListOrderedMap;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
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

    public List<Map<String, String>> readExcel(String fileName, int columns) throws IOException {
        List<Map<String, String>> list = new ArrayList<>();
        DataFormatter dataFormatter = new DataFormatter();
        Excel excel = new Excel();
        excel.openWorkBook(fileName);

        excel.getSheetByIndex(0);

        Iterator<Row> rowIterator = excel.getRows();
        Row headerRow = excel.getHeaderRow();

        if (rowIterator.hasNext()) {
            rowIterator.next();
        }
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();

            Map<String, String> data = new ListOrderedMap();

            for (int c = 0; c < columns; c++) {
                Cell cell = row.getCell(c);
                Cell header = headerRow.getCell(c);
                String key = dataFormatter.formatCellValue(header);
                String value = null;

                if (cell == null || cell.getCellType() == Cell.CELL_TYPE_BLANK || cell.getCellType() == Cell.CELL_TYPE_ERROR) {
                    value = "";
                } else {
                    value = dataFormatter.formatCellValue(cell);
                }
                data.put(key, value);
            }
            String id = UUID.randomUUID().toString();
            data.put("_id", id);
            list.add(data);
        }

        return list;

    }

    public String validateExcel(String fileName, int columns) throws IOException {
        Excel excel = new Excel();
        excel.openWorkBook(fileName);
        int flag = 0;

        excel.getSheetByIndex(0);

        Iterator<Row> rowIterator = excel.getRows();
        while (rowIterator.hasNext()) {
            Row row = rowIterator.next();

            for (int c = 0; c < columns; c++) {
                Cell cell = row.getCell(c);

                if (cell == null || cell.getCellType() == Cell.CELL_TYPE_BLANK || cell.getCellType() == Cell.CELL_TYPE_ERROR) {
                    flag = 1;
                    cell = row.createCell(c);
                    cell.setCellStyle(excel.getErrorCellStyle());
                }
            }
        }

        if (flag == 1) {
            excel.writeToWorkBook(CommonUtil.errorFilePath() + "error.xlsx");
            return "0";
        }
        return "1";
    }
    
}
