package tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import base.BaseTest;
import pages.AccountPage;
import pages.AccountSuccessPage;
import pages.HomePage;
import pages.RegisterPage;

public class TC_RF_001 extends BaseTest {
	
  @Test
  public void verifyRigisterWithmandatoryFields() {
	  
	  HomePage homePg=new HomePage(driver);
	  RegisterPage registerPg=new RegisterPage(driver);
	  AccountSuccessPage accountSuccessPg=new AccountSuccessPage(driver);
	  AccountPage accountPg=new AccountPage(driver);
	  
	  homePg.clickMyAccount();
	  homePg.clickRegisterOption();
	  
	  registerPg.fillMandatoryFields(
			  prop.getProperty("firstname"),
			  prop.getProperty("lastname"),
			  prop.getProperty("email"), 
			  prop.getProperty("telephone"),
			  prop.getProperty("password"));
	  
	  registerPg.selectPrivacyPolicy();
	  registerPg.clickContinue();
	  
	  Assert.assertTrue(accountSuccessPg.clickLogoutButton());
	  String expHead = prop.getProperty("expectedHeading");
	  
	  Assert.assertEquals(accountSuccessPg.getSuccessTextMsg(), expHead);
	  
	  String actualPropDetailsOne = prop.getProperty("actualProperDetailsOne");
	  String actualPropDetailsTwo = prop.getProperty("actualProperDetailsTwo");
	  String actualPropDetailsThree = prop.getProperty("actualProperDetailsThree");
	  String actualProptiesFour = prop.getProperty("actualPropertiesFour");
	  
	  String expectedProperDetails = accountSuccessPg.getWholeText();
	  
	  Assert.assertTrue(expectedProperDetails.contains(actualPropDetailsOne));
	  Assert.assertTrue(expectedProperDetails.contains(actualPropDetailsTwo));
	  Assert.assertTrue(expectedProperDetails.contains(actualPropDetailsThree));
	  Assert.assertTrue(expectedProperDetails.contains(actualProptiesFour));
	  
	  accountSuccessPg.clickContinueButton();
	  Assert.assertTrue(accountPg.editYourInformationButton());
	  
  }
}
