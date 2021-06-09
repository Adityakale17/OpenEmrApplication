package com.cyient.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtils {
	public static Object[][] getSheetIntoObjectArray(String filePath,String sheetname) throws IOException
	{
FileInputStream file = new FileInputStream(filePath);
		
		XSSFWorkbook book = new XSSFWorkbook(file);
		
		XSSFSheet sheet = book.getSheet(sheetname);
		
		int rowCount = sheet.getPhysicalNumberOfRows();
		System.out.println("Number of rows:"+rowCount);
		
		int cellCount = sheet.getRow(0).getPhysicalNumberOfCells();
		System.out.println("Number of cell:"+cellCount);
		
		DataFormatter format = new DataFormatter();
		
		Object[][] main=new Object[2][4];
		
		for(int r = 1;r < rowCount;r++)
		{
			for(int c = 0;c < cellCount;c++)
			{
				XSSFRow row = sheet.getRow(r);
				
				XSSFCell cell = row.getCell(c);	
				
				String cellvalue = format.formatCellValue(cell);
				//System.out.println(cellvalue);
				
				main[r-1][c] = cellvalue;
			}
		}
		return main;
	}

}
