package testCases.RegisterFunctionality_RF;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_RF_003_AccountRegisterWithAllFieldsTest extends BaseClass {

    @Test(groups = {"Regression", "Master"})
    public void test_register_account_with_all_fields() {
        logger.info("***  TC_RF_003_AccountRegisterWithAllFieldsTest ***");
        try {
            HomePage homePage = new HomePage(driver);
            homePage.clickMyAccount();
            logger.info("clicked on Account link");
            homePage.clickRegister();
            logger.info("clicked on Register link");
            AccountRegistrationPage registrationPage = new AccountRegistrationPage(driver);

            logger.info("providing customers data");
            registrationPage.setFirstName(randomString().toUpperCase());
            registrationPage.setLastName(randomString().toUpperCase());
            registrationPage.setEmail(randomString() + "@gmail.com");
            registrationPage.setTelephone(randomNumber());

            String password = randomAlphaNumeric();

            registrationPage.setPassword(password);
            registrationPage.setConfirmPassword(password);
            registrationPage.clickPrivacyPolicy();
            registrationPage.clickOnYesRadioBtn();
            registrationPage.clickContinue();
            logger.info("clicked on Continue");
            String confMsg = registrationPage.getConfirmationMessage();
            logger.info("validating expected message");
            Assert.assertEquals(confMsg, "Your Account Has Been Created!",
                    "test failed");
        } catch (Exception ex) {
            logger.info("test failed");
            Assert.fail();
        }
        logger.info("***  Finished TC_RF_003_AccountRegisterWithAllFieldsTest ***");
    }
}
