package pomclassesflipkart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class LoginPageFlipkart {
	@FindBy(xpath="(//input[@type='text'])[2]")
	private WebElement mobileNumber;
	
	@FindBy(xpath="//input[@type='password']")
	private WebElement password;
	
	
	@FindBy (xpath="(//button[@type='submit'])[2]")
	private WebElement loginButtonClick;
	public LoginPageFlipkart(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		
	}
	
	public void sendMobileNumber(String user) throws InterruptedException {
		Thread.sleep(3000);
		mobileNumber.click();
		mobileNumber.sendKeys(user);
	}
	public void sendPassword(String pass){
	
		password.click();
		password.sendKeys(pass);
	
	}
	
	public void clickOnLogin(){
		loginButtonClick.click();
	
	}
	
	
	
}
