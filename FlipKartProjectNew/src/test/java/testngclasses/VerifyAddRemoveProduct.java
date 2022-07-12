package testngclasses;


import static org.testng.Assert.assertEquals;

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

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;

import browser.BaseClass;
import pomclassesflipkart.AddtocartProductPage;
import pomclassesflipkart.HeadersPageFlikart;
import pomclassesflipkart.LoginPageFlipkart;
import pomclassesflipkart.RemoveProductPage;
import pomclassesflipkart.SelectProductPage;
import utils.Utility;

public class VerifyAddRemoveProduct {

	WebDriver driver;
	LoginPageFlipkart loginPage;
	HeadersPageFlikart headers;
	SelectProductPage selectProduct;
	AddtocartProductPage addtocartProduct;
	RemoveProductPage removeProduct;
	SoftAssert soft;
	int testID;
	static ExtentTest test;
	static ExtentHtmlReporter reporter;
	
	@Parameters("browserName")
	
	@BeforeTest
	public void launchBrowser(String browser) {
		reporter = new ExtentHtmlReporter("test-output/ExtendReport/Extent.html");
		ExtentReports extend = new ExtentReports();
		extend.attachReporter(reporter);
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
	public void pomObjectCreation() {
		
		loginPage=new LoginPageFlipkart(driver);
		headers=new HeadersPageFlikart(driver);
		addtocartProduct=new AddtocartProductPage(driver);
		removeProduct=new RemoveProductPage(driver);
		selectProduct=new SelectProductPage(driver);
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
	
	@Test	(priority=1)
	public void toSelectProduct() throws InterruptedException, EncryptedDocumentException, IOException {
		
		System.out.println( "test A");
		testID=10123;
		String productName=Utility.geDataFromExcel("flipkartdata", 1, 2);
		headers.sendTvToSearchBox(productName);
		headers.selectSearchButton();
		selectProduct.selectProductSonyTv();
		Thread.sleep(5000);
		String title2=driver.getTitle();
	    SoftAssert soft=new SoftAssert();
		soft.assertEquals(title2, "Sny Tv- Buy Products Online at Best Price in India - All Categories | Flipkart.com", "title vertification");
		soft.assertAll();
		
			   
	}
		
	@Test	(priority=2, dependsOnMethods= {"toSelectProduct"})
		
	public void toAddToCartProduct() throws InterruptedException {
		testID=10124;
		System.out.println( "test B");
		Thread.sleep(5000);
		addtocartProduct.addingProductToCart();
		Thread.sleep(2000);
		//String url=driver.getCurrentUrl();
	    //String title=driver.getTitle();
	   // Assert.assertEquals(title, "Shopping Cart | Flipkart.com", "title verification");
		
	}
	
	@Test	(priority=3)
	public void toRemoveProduct() throws InterruptedException {
		System.out.println("test C");
		testID=10125;
		Thread.sleep(4000);
		headers.clickToCart();
		Thread.sleep(5000);
		//String url2=driver.getCurrentUrl();
	    String title2=driver.getTitle();
	    Assert.assertEquals(title2, "Shopping Cart | Flipkart.com", "title verification");
	   
		removeProduct.clicktoRemoveProduct();
		removeProduct.confirmingToRemoveProduct();
		
		
	}	
	
		
	@AfterMethod
	public void afterMethod(ITestResult result) throws InterruptedException, IOException {
		
		System.out.println( "After method");
		if(ITestResult.FAILURE==result.getStatus())
		{
			Utility.captureScreen(driver, testID);
		}
		Thread.sleep(4000);
		headers.clickToLogout();
	}
	
	@AfterClass
	public void closeObjects() {
		loginPage=null;
		headers=null;
		addtocartProduct=null;
		removeProduct=null;
		selectProduct=null;
		
	}
	
	
	
	@AfterTest
	public void afterClass() {
		
		System.out.println( "After class");
		driver.quit();
		driver=null;
		System.gc();
		
		
	}
	


}
