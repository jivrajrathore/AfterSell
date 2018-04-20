package com.GladMinds.afterSell.GenericLib;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelData {
	private static File f = null;
	private static FileInputStream fis = null;
	private static XSSFWorkbook workbook = null;
	private static XSSFSheet sheet = null;
	private static XSSFRow rowNum = null;
	private static XSSFCell cellNum = null;


	public static int getRowCOunt(String shheetName) throws Exception {
		f = new File("TestData//location.xlsx");
		fis = new FileInputStream(f);
		workbook = new XSSFWorkbook(fis);
		int num = workbook.getSheetIndex(shheetName);
		if (num < 0) {
			return 0;
		} else {
			sheet = workbook.getSheetAt(num);
			System.out.println("first row index of " + shheetName + " " + (sheet.getFirstRowNum()));
			int rowNum = sheet.getLastRowNum();
			return rowNum;
		}
	}

	public static int getCellRowNum(String shheetName, int columnNumber, String lastcellValue) throws Exception {
		
		fis = new FileInputStream(f);
		workbook = new XSSFWorkbook(fis);
		for (int i = 1; i <= getRowCOunt(shheetName); i++) {
			sheet = workbook.getSheet(shheetName);
			String value = sheet.getRow(i).getCell(columnNumber).getStringCellValue();
			if (value.equalsIgnoreCase(lastcellValue)) {
				return i;
			}

		}
		return -1;
	}
	public static String getCellData(String shheetName, int cellNum, int rowNum ) {
		
		sheet = workbook.getSheet(shheetName);
		 XSSFCell cell = sheet.getRow(rowNum).getCell(cellNum);
		 if(cell !=null) {
		 switch(cell.getCellTypeEnum()){
			 case STRING :
				return cell.getStringCellValue();
			 case BOOLEAN : 
				 return cell.getStringCellValue();
			 case FORMULA :
				 return Integer.toString((int) cell.getNumericCellValue());
			 case NUMERIC :
				 String cellText = "";
				 if (HSSFDateUtil.isCellDateFormatted(cell)) {
						// format in form of MM/DD/YYYY
						DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
						Date date = cell.getDateCellValue();
						Calendar cal = Calendar.getInstance();
						cal.setTime(date);
						cellText = formatter.format(date);
						// System.out.println(" is a date: " + cellText);
						return cellText;
		 }
				 else {
						// System.out.println("cell "+cell.getNumericCellValue());
						double numCellValue = cell.getNumericCellValue();
						// System.out.println(" is a number: " + numCellValue);
						if (numCellValue % 1 == 0) {
							cellText = Integer.toString((int) numCellValue);
							// System.out.println(" is an integer number: " +
							// cellText);
						} else {
							cellText = Double.toString((double) numCellValue);
							// System.out.println(" is a double number: " +
							// numCellValue);
						}
						return cellText;
		 } 
				 default : System.out.println("cell type is not recognized");
				 return "";
	}
}
		return "";
}
	public static void setCellValue(String sheetname, int columnNumber, int rowNum, String setValue) throws IOException {
		
		workbook.getSheet(sheetname).getRow(rowNum).getCell(columnNumber).setCellValue(setValue);
		f = new File("TestData//location.xlsx");
		FileOutputStream fos = new FileOutputStream(f);
		workbook.write(fos);
		fis.close();
	}
}