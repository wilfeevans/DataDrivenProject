package Base;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.time.Duration;
import java.util.Properties;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import ExtentListener.ExtentListeners;
import Utilities.DbManager;
import Utilities.ExcelReader;
import Utilities.MonitoringMail;

public class BaseTest
{

	public static WebDriver driver;
	public static Properties OR=new Properties();
	public static Properties config=new Properties();
	public static ExcelReader excel;
	DbManager db;
	MonitoringMail mail= new MonitoringMail();
	FileInputStream fis;
	public static WebDriverWait wait;
	public static Logger log= Logger.getLogger(BaseTest.class);
	public static WebElement dropdown;
	
	
	
	public static void click(String locator)
	{
		if(locator.endsWith("_xpath"))
		{
			driver.findElement(By.xpath(OR.getProperty(locator))).click();
		}
		
		else if(locator.endsWith("_name"))
		{
			driver.findElement(By.name(OR.getProperty(locator))).click();
		}
		
		else if(locator.endsWith("_css"))
		{
			driver.findElement(By.cssSelector(OR.getProperty(locator))).click();
		}
		else if(locator.endsWith("_id"))
		{
			driver.findElement(By.id(OR.getProperty(locator))).click();
		}
		
		log.info("Click method is invoked" + locator);
		ExtentListeners.test.info("Click on elements" +locator);
		
		
	}
	
	
	public static void type(String locator, String value)
	{
		if(locator.endsWith("_xpath"))
		{
			driver.findElement(By.xpath(OR.getProperty(locator))).sendKeys(value);
		}
		
		else if(locator.endsWith("_name"))
		{
			driver.findElement(By.name(OR.getProperty(locator))).sendKeys(value);
		}
		
		else if(locator.endsWith("_css"))
		{
			driver.findElement(By.cssSelector(OR.getProperty(locator))).sendKeys(value);
		}
		else if(locator.endsWith("_id"))
		{
			driver.findElement(By.id(OR.getProperty(locator))).sendKeys(value);
		}
		
		log.info("Type method is invoked:" + locator + " value is send:" +value);
		ExtentListeners.test.info("Type on elements:" +locator + "value is populated:" + value);
		
		
	}
	
	
	public static void select(String locator, String value)
	{
		if(locator.endsWith("_xpath"))
		{
			dropdown= driver.findElement(By.xpath(OR.getProperty(locator)));
		}
		
		else if(locator.endsWith("_name"))
		{
			dropdown=driver.findElement(By.name(OR.getProperty(locator)));
		}
		
		else if(locator.endsWith("_css"))
		{
			dropdown= driver.findElement(By.cssSelector(OR.getProperty(locator)));
		}
		else if(locator.endsWith("_id"))
		{
			dropdown= driver.findElement(By.id(OR.getProperty(locator)));
		}
		
		Select select= new Select(dropdown);
		select.selectByVisibleText(value);
		
		log.info("Type method is invoked:" + locator + " value is send:" +value);
		ExtentListeners.test.info("Type on elements:" +locator + "value is populated:" + value);
		
		
	}
	
	
	public static boolean isElementPresent(String locator)
	{
		try
		{
		if(locator.endsWith("_xpath"))
		{
			driver.findElement(By.xpath(OR.getProperty(locator)));
		}
		
		else if(locator.endsWith("_name"))
		{
			driver.findElement(By.name(OR.getProperty(locator)));
		}
		
		else if(locator.endsWith("_css"))
		{
			driver.findElement(By.cssSelector(OR.getProperty(locator)));
		}
		else if(locator.endsWith("_id"))
		{
			driver.findElement(By.id(OR.getProperty(locator)));
		}
		}
		
		catch(Throwable t)
		{
			return false;
		}
		log.info("Type method is invoked:" + locator);
		ExtentListeners.test.info("Type on elements:" +locator);
		
		return true;
			
	}
	
	@BeforeSuite
	public void setUp() throws IOException, ClassNotFoundException, SQLException
	{
		PropertyConfigurator.configure("./src/test/resources/properties/log4j.properties");
		
		fis= new FileInputStream("./src/test/resources/properties/OR.properties");
		OR.load(fis);
		
		fis= new FileInputStream("./src/test/resources/properties/Config.properties");
		config.load(fis);
		
		if(config.getProperty("browser").equals("chrome"))
		{
			driver= new ChromeDriver();
		}
		
		else if(config.getProperty("browser").equals("firefox"))
		{
			driver= new FirefoxDriver();			
		}
		
		excel=new ExcelReader("./src/test/resources/Excel/Exceldata.xlsx");
		driver.get(config.getProperty("url"));
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		wait= new WebDriverWait(driver,Duration.ofSeconds(Integer.parseInt(config.getProperty("implicity_wait"))));
		db.setMysqlDbConnection();
		log.info("Database Connection Established");
		}
	
	@AfterSuite
	public void tearDown()
	{
		//driver.quit();
		//log.info("Test Execution Completed! ");
		
	}
	
	
}
