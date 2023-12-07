package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;
import utilities.DataProviders;

public class TC_003_LoginDDT extends BaseClass {

    @Test(dataProvider = "LoginData", dataProviderClass = DataProviders.class)
    public void test_loginDDT(String email, String password, String exp) {

        logger.info("***  Starting TC_003_LoginDDT ***");
        try {
            HomePage homePage = new HomePage(driver);
            homePage.clickMyAccount();
            logger.info("clicked on Account link");
            homePage.clickLogin();
            logger.info("clicked on Login link");

            LoginPage loginPage = new LoginPage(driver);
            logger.info("providing customers data");
            loginPage.setEmail(email);
            loginPage.setPassword(password);
            loginPage.clickLogin();
            logger.info("clicked on Login link");

            MyAccountPage myAccountPage = new MyAccountPage(driver);
            boolean targetPage = myAccountPage.isMyAccountPageExists();

            if (exp.equals("valid")) {
                if (targetPage) {
                    myAccountPage.clickLogout();
                    Assert.assertTrue(true);
                } else {
                    Assert.fail();
                }
            }
            if (exp.equals("invalid")) {
                if (targetPage) {
                    Assert.fail();
                } else {
                    Assert.assertTrue(true);
                }
            }
        } catch (Exception e) {
            Assert.fail();
        }
        logger.info("***  Finished TC_003_LoginDDT ***");
    }
}
