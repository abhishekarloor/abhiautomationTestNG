package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterNewUserPage {
	
	public WebDriver driver;
	
	public RegisterNewUserPage(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}

	@FindBy(id ="user_name")
	WebElement fullname;
	
	@FindBy(id ="user_email")
	WebElement emailtoRegister;
	
	@FindBy(id ="user_password")
	WebElement pwd;
	
	@FindBy(id ="user_password_confirmation")
	WebElement confPwd;
	
	@FindBy(id="user_agreed_to_terms")
	WebElement userAgreecheckbox;
	
	@FindBy(name ="commit")
	WebElement signupbutton;
	
	@FindBy(xpath ="//*[@id=\"new_user\"]/div[1]/p")
	WebElement errorMessage;
	
	public WebElement fullName() {
		return fullname;
	}
	
	public WebElement email() {
		return emailtoRegister;
	}
	
	public WebElement pasword() {
		return pwd;
	}
	
	public WebElement confPassword() {
		return confPwd;
	}
	
	public WebElement userAgreementCheckbox() {
		return userAgreecheckbox;
	}
	
	public WebElement signUpbutton() {
		return signupbutton;
	}
	
	public WebElement existinguserError() {
		return errorMessage;
	}
}
