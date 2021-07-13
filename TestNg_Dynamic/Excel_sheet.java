package TestNg_Dynamic;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel_sheet {

	
	public String[][] ReadData(String filename) throws IOException { //-----------------> (4) do "change Void to String[][]"

		XSSFWorkbook wb = new XSSFWorkbook("./Data_Driven/"+filename+".xlsx");

		XSSFSheet ws = wb.getSheet("sheet1");

		int lastRowNum = ws.getLastRowNum(); // to get the row count

		int lastCellNum = ws.getRow(1).getLastCellNum(); // to get last cell count that is equal to column count
		
		// Declare 2Dimension Array
		String [][] data = new String[lastRowNum][lastCellNum]; //---------->(1) do
			
		for(int i = 1; i<=lastRowNum; i++) {
			for(int j = 0; j<lastCellNum; j++) {

				String stringCellValue = ws.getRow(i).getCell(j).getStringCellValue();
				
				System.out.println(stringCellValue);
				
				data[i-1][j] = stringCellValue; //------------------> (2) do
			}
		}

		wb.close();
		
		return data; //--------------------> (3) do 


	}


}
