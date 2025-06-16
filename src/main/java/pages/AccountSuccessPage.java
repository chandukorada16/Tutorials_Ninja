package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AccountSuccessPage {
	
	WebDriver driver;
	
	@FindBy(xpath = "//div[@id='content']/h1")
	private WebElement successHeading;
	
	@FindBy(linkText = "Continue")
	private WebElement finalContinueButton;
	
	@FindBy(linkText = "Logout")
	private WebElement logoutButton;
	
	@FindBy(id="content")
	private WebElement textContent;
	
	
	
	public AccountSuccessPage(WebDriver driver) {
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public String getSuccessTextMsg() {
		return successHeading.getText();
	}
	
	public void clickContinueButton() {
		finalContinueButton.click();
	}
	
	 public String getAccountPageTitle() {
	        return driver.getTitle();
	    }
	 
	 public boolean clickLogoutButton() {
		 return logoutButton.isDisplayed();
	 }
	 
	 public String getWholeText() {
			return textContent.getText();
		}


}
