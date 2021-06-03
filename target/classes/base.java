package resources;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class base {
	public WebDriver driver;
	public Properties prop;
	public WebDriver initializeDriver() throws IOException {

		Logger log = LogManager.getLogger(base.class.getName());
		
		prop = new Properties();
		FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\resources\\data.properties");
			prop.load(fis);
		
	String browserName = prop.getProperty("browser");
	log.info(browserName+ "browser initialized successfully");
	if(browserName.equals("chrome")) {
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\src\\main\\java\\resources\\chromedriver.exe");
		driver = new ChromeDriver();
	}
	
	else if(browserName.equals("ie")) {

		System.setProperty("webdriver.ie.driver","C:\\Users\\ABHI\\Downloads\\work\\chromedriver_win32\\chromedriver");
		driver = new InternetExplorerDriver();
		}
	
	else if(browserName.equals("firefox")) {

		System.setProperty("webdriver.gecko.driver","C:\\Users\\ABHI\\Downloads\\work\\chromedriver_win32\\chromedriver.exe");
	//	driver = new GeckoDriverService()
		}
	
	driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
	return driver;
	}

	
	
	public String getScreenShotPath(String testCaseName,WebDriver driver) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot) driver;
		File source =ts.getScreenshotAs(OutputType.FILE);
		String destinationFile = System.getProperty("user.dir")+"\\reports\\"+testCaseName+".png";
		FileUtils.copyFile(source, new File(destinationFile));
	
		return destinationFile;
	}
	
	
	public void getdatasheet() throws IOException {

		FileInputStream fis = new FileInputStream("C:\\Udemy Automation Project\\AbhiAutomation\\src\\main\\java\\resources\\databook.xlsx");
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		int sheets = workbook.getNumberOfSheets();
		for(int i=0;i<sheets;i++) {
			
			if(workbook.getSheetName(i).equalsIgnoreCase("Sheet1"));
			
			
			XSSFSheet sheet = workbook.getSheetAt(i);
		}
	}
}
