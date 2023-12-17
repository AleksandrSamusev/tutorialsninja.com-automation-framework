package testCases.RegisterFunctionality_RF;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_RF_013_AccountRegisterProperPlaceholdersTest extends BaseClass {
    @Test(groups = {"Regression", "Master"})
    public void test_whenEmailFormatIncorrect_thenAccountNotCreated() {
        logger.info("");
        logger.info("***  START TC_RF_013_AccountRegisterProperPlaceholdersTest ***");
        try {
            HomePage homePage = new HomePage(driver);
            logger.info("... create Home Page");
            homePage.clickMyAccount();
            logger.info("... click on 'My account' in navbar");
            homePage.clickRegister();
            logger.info("... click on 'Register'");
            AccountRegistrationPage registrationPage = new AccountRegistrationPage(driver);
            logger.info("... create Account Registration Page");

            Assert.assertEquals(registrationPage.getFirstNamePlaceholder(), "First Name");
            Assert.assertEquals(registrationPage.getLastNamePlaceholder(), "Last Name");
            Assert.assertEquals(registrationPage.getEmailPlaceholder(), "E-Mail");
            Assert.assertEquals(registrationPage.getTelephonePlaceholder(), "Telephone");
            Assert.assertEquals(registrationPage.getPasswordPlaceholder(), "Password");
            Assert.assertEquals(registrationPage.getPasswordConfirmationPlaceholder(), "Password Confirm");

        } catch (Exception ex) {
            logger.info("!! TEST FAILED !!");
            Assert.fail();
        }
        logger.info("***  END TC_RF_013_AccountRegisterProperPlaceholdersTest ***");
    }
}
