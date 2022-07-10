package testpackflipkart;


import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import pomclassesflipkart.AddtocartProductPage;
import pomclassesflipkart.HeadersPageFlikart;
import pomclassesflipkart.LoginPageFlipkart;
import pomclassesflipkart.RemoveProductPage;
import pomclassesflipkart.SelectProductPage;
import utils.Utility;

public class TestClassFlipKart {

	public static void main(String[] args) throws InterruptedException, EncryptedDocumentException, IOException {
			System.setProperty("webdriver.chrome.driver","C:\\velocity_pune\\selenium\\chromedriver.exe" );
			WebDriver driver = new ChromeDriver();
			driver.manage().window().maximize();
			driver.get("https://www.flipkart.com/");
			
			LoginPageFlipkart loginPage=new LoginPageFlipkart(driver);
			String userName=Utility.geDataFromExcel("flipkartdata", 1, 0);
			loginPage.sendMobileNumber(userName);
			String password=Utility.geDataFromExcel("flipkartdata", 1, 1);
			loginPage.sendPassword(password);
			loginPage.clickOnLogin();
			loginPage.clickOnLogin();
			Thread.sleep(3000);
			
			String url4=driver.getCurrentUrl();
		    String title4=driver.getTitle();
		    
		    System.out.println(url4);
		    System.out.println(title4);
		    
            
			
			HeadersPageFlikart headers=new HeadersPageFlikart(driver);
			headers.clickToCart();
			Thread.sleep(4000);
			String url=driver.getCurrentUrl();
		    String title=driver.getTitle();
		    
		    System.out.println(url);
		    System.out.println(title);
		    
		    if(url.equals("https://www.flipkart.com/viewcart?otracker=Cart_Icon_Click"))
		    {
		    	System.out.println("pass");
		    }
		    else
		    {
		    	System.out.println("fail");
		    }
			
		   
		    String productName=Utility.geDataFromExcel("flipkartdata", 1, 2);
			headers.sendTvToSearchBox(productName);
			headers.selectSearchButton();
			Thread.sleep(4000);
			String url1=driver.getCurrentUrl();
		    String title1=driver.getTitle();
		    
		    System.out.println(url1);
		    System.out.println(title1);
			
			//headers.clickToCart();
			//headers.clickToLogout();
			
			
			SelectProductPage selectProduct=new SelectProductPage(driver);
			selectProduct.selectProductSonyTv();
			Thread.sleep(4000);
			String url2=driver.getCurrentUrl();
		    String title2=driver.getTitle();
		    
		    System.out.println(url2);
		    System.out.println(title2);
			
			
			AddtocartProductPage addtocartProduct=new AddtocartProductPage(driver);
			addtocartProduct.addingProductToCart();
			Thread.sleep(3000);
			String url3=driver.getCurrentUrl();
		    String title3=driver.getTitle();
		    
		    System.out.println(url3);
		    System.out.println(title3);
			
			//headers.clickToCart();
			
			RemoveProductPage removeProduct=new RemoveProductPage(driver);
			removeProduct.clicktoRemoveProduct();
			removeProduct.confirmingToRemoveProduct();
			
			headers.clickToLogout();


			
		}

	

}
