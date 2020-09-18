package com.frame;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.*;

public class ExcelProcess {
	String filepath = null;

	public ExcelProcess(String filepa) {
		this.filepath = filepa;
	}

	public XSSFWorkbook workbook = null;

	public void setup() throws Exception {
		File file = new File(filepath);
		InputStream is = new FileInputStream(file.getAbsolutePath());
		//定义工作簿
		workbook = new XSSFWorkbook(is);
		is.close();
	}

	public void close() {
		try {
			workbook.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void save(String file) throws Exception {
		FileOutputStream os = new FileOutputStream(file);
		workbook.write(os);
		os.flush();
		os.close();
	}

	public void createSheet(String sheetname) {
		XSSFSheet sheet = workbook.createSheet(sheetname);
	}
	public int getSheetnum(String sheetname) {
		return workbook.getSheetIndex(sheetname);
	}
	public String getcellcontent(int sheetnum, int row, int column) {
		XSSFSheet sheet = workbook.getSheetAt(sheetnum);
		if (sheet.getRow(row).getCell(column) == null || sheet.getRow(row).getCell(column).equals(""))
			return null;
		else
			return sheet.getRow(row).getCell(column).getStringCellValue();
	}

	public int getrowcount(int sheetnum) {
		XSSFSheet sheet = workbook.getSheetAt(sheetnum);
		return sheet.getPhysicalNumberOfRows();
	}

	public boolean iscellnull(int i, int j, int k) {
		XSSFSheet sheet = workbook.getSheetAt(i);
		XSSFCell cell = sheet.getRow(j).getCell(k);
		if (cell == null ||cell.equals("") ||cell.getCellType() == XSSFCell.CELL_TYPE_BLANK) {
			return true;
		} else{
			if(cell.getStringCellValue().trim().isEmpty())
				return true;
			else
				return false;
		}
			
	}

	public void write(String sheetname, int row, int column, String cotent) {
		XSSFSheet sheet = workbook.getSheet(sheetname);
		XSSFCell cell = sheet.getRow(row).createCell(column);
		cell.setCellValue(cotent);
	}

	public void write(int sheetnum, int row, int column, String cotent) {
		XSSFSheet sheet = workbook.getSheetAt(sheetnum);
		XSSFCell cell = sheet.getRow(row).createCell(column);
		cell.setCellValue(cotent);
	}
	public void createrow(int sheetnum, int row) {
		XSSFSheet sheet = workbook.getSheetAt(sheetnum);
		XSSFRow row1 = sheet.createRow(row);
	}
}