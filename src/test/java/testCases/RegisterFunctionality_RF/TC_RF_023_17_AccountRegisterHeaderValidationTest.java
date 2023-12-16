package testCases.RegisterFunctionality_RF;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.Mp3PlayersPage;
import testBase.BaseClass;

public class TC_RF_023_17_AccountRegisterHeaderValidationTest extends BaseClass {
    @Test(groups = {"Regression", "Master"})
    public void test_whenEmailFormatIncorrect_thenAccountNotCreated() {
        logger.info("");
        logger.info("***  START TC_RF_023_17_AccountRegisterHeaderValidationTest ***");
        try {
            HomePage homePage = new HomePage(driver);
            logger.info("... create Home Page");
            homePage.clickMyAccount();
            logger.info("... click on 'My account' in navbar");
            homePage.clickRegister();
            logger.info("... click on 'Register'");
            AccountRegistrationPage registrationPage = new AccountRegistrationPage(driver);
            logger.info("... create Account Registration Page");

            registrationPage.clickRightSideLogin();
            logger.info("... click on 'Login' on the right side menu");

            LoginPage loginPage = new LoginPage(driver);

            String msg = loginPage.getNewCustomerTitle();
            Assert.assertEquals(msg, "New Customer", "Title not match !! TEST FAILED !!");

        } catch (Exception ex) {
            logger.info("!! TEST FAILED !!");
            Assert.fail();
        }
        logger.info("***  END TC_RF_023_17_AccountRegisterHeaderValidationTest ***");
    }
}
