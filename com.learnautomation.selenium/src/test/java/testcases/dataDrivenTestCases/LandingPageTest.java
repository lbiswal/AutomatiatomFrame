package testcases.dataDrivenTestCases;


import java.util.ArrayList;
import java.util.Iterator;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import Pages.BaseClass;
import Pages.LandingPage;
import Pages.RegisterPage;
import utility.TestUtil;


public class LandingPageTest extends BaseClass{
	
	
	@DataProvider
	public Iterator<Object[]> getTestData() {
		ArrayList<Object[]> testData = TestUtil.getDataFromEcel();
		return testData.iterator();
	}

	@Test(dataProvider="getTestData")
	public void doRegister(String fname,String lname,String email,String tel,String pwd,String cPwd) throws InterruptedException{
		logger = report.createTest("Register");
		LandingPage landingPage=PageFactory.initElements(driver, LandingPage.class);
		landingPage.clickOnAccount();
		Thread.sleep(10000);
		landingPage.signUp();
		logger.info("Staring application");
		RegisterPage reg =PageFactory.initElements(driver, RegisterPage.class);
		reg.registerUser(fname, lname, email, tel, pwd, cPwd);
		logger.pass("pass the test");
	}
	
}
