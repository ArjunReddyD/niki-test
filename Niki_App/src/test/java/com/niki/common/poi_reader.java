package com.niki.common;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class poi_reader {

	public static String[][] readExcelData(String filePath,String sheetName,String tableName) {
		String[][] testData = null;

		if(filePath.contains("xlsx")){
			try {
				XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(filePath));
				XSSFSheet sheet = workbook.getSheet(sheetName);
				XSSFCell[] boundaryCells = findCell(sheet, tableName);
				XSSFCell startCell = boundaryCells[0];
				XSSFCell endCell = boundaryCells[1];
				int startRow = startCell.getRowIndex() + 1;
				int endRow = endCell.getRowIndex() - 1;
				int startCol = startCell.getColumnIndex() + 1;
				int endCol = endCell.getColumnIndex() - 1;

				testData = new String[endRow - startRow + 1][endCol - startCol + 1];
				System.out.println("start row:"+startRow+":end row:"+endRow+":start col:"+startCol+":endcol:"+endCol);
				for (int i = startRow; i < endRow + 1; i++) {
					for (int j = startCol; j < endCol + 1; j++) {
						if(sheet.getRow(i).getCell(j).getCellType()==1){
							testData[i - startRow][j - startCol] = sheet.getRow(i)
							.getCell(j).getStringCellValue();
							System.out.println("test data if:"+testData[i - startRow][j - startCol]);
						}
						else if(sheet.getRow(i).getCell(j).getCellType()==0) {
							if(DateUtil.isCellDateFormatted(sheet.getRow(i).getCell(j))){
								String month = (new Integer(sheet.getRow(i).getCell(j).getDateCellValue().getMonth()+1)).toString();
								String day = new Integer(sheet.getRow(i).getCell(j).getDateCellValue().getDate()).toString();
								String year = (new Integer(sheet.getRow(i).getCell(j).getDateCellValue().getYear()+1900)).toString();
								if (day.length() == 1)
									day = "0"+day;
								if(month.length()==1)
									month = "0"+month;
								String date = month+"/"+day+"/"+year;
								//System.out.println(date+"  date");
								testData[i - startRow][j - startCol] = date;
								System.out.println("test data elseif:"+testData[i - startRow][j - startCol]);
							}
							else{
								Long st = new Long((long)sheet.getRow(i).getCell(j).getNumericCellValue()); 
								
								String strCellValue = String.valueOf(i); 
								testData[i - startRow][j - startCol] = new Long((long) sheet.getRow(i)
										.getCell(j).getNumericCellValue()).toString();
								
						
								System.out.println("test data else:"+testData[i-startRow][j-startCol]);
								
							}

						}
					}
				}

			} catch (FileNotFoundException e) {
				System.out.println("Could not read the Excel sheet");
				e.printStackTrace();
			} catch (IOException e) {
				System.out.println("Could not read the Excel sheet");
				e.printStackTrace();
			}

				
			
				
			
			return testData;
		}

		else{
			try {
				HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(
						filePath));
				HSSFSheet sheet = workbook.getSheet(sheetName);
				HSSFCell[] boundaryCells = findCell(sheet, tableName);
				HSSFCell startCell = boundaryCells[0];
				HSSFCell endCell = boundaryCells[1];
				int startRow = startCell.getRowIndex() + 1;
				int endRow = endCell.getRowIndex() - 1;
				int startCol = startCell.getColumnIndex() + 1;
				int endCol = endCell.getColumnIndex() - 1;

				testData = new String[endRow - startRow + 1][endCol - startCol + 1];

				for (int i = startRow; i < endRow + 1; i++) {
					for (int j = startCol; j < endCol + 1; j++) {
						if(sheet.getRow(i).getCell(j).getCellType()==1) {
							testData[i - startRow][j - startCol] = sheet.getRow(i)
									.getCell(j).getStringCellValue();
						}
						else if(sheet.getRow(i).getCell(j).getCellType()==0) {
							if(DateUtil.isCellDateFormatted(sheet.getRow(i).getCell(j))){
								String month = (new Integer(sheet.getRow(i).getCell(j).getDateCellValue().getMonth()+1)).toString();
								String day = new Integer(sheet.getRow(i).getCell(j).getDateCellValue().getDate()).toString();
								String year = (new Integer(sheet.getRow(i).getCell(j).getDateCellValue().getYear()+1900)).toString();
								if(day.length()==1)
									day = "0"+day;
								if(month.length()==1)
									month = "0"+month;
								String date = month+"/"+day+"/"+year;
								//System.out.println(date+"  date");
								testData[i - startRow][j - startCol] = date;
							}
							else{
								testData[i - startRow][j - startCol] = new Integer((int) sheet.getRow(i)
										.getCell(j).getNumericCellValue()).toString();
							}
						}
					}
				}

			} catch (FileNotFoundException e) {
				System.out.println("Could not read the Excel sheet");
				e.printStackTrace();
			} catch (IOException e) {
				System.out.println("Could not read the Excel sheet");
				e.printStackTrace();
			}
			return testData;
		}

	}

	public static XSSFCell[] findCell(XSSFSheet sheet, String text) {

		String pos = "start";

		XSSFCell[] cells = new XSSFCell[2];

		for (Row row : sheet) {
			for (Cell cell : row) {
				//System.out.println("get cell type:" +cell.getCellType());
				if(cell.getCellType()==1){
					if (text.equals(cell.getStringCellValue())) {
						if (pos.equalsIgnoreCase("start")) {
							cells[0] = (XSSFCell) cell;
							pos = "end";
						} else {
							cells[1] = (XSSFCell) cell;
						}
					}
				}
				else if(cell.getCellType()==0){
					if (text.equals(cell.getNumericCellValue())) {
						if (pos.equalsIgnoreCase("start")) {
							cells[0] = (XSSFCell) cell;
							System.out.println("get numeric cell value:" +cell.getNumericCellValue()+":cells 0:"+cells[0]);
							pos = "end";
						} else {
							cells[1] = (XSSFCell) cell;
							System.out.println("Else numeric cell value:" +cell.getNumericCellValue()+":cells 0:"+cells[1]);
						}
					}

				}

			}
		}
		return cells;

	}

	public static HSSFCell[] findCell(HSSFSheet sheet, String text) {

		String pos = "start";

		HSSFCell[] cells = new HSSFCell[2];

		for (Row row : sheet) {
			for (Cell cell : row) {
			//	System.out.println("get cell type:" +cell.getCellType());
				if (cell.getCellType()==1) {
					
					if (text.equals(cell.getStringCellValue())) {
						if (pos.equalsIgnoreCase("start")) {
							cells[0] = (HSSFCell) cell;
							pos = "end";
						} else {
							cells[1] = (HSSFCell) cell;
						}
					}
				}
				else if (cell.getCellType()==0) { 
					if (text.equals(cell.getNumericCellValue())) {
						if (pos.equalsIgnoreCase("start")) {
							cells[0] = (HSSFCell) cell;
							System.out.println("get numeric cell value:" +cell.getNumericCellValue()+":cells 0:"+cells[0]);
							pos = "end";
						} else {
							cells[1] = (HSSFCell) cell;
							System.out.println("Else numeric cell value:" +cell.getNumericCellValue()+":cells 0:"+cells[0]);
						}
					}
				}
			}
		}
		return cells;
	}

	// This method is added for choosing the communiction type for mailing in personal information tab of eFiling application.
	public static String[] findCell(String filepath, String sheetname, String tag)  throws Exception, IOException{

		System.out.println("// This method is added for choosing the communiction type for mailing in personal information tab of eFiling application.");
		XSSFWorkbook workbook = new XSSFWorkbook(new FileInputStream(filepath));
		XSSFSheet sheet = workbook.getSheet(sheetname);

		String pos = "start";

		String[] cellvalue = new String[10];
		XSSFCell[] cells = new XSSFCell[10];
		int i=0;		
		int firsttagreach = 0;
		for (Row row : sheet) {
			for (Cell cell : row) {
			//	System.out.println("get cell type:" +cell.getCellType());
				if(cell.getCellType()==1){
					if (tag.equals(cell.getStringCellValue())) {
						pos = "end";
					}
				}
				else if(cell.getCellType()==0){
					if (tag.equals(cell.getNumericCellValue())) {
						System.out.println("get numeric cell value:" +cell.getNumericCellValue());
						pos = "end";
					}
				}
				if(pos.equalsIgnoreCase("end")){
					System.out.println("cell: "+cell);
					if(cell.getStringCellValue().equalsIgnoreCase(tag)&&firsttagreach!=0)
						break;
					else{
						cells[i]=(XSSFCell)cell;
						cellvalue[i]=cells[i].toString();
						i++;
					}
					firsttagreach++;
				}
			}
			if(pos.equalsIgnoreCase("end")){
				break;
			}
		}
		return cellvalue;
	}

}