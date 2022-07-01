package Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LandingPage{
	
	//WebDriver driver;
	
	 WebDriver driver;
	   
		public LandingPage(WebDriver ldriver)
		{
			this.driver=ldriver;
		}

	
	//click on myaccount and regester
	public void clickOnAccount() {
		WebElement myAccount = driver.findElement(By.xpath("//a[@title='My Account']"));
		myAccount.click();
	}
	public void signUp() throws InterruptedException {
		WebElement register = driver.findElement(By.linkText("Register"));
		
		register.click();
		Thread.sleep(4000);
	}
	
	

}
