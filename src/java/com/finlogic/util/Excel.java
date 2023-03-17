/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.finlogic.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Iterator;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.FillPatternType;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Component;

/**
 *
 * @author njuser
 */
@Component
public class Excel {

    private FileInputStream file;
    private XSSFWorkbook workbook;
    private XSSFSheet sheet;
    private final int HEADER_INDEX = 0;

    public void openWorkBook(String filename) throws IOException {
        File excelFile = new File(filename);
        file = new FileInputStream(excelFile);
        workbook = new XSSFWorkbook(file);

    }

    public void writeToWorkBook(String filename) throws IOException {
        File file = new File(filename);
        String fileName = file.getName();
        System.out.println("File NAme " + fileName);
        FileOutputStream fos = new FileOutputStream(filename);
        workbook.write(fos);
        fos.close();
    }

    public void closeWorkBook() throws IOException {
        file.close();
    }

    public int getNumberOfSheets() {
        return workbook.getNumberOfSheets();
    }

    public String getSheetName(int index) {
        return workbook.getSheetName(index);
    }

    public XSSFSheet getSheetByName(String sheetName) {
        sheet = workbook.getSheet(sheetName);
        return workbook.getSheet(sheetName);
    }

    public XSSFSheet getSheetByIndex(int index) {
        sheet = workbook.getSheetAt(index);
        return workbook.getSheetAt(index);
    }

    public Iterator<Row> getRows() {
        return sheet.iterator();
    }

    public Iterator<Cell> getRowCells(Row row) {
        return row.cellIterator();
    }

    public int getCellType(Cell cell) {
        return cell.getCellType();
    }

    public int getTotalRows() {
        return sheet.getLastRowNum();
    }

    public int getNoOfRows() {
        return sheet.getLastRowNum();
    }

    XSSFCell getCell(int row, int col) {
        return sheet.getRow(row).getCell(col);
    }

    public XSSFCellStyle getErrorCellStyle() {
        XSSFCellStyle error = workbook.createCellStyle();
        error.setFillBackgroundColor(IndexedColors.RED.getIndex());
        error.setFillPattern(FillPatternType.BIG_SPOTS);
        return error;
    }

    public Row getHeaderRow() {
        return sheet.getRow(HEADER_INDEX);
    }

    
    
}
