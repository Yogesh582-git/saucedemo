package com.automation.utilities;

import java.io.IOException;

import org.testng.annotations.DataProvider;

public class DataProviders {
	
	
	@DataProvider(name="logindata")
	public String[][] getData() throws IOException{
		String path=".\\DDT.xlsx";
		ExcelUtility eu= new ExcelUtility(path);
		
		int totalRows=eu.getRowCount("Sheet1");
		int totalCol=eu.getcolCount("Sheet1", 1);
		
		String[][] loginData= new String[totalRows][totalCol];
		for(int i=1;i<=totalRows;i++) {
			for(int j=0;j<totalCol;j++) {
				loginData[i-1][j]=eu.getCellData("Sheet1", i, j);
			}
		}
		return loginData;
		
	}

}
