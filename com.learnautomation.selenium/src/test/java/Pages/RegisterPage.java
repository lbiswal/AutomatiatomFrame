package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class RegisterPage {
	WebDriver driver;
	   
	public RegisterPage(WebDriver ldriver)
	{
		this.driver=ldriver;
	}

	private By firstName =By.name("firstname");
	private By lastName = By.name("lastname");
	private By emailId = By.name("email");
	private By phoneNo = By.name("telephone");
	private By password = By.name("password");
	private By confirmPwd = By.name("confirm");
	private By agree = By.name("agree");
	private By submit = By.xpath("//input[@type='submit']");
	
	public void registerUser(String fname,String lname,String email,String tel,String pwd,String cPwd) {
		driver.findElement(firstName).sendKeys(fname);
		driver.findElement(lastName).sendKeys(lname);
		driver.findElement(emailId).sendKeys(email);
		driver.findElement(phoneNo).sendKeys(String.valueOf(tel));
		driver.findElement(password).sendKeys(pwd);
		driver.findElement(confirmPwd).sendKeys(cPwd);
		driver.findElement(agree).click();
		driver.findElement(submit).click();
	}
	

}
