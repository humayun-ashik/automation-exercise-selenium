package automation.utils;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileInputStream;

public class ReadExcelFile {
    XSSFWorkbook wb;
    XSSFSheet sheet;

    public ReadExcelFile(String excelPath) {
        try {
            File src = new File(excelPath);
            FileInputStream fis = new FileInputStream(src);
            wb = new XSSFWorkbook(fis);
        }catch(Exception e) {
            System.out.println(e.getMessage());
        }


    }


    public String getData(int sheetnumber, int row, int column) {
        sheet = wb.getSheetAt(sheetnumber);
        String data = sheet.getRow(row).getCell(column).getStringCellValue();
        return data;
    }

    public Boolean getBoolData(int sheetnumber, int row, int column) {
        sheet = wb.getSheetAt(sheetnumber);
        Boolean data = sheet.getRow(row).getCell(column).getBooleanCellValue();
        return data;
    }


    public int getRowCount(int sheetIndex) {
        int row = wb.getSheetAt(sheetIndex).getLastRowNum();
        row = row + 1;
        return row;
    }


    public String getCellValue(XSSFCell cell) {
        switch (cell.getCellType()) {
            case NUMERIC:
                return String.valueOf(cell.getNumericCellValue());
            case BOOLEAN:
                return String.valueOf(cell.getBooleanCellValue());
            case STRING:
                return cell.getStringCellValue();
            default:
                return cell.getStringCellValue();
        }
    }

}

