package testCases.LogoutFunctionality_LG;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.*;
import testBase.BaseClass;

public class TC_LG_005_LogoutTest extends BaseClass {
    @Test(groups = {"Regression", "Master"})
    public void test_checkIfLogoutOptionNotDisplayedIfUserNotLoggedIn() {
        logger.info("");
        logger.info("***  START TC_LG_005_LogoutTest ***");
        try {
            HomePage homePage = new HomePage(driver);
            logger.info("... create Home Page");
            homePage.clickMyAccount();
            logger.info("... click on 'My account' in navbar");

            Assert.assertFalse(homePage.isLogoutPresent(), "Logout option is present! TEST FAILED!");

        } catch (Exception ex) {
            logger.info("!! TEST FAILED !!");
            Assert.fail();
        }
        logger.info("***  END TC_LG_005_LogoutTest ***");
    }
}
