package pageFactory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

	public WebDriver driver;
	
		public LoginPage(WebDriver driver) {
			this.driver =driver;
			PageFactory.initElements(driver, this);
			
		}
		

		@FindBy(id="user_email")
		WebElement email;

		
		@FindBy(name=" password")
		WebElement password;
		
		@FindBy(name="commit")
		WebElement loginButton;
		
		@FindBy(xpath="//*[@id=\"hero\"]/div/div")
		WebElement invalidloginText;
		
		
		public WebElement setEmail() {
			return email;
		}
	
		public WebElement setPassword() {
			return password;
		}
		
		public WebElement loginButton() {
			return loginButton;
		}
		
		public WebElement invalidLoginText() {
			return invalidloginText;
		}
		
}
