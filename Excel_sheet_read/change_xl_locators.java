package Excel_sheet_read;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class change_xl_locators {

	public String[][] ReadData(String fileName) throws IOException { 

		XSSFWorkbook wb = new XSSFWorkbook("./Data_Driven/"+fileName+".xlsx");

		XSSFSheet ws = wb.getSheet("sheet1");

		int lastRowNum = ws.getLastRowNum();

		int lastCellNum = ws.getRow(1).getLastCellNum();
		
		// Declare 2Dimension Array
		String [][] data = new String[lastRowNum][lastCellNum]; 
			
		for(int i = 1; i<=lastRowNum; i++) {
			for(int j = 0; j<lastCellNum; j++) {

				String stringCellValue = ws.getRow(i).getCell(j).getStringCellValue();
				
				System.out.println(stringCellValue);
				
				data[i-1][j] = stringCellValue;
			}
		}

		wb.close();
		
		return data;


	}

}
