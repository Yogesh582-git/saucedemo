package com.automation.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtility {
	public XSSFWorkbook wb;
	public FileInputStream fi;
	public FileOutputStream fo;
	public XSSFSheet sh;
	public XSSFRow rw;
	public XSSFCell cl;
	String path;

	public ExcelUtility(String path) {
		this.path = path;
	}

	public int getRowCount(String sheet) throws IOException {
		fi = new FileInputStream(path);
		wb = new XSSFWorkbook(fi);
		sh = wb.getSheet(sheet);
		int row = sh.getLastRowNum();
		return row;
	}

	public int getcolCount(String sheet, int row) throws IOException {
		FileInputStream fi = new FileInputStream(path);
		XSSFWorkbook wb = new XSSFWorkbook(fi);
		sh = wb.getSheet(sheet);
		rw = sh.getRow(row);
		int colCount = rw.getLastCellNum();
		return colCount;
	}

	public String getCellData(String sheet, int row, int col) throws IOException {
		fi = new FileInputStream(path);
		wb = new XSSFWorkbook(fi);
		sh = wb.getSheet(sheet);
		rw = sh.getRow(row);
		XSSFCell cellData = rw.getCell(col);
		DataFormatter data = new DataFormatter();
		String exData;
		try {
			exData = data.formatCellValue(cellData);

		} catch (Exception e) {
			exData = "";
		}
		return exData;
	}

	public void setCellData(String sheet, int row, int col, String data) throws IOException {
		File fl = new File(path);
		if (!fl.exists()) {
			XSSFWorkbook wb = new XSSFWorkbook();
			FileOutputStream fo = new FileOutputStream(path);
			wb.write(fo);
		}
		FileInputStream fi = new FileInputStream(path);
		wb = new XSSFWorkbook(fi);

		if (wb.getSheetIndex(sheet) == -1) {
			wb.createSheet(sheet);
		}
		sh = wb.getSheet(sheet);

		if (sh.getRow(row) == null)
			sh.createRow(row);
		rw = sh.getRow(row);

		cl = rw.createCell(col);
		cl.setCellValue(data);
		FileOutputStream fo = new FileOutputStream(path);
		wb.write(fo);
		wb.close();
		fi.close();
		fo.close();

	}

}
