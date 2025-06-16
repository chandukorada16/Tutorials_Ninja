package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountPage {
	
	WebDriver driver;
	
	@FindBy(xpath = "//ul[@class='list-unstyled']//a[text()='Edit your account information']")
	private WebElement editYourAccInfo;
	
	public AccountPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public boolean editYourInformationButton() {
		return editYourAccInfo.isDisplayed();
	}

}
