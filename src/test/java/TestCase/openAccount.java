package TestCase;

import org.openqa.selenium.Alert;
import org.openqa.selenium.ElementClickInterceptedException;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;

import Base.BaseTest;
import Utilities.ExcelUtil;

@Test(dataProviderClass = ExcelUtil.class, dataProvider="dp")
public class openAccount extends BaseTest
{
    public static void openaccounts(String customername, String currency)
    {
    	click("OpenAccount_Btn_xpath");
    	select("customername_xpath", customername);
    	select("currancy_xpath", currency );
    	click("process_xpath");
    	
    	
    	
    }
	
	
	
}
