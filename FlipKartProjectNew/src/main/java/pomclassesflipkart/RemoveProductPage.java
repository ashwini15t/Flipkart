package pomclassesflipkart;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RemoveProductPage {
	
	@FindBy(xpath="(//div[text()='Remove'])[1]")
	private WebElement removeItem;
	
	@FindBy(xpath="(//div[@class='_2_e-g9 _2WFwmV']//div)[6]")
	private WebElement removeItemconfirmButton;
	
	
	private WebDriver driver;
	
	
	public RemoveProductPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		this.driver=driver;
		
	}
	
	
	public void clicktoRemoveProduct() throws InterruptedException {
		Thread.sleep(3000);
	    //to scroll down
	    JavascriptExecutor js= (JavascriptExecutor)driver;
	    js.executeScript("arguments[0].scrollIntoView(true);", removeItem);
		   
	    Thread.sleep(3000);
	    
	    removeItem.click();
	    
	  
	}
	
	public void confirmingToRemoveProduct() throws InterruptedException {
		Thread.sleep(4000);
	   
		  removeItemconfirmButton.click();
	    
	  
	}
	
	
	  
	
	  
}
