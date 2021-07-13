package Excel_sheet_read;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_sheet {

		
	public static void main(String[] args) throws IOException {
		
		XSSFWorkbook wb = new XSSFWorkbook("./Data_Driven/CreateLead.xlsx");
		
		XSSFSheet ws = wb.getSheet("sheet1");
		
		XSSFRow row = ws.getRow(1);
		
		XSSFCell cell = row.getCell(0);
		
		String CellValue = cell.getStringCellValue();
		
		System.out.println(CellValue);
		
		wb.close();
	}

}
