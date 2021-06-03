package academyTest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import pageFactory.LandingPage;

import pageFactory.RegisterNewUserPage;
import resources.base;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class RegisterPageTest extends base{
	public WebDriver driver;
	public static Logger log = LogManager.getLogger(base.class.getName());
	
    @BeforeTest
    public void baseClassNavigation() throws IOException {
        driver = initializeDriver();
        log.info("driver initialized for Register page test");
    }
    
    @AfterTest
    public void teardown() {
    	driver.close();
    	  log.info("browser closed for Register Page test");
    }


	    @DataProvider
	  public Object[][] Registerdata() {
	  	
	  	Object[][] Registerdata = new Object[1][4];
	  	Registerdata[0][0] ="Abhishek Arloor";
	  	Registerdata[0][1] ="abhishekarlur@gmail.com";
	  	Registerdata[0][2] ="Password@123";
	  	Registerdata[0][3] ="Password@123";
		return Registerdata;
	  }
  
    
    //Test to create new use registration from HomePage
//    @Test(dataProvider="Registerdata")
//    public void registerUser(String fullname,String email,String pwd,String cnfpwd) throws IOException, InterruptedException {
//    	LandingPage land = new LandingPage(driver);
//   	    RegisterNewUserPage reg = new RegisterNewUserPage(driver);
//   		Thread.sleep(500);
// 	    land.Register().click();    
//    	reg.fullName().sendKeys(fullname);
//    	reg.email().sendKeys(email);
//    	reg.pasword().sendKeys(pwd);
//    	reg.confPassword().sendKeys(cnfpwd);
//    	reg.userAgreementCheckbox().click();
//		Thread.sleep(500);
////		   driver.navigate().to(prop.getProperty("url"));
////		      Thread.sleep(500);
//		reg.signUpbutton().click();
//       	Assert.assertTrue(true);
//   
//       	}
//    

    @Test(dataProvider="Registerdata")
    public void registerExistingUser(String fullname,String email,String pwd,String cnfpwd) throws IOException, InterruptedException {
    	driver.get(prop.getProperty("url"));
    	  log.info("Navigated to Landing Page");
    	driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
    	LandingPage land = new LandingPage(driver);
   	    RegisterNewUserPage reg = new RegisterNewUserPage(driver);
   		Thread.sleep(500);
 	    land.Register().click(); 
 	   log.info("Clicked on Register link in landing page");
    	reg.fullName().sendKeys(fullname);
    	reg.email().sendKeys(email);
    	reg.pasword().sendKeys(pwd);
    	reg.confPassword().sendKeys(cnfpwd);
    	reg.userAgreementCheckbox().click();
		Thread.sleep(500);
       	reg.signUpbutton().click();
        log.info("Clicked on Signup  button");
       	Assert.assertEquals(reg.existinguserError().getText(), "Oops! Please fix the following:");
        log.info("correct error message displayed for existing user error");
       	Thread.sleep(500);
        driver.navigate().to(prop.getProperty("url"));
        log.info("Navigated back to landing page");
    }
    
    
 }
