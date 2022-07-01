package testcases.dataDrivenTestCases;


import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;

import Pages.BaseClass;
import Pages.LandingPage;
import Pages.RegisterPage;
import utility.Helper;


public class LandingPageTest extends BaseClass{
	
	

	@Test(priority=1)
	public void doRegister() throws InterruptedException{
		logger = report.createTest("Register");
		LandingPage landingPage=PageFactory.initElements(driver, LandingPage.class);
		landingPage.clickOnAccount();
		Thread.sleep(10000);
		landingPage.signUp();
		logger.info("Staring application");
		RegisterPage reg =PageFactory.initElements(driver, RegisterPage.class);
		String fname = excel.getStringData(0, 1, 0);
		String lname =excel.getStringData(0, 1, 1);
		String email=excel.getStringData(0, 1, 2);
		double tel=excel.getNumericData("user", 1, 3);
		String pwd =excel.getStringData(0, 1, 4);
		String cPwd =excel.getStringData(0, 1, 5);
		reg.registerUser(fname, lname, email, tel, pwd, cPwd);
		logger.pass("pass the test");
	}
	
}
