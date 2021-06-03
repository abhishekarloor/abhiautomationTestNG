package academyTest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageFactory.LandingPage;
import pageFactory.LoginPage;
import resources.base;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class LandingPageTest extends base{
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(base.class.getName());
   
	@BeforeTest
    public void baseClassNavigation() throws IOException {
        driver = initializeDriver();
        log.info("driver initialized for Landing page test");

    }
    
    @AfterTest
    public void teardown() {
    	driver.close();
    	  log.info("browser closed");
    }

    @DataProvider
 	  public Object[][] Logindata() {
 	  	Object[][] Logindata = new Object[1][2];
 	
 	  	Logindata[0][0] ="abhishekarlur@gmail.com";
 	  	Logindata[0][1] ="Password@123";
 	
 		return Logindata; 
 	  }  

  @Test(dataProvider="Logindata")
  public void clickOnSignIn(String email,String pwd) throws IOException, InterruptedException {
        driver.get(prop.getProperty("url"));
        log.info("navigated to Landing page ");
  		driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		 LandingPage land = new LandingPage(driver);
		 LoginPage login = new LoginPage(driver);

      land.SignIn().click();
      log.info("Clicked on Sign in link");
      Thread.sleep(500);
      login.setEmail().sendKeys(email);
      login.setPassword().sendKeys(pwd);
      login.loginButton().click();
      log.info("login successfull");
      
  }
  

}
