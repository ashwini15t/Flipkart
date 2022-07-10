package pomclassesflipkart;


import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SelectProductPage {
	
	
	@FindBy(xpath="//div[text()='SONY X74K 108 cm (43 inch) Ultra HD (4K) LED Smart TV with Google TV']")
	private WebElement moveToTv;
	
	@FindBy(xpath="//div[text()='SONY X74 Bravia 125.7 cms (50 inch) Ultra HD (4K) LED Smart Android TV']")
	private WebElement actualSonyTvProduct;
	
	
	private WebDriver driver;
	
	
	public SelectProductPage(WebDriver driver) {
		
		PageFactory.initElements(driver, this);
		this.driver=driver;
		
	}
	
	
/*	public void scrolldownToTv() throws InterruptedException {
		Thread.sleep(5000);
	    //to scroll down
	    JavascriptExecutor js= (JavascriptExecutor)driver;
	    js.executeScript("arguments[0].scrollIntoView(true);", moveToTv );
	    Thread.sleep(4000);
	  
	}*/
	public void selectProductSonyTv() throws InterruptedException {
		Thread.sleep(3000);
	actualSonyTvProduct.click();
	}
	
	

}
