package com.cyj.excel;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class SheetHandler {

    /**
     * @Param file 导入的文件
     * @Param clazz T 的 class
     * @Param isHeader 是否有头部
     * */
    public static <T extends SheetRowConversion> SimpleImportStatus<T> importSheet(File file,Class clazz,boolean isHeader) throws IOException, InvalidFormatException {

        SimpleImportStatus<T> simpleImportStatus = new SimpleImportStatus<T>();
        List<T> batchAddList = new ArrayList<T>();
        List<String> msg = new ArrayList<>();
        int successCount = 0;
        int errorCount = 0;
        int totalCount = 0;
        try {
            Workbook workbook = WorkbookFactory.create(file);
            Sheet sheet = workbook.getSheetAt(0);

            totalCount = sheet.getLastRowNum();

            int begin = sheet.getFirstRowNum();
            if(isHeader) begin += 1;
            for (int i = begin; i <= sheet.getLastRowNum(); i++) {
                try {
                    Row row = sheet.getRow(i);
                    T t = (T) clazz.newInstance();
                    t.convertToModel(row);
                    batchAddList.add(t);
                    successCount++;
                    msg.add("第"+i+"条数据导入成功："+t.toString());
                }catch (Exception e){
                    e.printStackTrace();
                    msg.add("第"+i+"条数据导入出错："+e.getMessage());
                    errorCount++;
                }
            }
            simpleImportStatus.setTotalCount(totalCount);
            simpleImportStatus.setBatchAddList(batchAddList);
            simpleImportStatus.setFailCount(errorCount);
            simpleImportStatus.setSuccessCount(successCount);
            simpleImportStatus.setMsg(msg);
            simpleImportStatus.setSuccess(true);
        } catch (Exception e) {
            e.printStackTrace();
            simpleImportStatus.setErrorMsg("系统出错："+e.getMessage());
            simpleImportStatus.setSuccess(false);
        }
        return simpleImportStatus;
    }

    public static <T extends SheetRowConversion> void exportSheet(File file,List<String>header,List<T>data) throws Exception {
        Workbook workbook = new XSSFWorkbook();
        Sheet sheet = workbook.createSheet();
        Row headerRow = sheet.createRow(0);
        headerRow = setDefaultHeaderRow(workbook,headerRow,header);
        CellStyle cellStyle = getDefaultBodyStyle(workbook);
        if(data!=null&&data.size()!=0){
            for(int i=0;i<data.size();i++){
                Row row = sheet.createRow(i+1);
                row.setRowStyle(cellStyle);
                T t = data.get(i);
                row = t.convertToRow(row);
            }
        }
        try(FileOutputStream fileOutputStream = new FileOutputStream(file)){
            workbook.write(fileOutputStream);
        }
    }

    public static CellStyle getDefaultBodyStyle(Workbook workbook){
        CellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setBorderLeft(BorderStyle.THIN);
        return cellStyle;
    }

    public static CellStyle getDefaultBodyDateStyle(Workbook workbook){
        CellStyle cellStyle = getDefaultBodyStyle(workbook);
        CreationHelper createHelper = workbook.getCreationHelper();
        cellStyle.setDataFormat(createHelper.createDataFormat().getFormat("m/d/yy h:mm"));
        return cellStyle;
    }

    private static Row setDefaultHeaderRow(Workbook workbook,Row headerRow,List<String>header) {
        CellStyle cellStyle = workbook.createCellStyle();
        cellStyle.setAlignment(HorizontalAlignment.CENTER);
        cellStyle.setVerticalAlignment(VerticalAlignment.CENTER);
        cellStyle.setFillBackgroundColor((short) 10);
        cellStyle.setFillForegroundColor(IndexedColors.GREY_40_PERCENT.getIndex());
        cellStyle.setFillPattern(FillPatternType.SOLID_FOREGROUND);
        cellStyle.setBorderLeft(BorderStyle.THIN);
        for(int i=0;i<header.size();i++){
            Cell cell = headerRow.createCell(i);
            cell.setCellValue(header.get(i));
            cell.setCellStyle(cellStyle);
        }
        return headerRow;
    }


    public static String getStringValueFromCell(Cell cell){
        if(cell==null) return "";
        switch (cell.getCellType()){
            case Cell.CELL_TYPE_BLANK:  return "";
            case Cell.CELL_TYPE_BOOLEAN:return String.valueOf(cell.getBooleanCellValue());
            case Cell.CELL_TYPE_ERROR:  return "";
            case Cell.CELL_TYPE_STRING: return cell.getStringCellValue();
            case Cell.CELL_TYPE_FORMULA:return cell.getCellFormula();
            case Cell.CELL_TYPE_NUMERIC:return String.valueOf(cell.getNumericCellValue());
            default: return "";
        }
    }

    public static Timestamp getTimestampValueFromCell(Cell cell){
        try{
            Date value = cell.getDateCellValue();
            return new Timestamp(value.getTime());
        }catch(Exception e){
            e.printStackTrace();
            return null;
        }
    }

    public static double getNumericValueFromCell(Cell cell){
        try {
            double a = cell.getNumericCellValue();
            return (int) a;
        }catch (Exception e){
            e.getMessage();
            return 0;
        }
    }

}
