package pomclassesflipkart;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class AddtocartProductPage {

	@FindBy(xpath="//button[text()='ADD TO CART']")
	private WebElement addToCartButton;
	
	
	private WebDriver driver;

	public AddtocartProductPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		this.driver=driver;
		
	}
	
	public void addingProductToCart() throws InterruptedException {
		
		ArrayList<String> adr= new ArrayList<String>(driver.getWindowHandles());
	    driver.switchTo().window(adr.get(1));
	    Thread.sleep(2000);
	    
	    addToCartButton.click();
	}
	
	
   
}
