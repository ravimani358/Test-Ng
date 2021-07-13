package Excel_sheet_read;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class read_full_excel {
	
	
public static void main(String[] args) throws IOException {
	
	XSSFWorkbook wb = new XSSFWorkbook("./Data_Driven/CreateLead.xlsx");
	
	XSSFSheet ws = wb.getSheet("sheet1");
	
	int lastRowNum = ws.getLastRowNum(); // to get the row count
			
	int lastCellNum = ws.getRow(1).getLastCellNum(); // to get last cell count that is equal to column count
		
	for(int i = 1; i<=lastRowNum; i++) {
		for(int j = 0; j<lastCellNum; j++) {
			
			String stringCellValue = ws.getRow(i).getCell(j).getStringCellValue();
			
			System.out.println(stringCellValue);
			
		}
	}
	
	
	
	
	}		
}