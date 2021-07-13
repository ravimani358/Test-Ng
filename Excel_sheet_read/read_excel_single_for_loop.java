package Excel_sheet_read;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class read_excel_single_for_loop {
	
	public static void main(String[] args) throws IOException {
		
		
		XSSFWorkbook wb = new XSSFWorkbook("./Data_Driven/CreateLead.xlsx");
		
		XSSFSheet ws = wb.getSheet("sheet1");
		
		int lastRowNum = ws.getLastRowNum(); //-> Excluding the Header values
		
		System.out.println("Excluding the Header values " + lastRowNum);
		
		int physicalNumberOfRows = ws.getPhysicalNumberOfRows();
		
		System.out.println("Including the Header Values " + physicalNumberOfRows); //-> Including the Header Values
		
		for(int i = 0; i<lastRowNum; i++) {
		
			String data = ws.getRow(i).getCell(0).getStringCellValue();
			
			System.out.println(data);
		
		}
		wb.close();
		
	}

}


//XSSFRow row = ws.getRow(1);
//
//XSSFCell cell = row.getCell(0);
//
//String CellValue = cell.getStringCellValue();
//
//System.out.println(CellValue);