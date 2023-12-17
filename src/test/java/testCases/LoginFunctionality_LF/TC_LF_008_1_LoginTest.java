package testCases.LoginFunctionality_LF;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC_LF_008_1_LoginTest extends BaseClass {
    @Test(groups = {"Regression", "Master"})
    public void test_checkIfEmailFieldHasProperPlaceholder() {
        logger.info("");
        logger.info("***  START TC_LF_008_1_LoginTest ***");
        try {
            HomePage homePage = new HomePage(driver);
            logger.info("... create Home Page");
            homePage.clickMyAccount();
            logger.info("... click on 'My account' in navbar");
            homePage.clickLogin();
            logger.info("... click on 'Login'");

            LoginPage loginPage = new LoginPage(driver);
            logger.info("... create 'Login' Page");

            String msg = loginPage.getTxtEmail().getAttribute("placeholder");
            logger.info("... check the title on the My Account page");
            Assert.assertEquals(msg, "E-Mail Address", "Title not match !! TEST FAILED !!");

        } catch (Exception ex) {
            logger.info("!! TEST FAILED !!");
            Assert.fail();
        }
        logger.info("***  END TC_LF_008_1_LoginTest ***");
    }
}
