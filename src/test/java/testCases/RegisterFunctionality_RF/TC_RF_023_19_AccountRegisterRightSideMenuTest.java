package testCases.RegisterFunctionality_RF;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.ForgottenPasswordPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_RF_023_19_AccountRegisterHeaderValidationTest extends BaseClass {
    @Test(groups = {"Regression", "Master"})
    public void test_whenEmailFormatIncorrect_thenAccountNotCreated() {
        logger.info("");
        logger.info("***  START TC_RF_023_19_AccountRegisterHeaderValidationTest ***");
        try {
            HomePage homePage = new HomePage(driver);
            logger.info("... create Home Page");
            homePage.clickMyAccount();
            logger.info("... click on 'My account' in navbar");
            homePage.clickRegister();
            logger.info("... click on 'Register'");
            AccountRegistrationPage registrationPage = new AccountRegistrationPage(driver);
            logger.info("... create Account Registration Page");

            registrationPage.clickRightSideForgottenPassword();
            logger.info("... click on 'Forgotten Password' on the right side menu");

            ForgottenPasswordPage forgottenPasswordPage = new ForgottenPasswordPage(driver);
            logger.info("... create 'Forgotten Password' page");

            String msg = forgottenPasswordPage.getForgottenPasswordTitle();
            Assert.assertEquals(msg, "Forgot Your Password?", "Title not match !! TEST FAILED !!");

        } catch (Exception ex) {
            logger.info("!! TEST FAILED !!");
            Assert.fail();
        }
        logger.info("***  END TC_RF_023_19_AccountRegisterHeaderValidationTest ***");
    }
}
