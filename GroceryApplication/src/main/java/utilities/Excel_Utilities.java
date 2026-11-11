package utilities;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import constant.Constant;

public class Excel_Utilities {
	
	static FileInputStream f; //FileInputStream - to read the excel file from the system.
	static XSSFWorkbook w; // XSSFWorkbook - to represent the entire excel workbook
	static XSSFSheet sh; // XSSFSheet - to represent a sheet in the excel workbook

	public static String readStringData(int row, int col, String sheet) throws IOException { 
		f = new FileInputStream(Constant.TEST_DATA); //to open the excel file from the location. Constant class is used to read the url
		w = new XSSFWorkbook(f);//to load excel file to the memory using apache poi.
		sh = w.getSheet(sheet);//to select the sheet named as "sheet1" from the workbook
		XSSFRow r = sh.getRow(row);//to get the row based on the row number passed as argument or parameter.
		XSSFCell c = r.getCell(col);//to get the entire cell based on the column number passed as argument
		return c.getStringCellValue();//to return the values in the cell in text(string) format

	}

	public static String readIntegerData(int row, int col, String sheet) throws IOException {
		f = new FileInputStream(Constant.TEST_DATA);
		w = new XSSFWorkbook(f);
		sh = w.getSheet(sheet);
		XSSFRow r = sh.getRow(row);
		XSSFCell c = r.getCell(col);//will get decimal values(double)
		int val =   (int) c.getNumericCellValue();  //convert double to int using typecasting,(to remove decimal values) converting a datatype to another datatype is known as typecasting.
		return String.valueOf(val);   //convert int to string using valueOf() method

	
	}


}
