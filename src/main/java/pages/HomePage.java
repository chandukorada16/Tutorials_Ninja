package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
	WebDriver driver;
	
	@FindBy(xpath = "//span[text()='My Account']")
	private WebElement myAccountDropdown;
	
	@FindBy(linkText = "Register")
	private WebElement registerOption;
	
	
	public HomePage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void clickMyAccount() {
        myAccountDropdown.click();
    }
	
	public void clickRegisterOption() {
		registerOption.click();
	}
	

}
