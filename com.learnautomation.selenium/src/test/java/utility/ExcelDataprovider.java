package utility;

import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelDataprovider {
	XSSFWorkbook wb;
	public ExcelDataprovider() {
		
		File src =new File("./TestData/Registration.xlsx");

		try {
			FileInputStream fis = new FileInputStream(src);
			wb = new XSSFWorkbook(fis);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Unable to read excel file"+e.getMessage());
		}
	}
	
	public String getStringData(String sheetName,int row,int column) {
	return	wb.getSheet(sheetName).getRow(row).getCell(column).getStringCellValue();
	}
	public double getNumericData(String sheetName,int row,int column) {
		return	wb.getSheet(sheetName).getRow(row).getCell(column).getNumericCellValue();
	}
	public String getStringData(int sheetIndex,int row,int column) {
		return	wb.getSheetAt(sheetIndex).getRow(row).getCell(column).getStringCellValue();
		}
}
