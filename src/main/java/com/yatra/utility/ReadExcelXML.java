package com.yatra.utility;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.lang.reflect.Method;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;

public class ReadExcelXML {
	@DataProvider(name= "testdata")
	public String[][] getData(Method m) throws EncryptedDocumentException, IOException {
		String excelsheetname	 = m.getName();
		File f = new File(System.getProperty("user.dir")+"\\src\\test\\resources\\testdata\\testdata.xlsx");
		FileInputStream fis = new FileInputStream (f);
		Workbook wb = WorkbookFactory.create(fis);
		Sheet sheetname = wb.getSheet(excelsheetname);
		
		int totalRows = sheetname.getLastRowNum();
		 System.out.println(totalRows);
		 Row rowCell = sheetname.getRow(0);
		 int totalCells =rowCell.getLastCellNum();
		 System.out.println(totalCells);
		 DataFormatter format =new DataFormatter();
		 String testData[][] =new String [totalRows][totalCells];
		 for (int i =1 ; i<=totalRows;i++) {
			 for (int j=0;j<totalCells;j++) {
				 testData[i-1][j]=format.formatCellValue(sheetname.getRow(i).getCell(j));
				 System.out.println(testData[i-1][j]);
			 }
		 }
		 return testData;
		

	}
	}