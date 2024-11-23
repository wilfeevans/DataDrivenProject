package TestCase;

import java.time.Duration;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

import Base.BaseTest;
import Utilities.ExcelUtil;

public class addCustomer extends BaseTest {

	@Test(dataProviderClass = ExcelUtil.class, dataProvider = "dp")
	public void addCustomers(String firstname, String lastname, String pincode)
	{
				
		click("ac_btn_xpath");
		type("fname_text_xpath",firstname);
        type("lname_text_xpath",lastname);
		type("pcode_text_xpath",pincode);
		click("acc_btn_xpath");
		
		String alert= driver.switchTo().alert().getText();
		System.out.println(alert);
		
				
		Assert.assertEquals("Customer added successfully with customer id :6", alert);
		
		Alert alerts= driver.switchTo().alert();
		alerts.accept();
	
		
		
		
		
		

	}

}
