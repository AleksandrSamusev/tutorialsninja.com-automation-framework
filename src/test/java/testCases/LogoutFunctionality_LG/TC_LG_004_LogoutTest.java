package testCases.LogoutFunctionality_LG;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.*;
import testBase.BaseClass;

public class TC_LG_004_LogoutTest extends BaseClass {
    @Test(groups = {"Regression", "Master"})
    public void test_When_LogoutAndClickBack_Then_UserStaysLogout() {
        logger.info("");
        logger.info("***  START TC_LG_004_LogoutTest ***");
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

            SuccessPage successPage = new SuccessPage(driver);
            successPage.clickContinue();

            MyAccountPage myAccountPage = new MyAccountPage(driver);
            myAccountPage.clickHeaderMyAccount();
            myAccountPage.clickHeaderLogout();
            driver.navigate().back();
            myAccountPage.clickRightSideMyAccount();

            LoginPage loginPage = new LoginPage(driver);
            String msg = loginPage.getNewCustomerTitle();

            Assert.assertEquals(msg, "New Customer", "Title not match! TEST FAILED!");

        } catch (Exception ex) {
            logger.info("!! TEST FAILED !!");
            Assert.fail();
        }
        logger.info("***  END TC_LG_004_LogoutTest ***");
    }
}
