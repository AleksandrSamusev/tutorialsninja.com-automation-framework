package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_002_LoginTest extends BaseClass {

    @Test(groups = {"Sanity", "Master"})
    public void test_login() {
        try {
            logger.debug("application logs...........");
            logger.info("***  Starting TC_002_LoginTest ***");

            HomePage homePage = new HomePage(driver);
            homePage.clickMyAccount();
            logger.info("clicked on Account link");
            homePage.clickLogin();
            logger.info("clicked on Login link");

            LoginPage loginPage = new LoginPage(driver);
            logger.info("providing customers data");
            loginPage.setEmail(rb.getString("email"));
            loginPage.setPassword(rb.getString("password"));
            loginPage.clickLogin();
            logger.info("clicked on Login link");

            MyAccountPage myAccountPage = new MyAccountPage(driver);
            Assert.assertTrue(myAccountPage.isMyAccountPageExists(), "Invalid login data!");
        } catch (Exception e) {
            logger.info("test failed");
            Assert.fail();
        }
        logger.info("***  Finished TC_002_LoginTest ***");
    }

}
