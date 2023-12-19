package testCases.LogoutFunctionality_LG;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_LG_006_LogoutTest extends BaseClass {
    @Test(groups = {"Regression", "Master"})
    public void test_checkIfLogoutOptionNotDisplayedInRightMenuIfUserNotLoggedIn() {
        logger.info("");
        logger.info("***  START TC_LG_006_LogoutTest ***");
        try {
            HomePage homePage = new HomePage(driver);
            logger.info("... create Home Page");
            homePage.clickMyAccount();
            logger.info("... click on 'My account' in navbar");
            homePage.clickRegister();
            logger.info("... click on 'Register' option");

            AccountRegistrationPage accountRegistrationPage = new AccountRegistrationPage(driver);
            String title = accountRegistrationPage.getPageTitle();

            Assert.assertEquals(title, "Register Account", "Not proper page! TEST FAILED!");
            Assert.assertFalse(accountRegistrationPage.isLogoutLinkPresent(),
                    "Logout option is present! TEST FAILED!");

        } catch (Exception ex) {
            logger.info("!! TEST FAILED !!");
            Assert.fail();
        }
        logger.info("***  END TC_LG_006_LogoutTest ***");
    }
}
