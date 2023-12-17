package testCases.LoginFunctionality_LF;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.ForgottenPasswordPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC_LF_006_LoginTest extends BaseClass {
    @Test(groups = {"Regression", "Master"})
    public void test_When_ClickForgottenPassword_Then_ForgottenPasswordPageShown() {
        logger.info("");
        logger.info("***  START TC_LF_006_LoginTest ***");
        try {
            HomePage homePage = new HomePage(driver);
            logger.info("... create Home Page");
            homePage.clickMyAccount();
            logger.info("... click on 'My account' in navbar");
            homePage.clickLogin();
            logger.info("... click on 'Login'");

            LoginPage loginPage = new LoginPage(driver);
            logger.info("... create 'Login' Page");

            if (loginPage.getLinkForgottenPassword() == null) {
                logger.info("... the link 'Forgotten Password' not present on the Login page. !! TEST FAILED !!");
                Assert.fail();
            } else {
                logger.info("--->   The link 'Forgotten Password' is present on the page   <---");
            }
            if (loginPage.getLinkForgottenPassword().isDisplayed() == Boolean.FALSE) {
                logger.info("... the link 'Forgotten Password' is not displayed. !! TEST FAILED !!");
                Assert.fail();
            } else {
                logger.info("--->   The link 'Forgotten Password' is displayed on the page   <---");
            }

            loginPage.clickLinkForgottenPassword();
            logger.info("... click on 'Forgotten Password' link");

            ForgottenPasswordPage forgottenPasswordPage = new ForgottenPasswordPage(driver);
            logger.info("... create 'Forgotten Password' page");

            String msg = forgottenPasswordPage.getForgottenPasswordTitle();
            logger.info("... checking the page title");
            Assert.assertEquals(msg, "Forgot Your Password?","Title not match !! TEST FAILED !!");
        } catch (Exception ex) {
            logger.info("!! TEST FAILED !!");
            Assert.fail();
        }
        logger.info("***  END TC_LF_006_LoginTest ***");
    }
}
