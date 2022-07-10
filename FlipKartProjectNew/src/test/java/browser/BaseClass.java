package browser;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;


public class BaseClass {
	

		public static WebDriver openChromeBrowser() {
			
			System.setProperty("webdriver.chrome.driver","src\\test\\resources\\Browsers\\chromedriver.exe" );		
			WebDriver driver = new ChromeDriver();
			return driver;
		}
		
		public static WebDriver openFirefoxBrowser() {
			System.setProperty("webdriver.gecko.driver", "src\\test\\resources\\Browsers\\geckodriver.exe");		
			WebDriver driver = new FirefoxDriver();   
			return driver;
		}
		
		public static WebDriver openOperaBrowser() {
			System.setProperty("webdriver.opera.driver", "src\\test\\resources\\Browsers\\operadriver.exe");		
			WebDriver driver = new OperaDriver();   
			return driver;
		}
		

}
