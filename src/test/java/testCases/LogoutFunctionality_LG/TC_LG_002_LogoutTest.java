package testCases.LogoutFunctionality_LG;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.*;
import testBase.BaseClass;

public class TC_LG_002_LogoutTest extends BaseClass {
    @Test(groups = {"Regression", "Master"})
    public void test_When_LogoutFromMyAccountRightMenu_Then_UserLogout() {
        logger.info("");
        logger.info("***  START TC_LG_002_LogoutTest ***");
        try {
            HomePage homePage = new HomePage(driver);
            logger.info("... create Home Page");
            homePage.clickMyAccount();
            logger.info("... click on 'My account' in navbar");
            homePage.clickRegister();
            logger.info("... click on 'Register'");
            AccountRegistrationPage registrationPage = new AccountRegistrationPage(driver);
            logger.info("... create Account Registration Page");

            //generate and save users params
            logger.info("... generating user data:");
            String fName = randomString().toUpperCase();
            logger.info("first name: " + fName);
            String lName = randomString().toUpperCase();
            logger.info("last name: " + lName);
            String mail = randomString() + "@gmail.com";
            logger.info("email: " + mail);
            String phone = randomNumber();
            logger.info("phone number: " + phone);
            String password = randomAlphaNumeric();
            logger.info("password: " + password + ", confirm password: " + password);

            //set parameters to corresponding fields
            logger.info("... setting user data to the corresponding fields");
            registrationPage.setFirstName(fName);
            registrationPage.setLastName(lName);
            registrationPage.setEmail(mail);
            registrationPage.setTelephone(randomNumber());
            registrationPage.setPassword(password);
            registrationPage.setConfirmPassword(password);
            registrationPage.clickPrivacyPolicy();
            logger.info("... click on 'accept policy rules' ");
            registrationPage.clickContinue();
            logger.info("... click 'Continue' button");
            registrationPage.clickMyAccount();
            logger.info("... click on 'My account' in navbar");

            MyAccountPage myAccountPage = new MyAccountPage(driver);
            myAccountPage.clickRightSideLogout();

            LogoutPage logoutPage = new LogoutPage(driver);
            logger.info("... create 'Logout' Page");
            logoutPage.clickContinue();
            logger.info("... click on 'Continue'");

            String msg = driver.getTitle();
            logger.info("... checking if user redirected to the 'Home' page (checking page title)'");
            Assert.assertEquals(msg, "Your Store", "Title not match !! TEST FAILED !!");
            logger.info("... checking that 'Logout' option is not displayed at the dropdown list");
            Assert.assertTrue(homePage.isLoginPresent());
            logger.info("... checking that 'Login' option is displayed at the dropdown list");
            Assert.assertFalse(homePage.isLogoutPresent());

        } catch (Exception ex) {
            logger.info("!! TEST FAILED !!");
            Assert.fail();
        }
        logger.info("***  END TC_LG_002_LogoutTest ***");
    }
}
