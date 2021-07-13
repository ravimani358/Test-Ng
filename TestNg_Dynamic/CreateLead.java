package TestNg_Dynamic;


import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class CreateLead extends BaseUrl{
	
	//Create the method for Excel files to upload
	
	@BeforeTest //---> feature we will revil the why we use this
	public void setFileName() {
		ExcelFileName = "CreateLead";  // "ExcelFileName" cames from base url return values
	}

	@Test(dataProvider = "fetchData") //------------>7(do)
	public void createLead(String Company, String firstName, String lastName, String phoneNo) { //--> pass the variable
	
	driver.findElement(By.xpath("//a[text() = 'Create Lead']")).click();
	
	driver.findElement(By.id("createLeadForm_companyName")).sendKeys(Company);
	
	driver.findElement(By.id("createLeadForm_firstName")).sendKeys(firstName);
	
	driver.findElement(By.id("createLeadForm_lastName")).sendKeys(lastName);
	
	driver.findElement(By.id("createLeadForm_primaryPhoneNumber")).sendKeys(phoneNo);
	
	WebElement DropDown_Input = driver.findElement(By.id("createLeadForm_dataSourceId"));
	
	Select drop_Down = new Select(DropDown_Input);
	
	drop_Down.selectByValue("LEAD_COLDCALL");
	
	driver.findElement(By.id("createLeadForm_birthDate")).sendKeys("2/01/97");
	
	driver.findElement(By.className("smallSubmit")).click();
	
	driver.findElement(By.ByTagName.linkText("Duplicate Lead")).click();
	
	driver.findElement(By.id("createLeadForm_companyName")).clear();
	
	driver.findElement(By.id("createLeadForm_companyName")).sendKeys("Google");
	
	driver.findElement(By.className("smallSubmit")).click();
	
	String Company_name = driver.findElement(By.id("viewLead_companyName_sp")).getText();
	
	System.out.println("company name "+ Company_name);
	
	}	
	
}
