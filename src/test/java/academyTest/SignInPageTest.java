package academyTest;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import pageFactory.LandingPage;
import pageFactory.LoginPage;
import resources.base;

public class SignInPageTest extends base {
	public WebDriver driver;
	
	public static Logger log = LogManager.getLogger(base.class.getName());
	
	@BeforeTest
	public void initDriver() throws IOException {
		driver = initializeDriver();
		log.info("driver is initialized for signin page test");
		driver.get(prop.getProperty("url"));
		log.info("Navigated to Landing Page");
		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
	}
	
	
	@AfterTest
	public void tearDown() throws IOException {
		driver.close();
		  log.info("browser closed for signin page test");
	}
		
		@Test
		public void verifyTitle() throws InterruptedException {
     	 LandingPage land = new LandingPage(driver);
		land.SignIn().click();
		log.info("Clicked on Sign Link in landing page");
		String title = driver.getTitle();
		Thread.sleep(500);
		Assert.assertEquals(title, "WebServices Testing using SoapUI");
		log.info("Title is validated successfully");
		
	}
	
	@Test(dependsOnMethods = "verifyTitle")
	public void doSignIn() {
     	 LoginPage login = new LoginPage(driver);
		login.setEmail().sendKeys("testemail");
		login.setPassword().sendKeys("testpwd");
		login.loginButton().click();
		log.info("Clicked on login button");
		
		String invalidText = login.invalidLoginText().getText();
		System.out.println(invalidText);
		Assert.assertEquals("Invalid email or password.", invalidText);
		log.info("Invalid message displayed succesfully in login page");
		}
	}
	
	
	
	

	 

