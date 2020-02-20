package com.wqx.test.filetype.utils;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.List;

public class ExcelUtils {
    private static final String EXCEL_XLS = "xls";
    private static final String EXCEL_XLSX = "xlsx";

    /**
     * 判断Excel的版本,获取Workbook
     *
     * @param
     * @return
     * @throws IOException
     */
    public static Workbook getWorkbok(File file) throws IOException {
        Workbook wb = null;
        FileInputStream in = new FileInputStream(file);
        if (file.getName().endsWith(EXCEL_XLS)) {     //Excel&nbsp;2003
            wb = new HSSFWorkbook(in);
        } else if (file.getName().endsWith(EXCEL_XLSX)) {    // Excel 2007/2010
            wb = new XSSFWorkbook(in);
        }
        return wb;
    }

    public static void parse(File file) throws IOException {
        Workbook workbok = getWorkbok(file);
        int numberOfSheets = workbok.getNumberOfSheets();
        for (int i = 0; i < numberOfSheets; i++) {
            Sheet sheet = workbok.getSheetAt(i);
            int lastRowNum = sheet.getLastRowNum();
            for (int j = 0; j < lastRowNum; j++) {
                Row row = sheet.getRow(j);
                short lastCellNum = row.getLastCellNum();
                for (int c = 0; c < lastCellNum; c++) {
                    Cell cell = row.getCell(c);
                    String s = cell.toString();
                    System.out.println(s);
                }
            }
        }
    }
    public static<T> List<T> parse(File file , Class<T> clazz, String[] columnNames) throws IOException {
        Workbook workbok = getWorkbok(file);
        int numberOfSheets = workbok.getNumberOfSheets();
        for (int i = 0; i < numberOfSheets; i++) {
            Sheet sheet = workbok.getSheetAt(i);
            int lastRowNum = sheet.getLastRowNum();
            for (int j = 0; j < lastRowNum; j++) {
                Row row = sheet.getRow(j);
                short lastCellNum = row.getLastCellNum();
                for (int c = 0; c < lastCellNum; c++) {
                    Cell cell = row.getCell(c);
                    String s = cell.toString();
                    //System.out.println(s);
                    //if(j = 0 && columnNames != null && columnNames.length!= 0 && )
                }
            }
        }
        return null;
    }

    public static void main(String[] args) throws IOException {
        File file = new File("C:\\Users\\Administrator\\Desktop\\文件类型.xlsx");
        parse(file);
    }

}
