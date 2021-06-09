package com.cyient.test;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DemoTest2 {

	public static void main(String[] args) throws IOException {
	
		FileInputStream file = new FileInputStream("src/test/resources/testdata/validCredintialTest.xlsx");
		
		XSSFWorkbook book = new XSSFWorkbook(file);
		
		XSSFSheet sheet = book.getSheet("validCredentialTest");
		
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
		System.out.println(main[0][0]);
		System.out.println(main[0][1]);
		System.out.println(main[0][2]);
		System.out.println(main[0][3]);
		
		System.out.println(main[1][0]);
		System.out.println(main[1][1]);
		System.out.println(main[1][2]);
		System.out.println(main[1][3]);
	}

}
