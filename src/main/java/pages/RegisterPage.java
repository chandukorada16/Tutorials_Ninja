package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RegisterPage {
	
	WebDriver driver;
	
	@FindBy(id="input-firstname")
	private WebElement firstName;
	
	@FindBy(id="input-lastname")
	private WebElement lastName;
	
	@FindBy(id="input-email")
	private WebElement email;
	
	@FindBy(id="input-telephone")
	private WebElement telephone;
	
	@FindBy(id="input-password")
	private WebElement password;
	
	@FindBy(id="input-confirm")
	private WebElement confirmPassword;
	
	@FindBy(name = "agree")
	private WebElement privacyPolicy;
	
	@FindBy(xpath = "//input[@value='Continue']")
	private WebElement continueButton;
	
	public RegisterPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void fillMandatoryFields(String fName,String lName,String mail,String phone,String pwd) {
		firstName.sendKeys(fName);
		lastName.sendKeys(lName);
		email.sendKeys(mail);
		telephone.sendKeys(phone);
		password.sendKeys(pwd);
		confirmPassword.sendKeys(pwd);
		
	}
	
	public void clickContinue() {
		continueButton.click();
    }
	
	public void selectPrivacyPolicy() {
		privacyPolicy.click();
	}

	
	

}
