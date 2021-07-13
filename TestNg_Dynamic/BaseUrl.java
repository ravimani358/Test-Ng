package TestNg_Dynamic;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseUrl {
	
	public ChromeDriver driver;
	
	public String ExcelFileName;
	
	@Parameters({"url","user_name","password"})
	
	
	@BeforeMethod
	public void baseUrl(String url, String user_name, String password) {
				
		WebDriverManager.chromedriver().setup();
		
		driver = new ChromeDriver();
		
		driver.get(url);
		
		driver.manage().window().maximize();
		
		driver.findElement(By.id("username")).sendKeys(user_name);
		
		driver.findElement(By.id("password")).sendKeys(password);
		
		driver.findElement(By.className("decorativeSubmit")).click();
		
		driver.findElement(By.ByTagName.linkText("CRM/SFA")).click();
		
		driver.findElement(By.ByTagName.linkText("Leads")).click();
		
	}
	
	@AfterMethod
	public void close_browser() {
		
		driver.close();
		
	}
	
	@DataProvider(name = "fetchData", indices = 0) 
	
	public String[][] receive_from_Excel_sheet() throws IOException{
		
		Excel_sheet re = new Excel_sheet();
		
		return re.ReadData(ExcelFileName); //---> now the file name is hard corded and past the global name
		
	}

}
