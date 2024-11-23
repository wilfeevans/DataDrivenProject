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

public class bankManagerLogin extends BaseTest {

	@Test
	public void addCustomer()
	{
				
		click("bml_btn_xpath");
		Assert.assertTrue(isElementPresent("bml_btn_xpath"));
		
		
		
		
		
		
		

	}

}
