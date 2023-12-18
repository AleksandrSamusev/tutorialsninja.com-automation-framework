package testCases.LoginFunctionality_LF;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC_LF_012_LoginTest extends BaseClass {
    @Test(groups = {"Regression", "Master"})
    public void test_UserGetsOneHourWarningAfter5LoginAttempts() {
        logger.info("");
        logger.info("***  START TC_LF_012_LoginTest ***");
        try {
            HomePage homePage = new HomePage(driver);
            logger.info("... create Home Page");
            homePage.clickMyAccount();
            logger.info("... click on 'My account' in navbar");
            homePage.clickLogin();
            logger.info("... click on 'Login'");

            LoginPage loginPage = new LoginPage(driver);
            logger.info("... create 'Login' Page");

            String email = randomString() + "@gmail";
            String password;
            loginPage.getTxtEmail().sendKeys(email);
            for (int i = 1; i <= 5; i++) {
                logger.info("ATTEMPT: " + i);
                password = randomAlphaNumeric();
                logger.info("... email stays the same: " + email + " <----");
                logger.info("... setting wrong password: " + password + " <----");
                loginPage.getTxtPassword().sendKeys(password);
                loginPage.clickLogin();
                logger.info("... click on 'Login'");
                loginPage.getTxtPassword().clear();
                logger.info("... clear password input field");
            }

            String msg = loginPage.getMessageAttemptsExceeded();
            String expectedMessage = "Warning: Your account has exceeded allowed" +
                    " number of login attempts. Please try again in 1 hour.";
            logger.info("... check the title on the My Account page");
            Assert.assertEquals(msg, expectedMessage, "Title not match !! TEST FAILED !!");

        } catch (Exception ex) {
            logger.info("!! TEST FAILED !!");
            Assert.fail();
        }
        logger.info("***  END TC_LF_012_LoginTest ***");
    }
}
