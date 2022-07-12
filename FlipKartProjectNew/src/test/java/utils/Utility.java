package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

public class Utility {
	
	//screenshot
	
	public static void captureScreen(WebDriver driver,int testID) throws IOException, InterruptedException {
		
		
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
		Date d = new Date();
		String s= formatter.format(d);
		//System.out.println(s);
		String str=  new SimpleDateFormat("dd-mm-yyyy hh-mm-ss").format(new Date());
		TakesScreenshot t= (TakesScreenshot)driver;
		File source= t.getScreenshotAs(OutputType.FILE);
		
		File dest= new File("test-output\\Screenshots\\Testscreenshot-"+testID+ " " + str + ".jpeg");
		
		Thread.sleep(5000);	
		FileHandler.copy(source, dest);
		
						

	}

	
	public static String geDataFromExcel(String sheet, int row, int cell) throws EncryptedDocumentException, IOException {
		
		String data=null;
		String path = "src\\main\\resources\\TestData\\testingdata.xlsx";
		FileInputStream file = new FileInputStream(path);
		Workbook book = WorkbookFactory.create(file);
		
		try {
			
			String userName1 = book.getSheet(sheet).getRow(row).getCell(cell).getStringCellValue();
			data=userName1;
			//System.out.println(data);
		}
		catch(Exception e) {
			double userName1 = book.getSheet(sheet).getRow(row).getCell(cell).getNumericCellValue();
			String str=Long.toString((long) userName1);
			//System.out.println(str)
			//String userName11=String.valueOf(str);
			data=str;
			//System.out.println(data);
		}
		
		
		return data;
	
	}
}
