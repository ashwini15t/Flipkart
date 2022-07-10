package packscript;

import java.util.ArrayList;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class CompleteCodeFlipKart {

	
		public static void main(String[] args) throws InterruptedException {
			System.setProperty("webdriver.chrome.driver", "C:\\velocity_pune\\selenium\\chromedriver.exe");
			WebDriver driver= new ChromeDriver();
			
			//to maximize
			driver.manage().window().maximize();
			
			//to open website provide url
		    driver.get("https://www.flipkart.com/");
			
		    //script to buy one product name sony Tv
		    
		    //testcase1:login to flipkart
		   
		    Thread.sleep(7000);
		    WebElement mobile =	driver.findElement(By.xpath("(//input[@type='text'])[2]"));
		    Thread.sleep(2000);
			mobile.click();
			mobile.sendKeys("9158842044");
			Thread.sleep(2000);
			WebElement password = driver.findElement(By.xpath("//input[@type='password']"));
			password.click();
			password.sendKeys("Anil@1234");
				
			WebElement login = driver.findElement(By.xpath("(//button[@type='submit'])[2]"));
			login.click();
			Thread.sleep(3000);
			
			
		   
			
		    
		    //testcase2: search a product
		    
		    WebElement	searchTextBox=driver.findElement(By.xpath("//input[@class='_3704LK']"));
		    searchTextBox.click();
		    searchTextBox.sendKeys("sony tv");
		    WebElement	searchButtonIcon=driver.findElement(By.xpath("//button[@class='L0Z3Pu']"));
		    searchButtonIcon.click();
		    
		    String url=driver.getCurrentUrl();
		    String title=driver.getTitle();
		    
		    System.out.println(url);
		    System.out.println(title);
		    
		  
		    
		   //select product
		    Thread.sleep(5000);
		    //WebElement	moveToTv=driver.findElement(By.xpath("(//a[@class='_1fQZEK'])[5]"));
		  WebElement	moveToTv=driver.findElement(By.xpath("//div[text()='SONY X74K 108 cm (43 inch) Ultra HD (4K) LED Smart TV with Google TV']"));
		    
		  //WebElement	moveToTv=  driver.findElement(By.xpath("//div[contains(text(),'SONY W820K 80 cm (32 inch) HD Ready LED Smart TV with Google TV')]"));
		    Thread.sleep(3000);
		    //to scroll down
		    JavascriptExecutor js= (JavascriptExecutor)driver;
		    js.executeScript("arguments[0].scrollIntoView(true);",moveToTv );
		    
		    Thread.sleep(4000);
		   
		    WebElement	actualSonyTvProduct=driver.findElement(By.xpath("//div[contains(text(),'SONY W820K 80 cm (32 inch) HD Ready LED Smart TV with Google TV')]"));
		   //WebElement	actualSonyTvProduct=driver.findElement(By.xpath("((//a[@class='_1fQZEK'])[5]//div)[11]"));
		  		  
		    actualSonyTvProduct.click();
		    String url1=driver.getCurrentUrl();
		    String title1=driver.getTitle();
		    
		    System.out.println(url1);
		    System.out.println(title1);
		    
		    Thread.sleep(2000);
		    ArrayList<String> adr= new ArrayList<String>(driver.getWindowHandles());
		    driver.switchTo().window(adr.get(1));
		    Thread.sleep(2000);
		    WebElement addToCartButton= driver.findElement(By.xpath("//button[text()='ADD TO CART']"));
		    addToCartButton.click();
		    String url4=driver.getCurrentUrl();
		    String title4=driver.getTitle();
		    
		    System.out.println(url4);
		    System.out.println(title4);
		    
		    
		    Thread.sleep(3000);
		  driver.navigate().back();
			
		    
		    Thread.sleep(5000);
		    
           WebElement Cartbutton = driver.findElement(By.xpath("//span[text()='Cart']"));
			
			Thread.sleep(5000);
			Cartbutton.click();
			
			String url3=driver.getCurrentUrl();
		    String title3=driver.getTitle();
		    
		    System.out.println(url3);
		    System.out.println(title3);
		    
		    /*
		    
		    //testcase 5: remove product from cart
		    WebElement removeItem= driver.findElement(By.xpath("(//div[text()='Remove'])[1]"));
		    js.executeScript("arguments[0].scrollIntoView(true);", removeItem);
		   
		    Thread.sleep(5000);
		    
		    removeItem.click();
		    
		    WebElement RemoveItemconfirmed= driver.findElement(By.xpath("(//div[@class='_2_e-g9 _2WFwmV']//div)[6]"));
		    RemoveItemconfirmed.click();
		  */
	

	}

}
