package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;

import pageObjects.AccountRegisterationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC001_AccountRegisterationTest extends BaseClass {

	@Test(groups= {"Regression","Master"})
	public void verify_Acoount_Reg() {

		logger.info("*** TC001_AccountRegisterationTest Started ***");
		try {
			HomePage hp = new HomePage(driver);
			hp.clickMyAccount();
			hp.clickRegister();

			AccountRegisterationPage regPage = new AccountRegisterationPage(driver);
			regPage.setFirstName(randomString().toUpperCase());

			regPage.setlastName(randomString().toUpperCase());

			regPage.setEmail(randomString() + "@123.com");

			regPage.setTelephone(randomNum());

			String pwd = randomAphaNum();
			regPage.setPassword(pwd);
			regPage.setConfirmPassword(pwd);

			regPage.setPrivacyPolicy();

			regPage.clickContinue();

			String cfmMsg = regPage.getConfirmationMessage();
			Assert.assertEquals(cfmMsg, "Your Account Has Been Created!");
		} catch (Exception e) {
			logger.error("Test Failed");
			logger.debug("Debug logs");
			Assert.fail();
		}
		logger.info("*** TC001_AccountRegisterationTest Completed ***");
	}
}
