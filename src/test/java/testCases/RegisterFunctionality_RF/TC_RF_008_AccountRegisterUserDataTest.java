package testCases.RegisterFunctionality_RF;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_RF_008_AccountRegisterUserDataTest extends BaseClass {

    @Test(groups = {"Regression", "Master"})
    public void when_passwordAndConfIsDifferent_validationMessage() {
        logger.info("***  Starting TC_RF_008_AccountRegisterUserDataTest ***");
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

            String confPassword = randomAlphaNumeric();
            registrationPage.setConfirmPassword(confPassword);

            registrationPage.clickPrivacyPolicy();
            registrationPage.clickContinue();
            logger.info("clicked on Continue");

            String validationMessage = registrationPage.getPasswordConfirmationValidationMessage();
            logger.info("validating expected message");
            Assert.assertEquals(validationMessage, "Password confirmation does not match password!",
                    "test failed");
        } catch (Exception ex) {
            logger.info("test failed");
            Assert.fail();
        }
        logger.info("***  Finished TC_RF_008_AccountRegisterUserDataTest ***");
    }
}
