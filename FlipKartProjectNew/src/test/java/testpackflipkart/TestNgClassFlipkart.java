package testpackflipkart;

import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class TestNgClassFlipkart {

	@BeforeClass
	public void beforeClass() {
		
		System.out.println( "before class");
	}
		
	@BeforeMethod
	public void beforeMethod() {
		
		System.out.println( "before method");
	}
		
	@Test	
		
	public void testA() {
		
		System.out.println( "test A");
	}
	
	@Test	
	public void testB() {
		
		System.out.println( "test B ");
	}	
	@AfterClass
	public void afterClass() {
		
		System.out.println( "After class");
	}
		
	@AfterMethod
	public void afterMethod() {
		
		System.out.println( "After method");
	}
		
		
		
}
