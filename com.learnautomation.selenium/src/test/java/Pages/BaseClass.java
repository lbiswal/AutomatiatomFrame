package Pages;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import io.github.bonigarcia.wdm.WebDriverManager;
import utility.ConfigReader;
import utility.ExcelDataprovider;
import utility.Helper;

public class BaseClass
{

	public WebDriver driver;
	public ExcelDataprovider excel;
	public ConfigReader config;
	public ExtentReports report;
	public ExtentTest logger;
	
	@BeforeSuite
	public void setUpSuite() {
		excel= new ExcelDataprovider();
		config = new ConfigReader();
		
		ExtentHtmlReporter extend = new ExtentHtmlReporter(new File(System.getProperty("user.dir")+"/Reports/ABCD.html"));
		report = new ExtentReports();
		report.attachReporter(extend);
	}

	@BeforeMethod
	public WebDriver intialisation() {
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get(config.getApplicationURL());
		return driver;
//page = new BasePage(driver);
	}
	@AfterMethod
	public void teardownMethod(ITestResult result) {
		if(result.getStatus() == ITestResult.FAILURE) {
			Helper.captureScreenshot(driver);
		}
		report.flush();
	}
	
	@AfterSuite
	public void tearDown() {
		driver.quit();
	}
	


}
