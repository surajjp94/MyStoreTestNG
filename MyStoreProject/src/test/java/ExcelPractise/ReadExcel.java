package ExcelPractise;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;


public class ReadExcel {
	
	@Test
	public void readexcel() throws Exception
	{
	String ExcelPath=System.getProperty("user.dir") + "\\src\\test\\resources\\TestData\\TestData.xlsx";
	String WorkBookName="TestData";
	String SheetName="Data";
	
	File file=new File(ExcelPath);
	FileInputStream fis = new FileInputStream(file);
	XSSFWorkbook wb=new XSSFWorkbook(fis);
	XSSFSheet sheet=wb.getSheet(SheetName);
	int rowcount=sheet.getLastRowNum();
	
	String data1=sheet.getRow(0).getCell(1).getStringCellValue();
	
	for(int i=0;i<rowcount;i++) {
		XSSFRow row=sheet.getRow(i);
		for(int j=0;j<row.getLastCellNum();j++)
		{
			sheet.getRow(i).getCell(j).getStringCellValue();
		}
	}
		
	
	}	

}
