package ExcelPractise;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

public class WriteExcel {
	
	public void writedata(String sheetname,int row,int cell,String cellValue) throws Exception
	{
		String ExcelPath=System.getProperty("user.dir")+"\\src\\test\\resources\\TestData\\TestData.xlsx";
		File file=new File(ExcelPath);
		FileInputStream fis=new FileInputStream(file);
		XSSFWorkbook wb= new XSSFWorkbook(fis);
		XSSFSheet sheet=wb.getSheet(sheetname);
		sheet.getRow(row).createCell(cell).setCellValue(cellValue);
		FileOutputStream fos=new FileOutputStream(new File(ExcelPath));
		wb.write(fos);
		wb.close();
		fos.close();
	}
	
	@Test
	public void validatesheet() throws Exception
	{
		WriteExcel w=new WriteExcel();
		w.writedata("Data",0,2,"suraj");
	}

}
