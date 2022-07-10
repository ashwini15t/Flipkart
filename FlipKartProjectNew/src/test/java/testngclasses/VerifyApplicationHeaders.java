package testngclasses;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.ITestResult;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import browser.BaseClass;
import pomclassesflipkart.HeadersPageFlikart;
import pomclassesflipkart.LoginPageFlipkart;
import utils.Utility;


public class VerifyApplicationHeaders {
	
	WebDriver driver;
	LoginPageFlipkart loginPage;
	HeadersPageFlikart headers;
	SoftAssert soft;
	int testID;
	
	@Parameters("browserName")
	
	@BeforeTest
	public void launchBrowser(String browser) {
		
		System.out.println("Before Test");
		   if(browser.equals("Chrome"))
		   {
			   driver= BaseClass.openChromeBrowser();
		   }
		   if(browser.equals("Firefox"))
		   {
			 driver= BaseClass.openFirefoxBrowser();
		   }
		   if(browser.equals("Opera"))
		   {
			 driver= BaseClass.openOperaBrowser();
		   }
		   driver.manage().window().maximize();	   
	   }
		
	
	
	@BeforeClass
	public void pomObjectCreatiom() {
		
	 loginPage=new LoginPageFlipkart(driver);
	 headers=new HeadersPageFlikart(driver);
	 soft=new SoftAssert();
	}
		
	@BeforeMethod
	public void loginToApplication() throws InterruptedException, EncryptedDocumentException, IOException {
		
		System.out.println( "before method");
		driver.get("https://www.flipkart.com/");
		String userName=Utility.geDataFromExcel("flipkartdata", 1, 0);
		loginPage.sendMobileNumber(userName);
		String password=Utility.geDataFromExcel("flipkartdata", 1, 1);
		loginPage.sendPassword(password);
		loginPage.clickOnLogin();
		
	}
		
	@Test	(invocationCount=1)
		
	public void toSearchProduct() throws InterruptedException, EncryptedDocumentException, IOException {
		
		System.out.println( "test A");
		testID=10121;
		String productName=Utility.geDataFromExcel("flipkartdata", 1, 2);
		headers.sendTvToSearchBox(productName);
		headers.selectSearchButton();
		Thread.sleep(4000);
		String url=driver.getCurrentUrl();
		System.out.println(url);
	    String title=driver.getTitle();
	    System.out.println(title);
		
	    soft.assertEquals(title, "Sony Tv- Buy Products Online at Best Price in India - All Categories | Flipkart.com", "title vertification");
		soft.assertAll();
	}
	
	@Test	
	public void toVerifyCartButton() throws InterruptedException {
		
		System.out.println("test B");
		testID=10122;
		Thread.sleep(4000);
		headers.clickToCart();
		Thread.sleep(5000);
		String url=driver.getCurrentUrl();
	    String title=driver.getTitle();
	    System.out.println(url);
	    System.out.println(title);
	    
	    Assert.assertEquals(url, "https://www.flipkart.com/viewcart?otracker=Cart_Icon_Click", "url verification");
	    Thread.sleep(4000);
	    driver.navigate().back();
	    Thread.sleep(4000);
		
	}	
	
		
	@AfterMethod
	public void afterMethod(ITestResult result) throws InterruptedException, IOException {
		Thread.sleep(2000);
		System.out.println( "After method");
		if(ITestResult.FAILURE==result.getStatus())
		{
			Utility.captureScreen(driver, testID);
		}
		headers.clickToLogout();
	}
	
	
	
	@AfterClass
	public void closeObjects() {
		loginPage=null;
		headers=null;
		
	}
	
	
	
	
	@AfterTest
	public void afterClass() {
		
		System.out.println( "After class");
		driver.quit();
		
		
	}
	
		
}
