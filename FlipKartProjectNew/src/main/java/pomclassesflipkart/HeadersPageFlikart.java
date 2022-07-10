package pomclassesflipkart;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class HeadersPageFlikart {
	
	private WebDriver driver;
	
	@FindBy(xpath="//input[@class='_3704LK']")
	private WebElement searchTextBox;
	
	@FindBy(xpath="//button[@class='L0Z3Pu']")
	private WebElement searchButtonIcon;
	
	
	@FindBy(xpath="//span[text()='Cart']")
	private WebElement Cartbutton;
	
	@FindBy(xpath="(//div[@class='go_DOp'])[1]")
	private WebElement accountHolderName;
	
	@FindBy(xpath="//div[text()='Logout']")
	private WebElement logoutButton;

	public HeadersPageFlikart(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		this.driver=driver;
		
	}
	
	public void sendTvToSearchBox(String pro) throws InterruptedException {
		Thread.sleep(3000);
		searchTextBox.click();
		searchTextBox.sendKeys(pro);
	}
	
	public void selectSearchButton() throws InterruptedException {
		Thread.sleep(2000);
		searchButtonIcon.click();
	}
	
	public void clickToLogout() throws InterruptedException {
	
	Thread.sleep(2000);
    Actions act= new Actions(driver);
    act.moveToElement(accountHolderName).perform();
    
    Thread.sleep(2000);
    logoutButton.click();
	}
	
	public void clickToCart() throws InterruptedException {
		Thread.sleep(5000);
		Cartbutton.click();
		
		//driver.navigate().back();
	}
	

}
