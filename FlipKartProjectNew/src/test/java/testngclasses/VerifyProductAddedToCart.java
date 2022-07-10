package testngclasses;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pomclassesflipkart.AddtocartProductPage;
import pomclassesflipkart.HeadersPageFlikart;
import pomclassesflipkart.LoginPageFlipkart;
import pomclassesflipkart.RemoveProductPage;
import pomclassesflipkart.SelectProductPage;
import utils.Utility;

public class VerifyProductAddedToCart {
	WebDriver driver;
	LoginPageFlipkart loginPage;
	HeadersPageFlikart headers;
	SelectProductPage selectProduct;
	AddtocartProductPage addtocartProduct;
	RemoveProductPage removeProduct;
	
	@BeforeClass
	public void launchBrowser() {
		
		System.out.println( "before class");
		System.setProperty("webdriver.chrome.driver","C:\\velocity_pune\\selenium\\chromedriver.exe" );
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.flipkart.com/");
		loginPage=new LoginPageFlipkart(driver);
		headers=new HeadersPageFlikart(driver);
		selectProduct=new SelectProductPage(driver);
		addtocartProduct=new AddtocartProductPage(driver);
		removeProduct=new RemoveProductPage(driver);
	}
		
	@BeforeMethod
	public void loginToApplication() throws InterruptedException, EncryptedDocumentException, IOException {
		
		System.out.println( "before method");
		String userName=Utility.geDataFromExcel("flipkartdata", 1, 0);
		loginPage.sendMobileNumber(userName);
		String password=Utility.geDataFromExcel("flipkartdata", 1, 1);
		loginPage.sendPassword(password);
		loginPage.clickOnLogin();
		
	}
		
	@Test	
		
	public void testA() throws InterruptedException, EncryptedDocumentException, IOException {
		
		System.out.println( "test A");
		
		String productName=Utility.geDataFromExcel("flipkartdata", 1, 2);
		headers.sendTvToSearchBox(productName);
		headers.selectSearchButton();
		Thread.sleep(5000);
	    //selectProduct.scrolldownToTv();
		selectProduct.selectProductSonyTv();
		
		String url=driver.getCurrentUrl();
	    String title=driver.getTitle();
	    System.out.println(url);
	    System.out.println(title);
	   
	    Thread.sleep(3000);
		addtocartProduct.addingProductToCart();
		String url2=driver.getCurrentUrl();
	    String title2=driver.getTitle();
	    System.out.println(url2);
	    System.out.println(title2);
		
		
	}
	
	@Test	
	public void testB() throws InterruptedException {
		System.out.println("test B");
		Thread.sleep(4000);
		headers.clickToCart();
		Thread.sleep(5000);
		String url2=driver.getCurrentUrl();
	    String title2=driver.getTitle();
	    System.out.println(url2);
	    System.out.println(title2);
		removeProduct.clicktoRemoveProduct();
		removeProduct.confirmingToRemoveProduct();
		
		
	}	
	
		
	@AfterMethod
	public void afterMethod() throws InterruptedException {
		Thread.sleep(2000);
		System.out.println( "After method");
		headers.clickToLogout();
	}
	
	@AfterClass
	public void afterClass() {
		
		System.out.println( "After class");
		driver.quit();
		
		
	}
	
}
