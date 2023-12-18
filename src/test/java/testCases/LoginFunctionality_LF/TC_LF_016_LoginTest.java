package testCases.LoginFunctionality_LF;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.*;
import testBase.BaseClass;

public class TC_LF_016_LoginTest extends BaseClass {
    @Test(groups = {"Regression", "Master"})
    public void test_when_changePassword_then_userCanLoginWithNewPassword() {
        logger.info("");
        logger.info("***  START TC_LF_016_LoginTest ***");
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
            registrationPage.clickRightSideMyAccount();
            logger.info("... click 'My Account' at the right side menu");

            MyAccountPage myAccountPage = new MyAccountPage(driver);
            logger.info("... create 'My Account' Page");
            myAccountPage.clickChangeYourPassword();
            logger.info("... click 'Change Your Password' at 'My Account' section");

            ChangePasswordPage changePasswordPage = new ChangePasswordPage(driver);
            logger.info("... create 'Change Password' Page");
            String newPassword = randomAlphaNumeric();
            logger.info("... generating new password: " + newPassword + " <------");
            changePasswordPage.getTxtPassword().sendKeys(newPassword);
            logger.info("... setting new password to the 'Password' input field");
            changePasswordPage.getTxtConfirmPassword().sendKeys(newPassword);
            logger.info("... setting new password to the 'Password Confirm' input field");
            changePasswordPage.clickContinue();

            myAccountPage.clickLogout();
            logger.info("... login out");
            myAccountPage.clickContinue();

            homePage.clickMyAccount();
            logger.info("... click 'My Account' in navbar");
            homePage.clickLogin();
            logger.info("click 'Login' option");

            LoginPage loginPage = new LoginPage(driver);
            loginPage.getTxtEmail().sendKeys(mail);
            logger.info("... sending email to 'E-Mail Address' input field: " + mail + " <---");
            loginPage.getTxtPassword().sendKeys(newPassword);
            logger.info("... sending new password to 'Password' input field: " + newPassword + " <---");
            loginPage.clickLogin();
            logger.info("click 'Login' button");

            String msg = myAccountPage.getMyAccountPageTitle();
            logger.info("... check the title on the My Account page");
            Assert.assertEquals(msg, "My Account", "Title not match !! TEST FAILED !!");

        } catch (Exception ex) {
            logger.info("!! TEST FAILED !!");
            Assert.fail();
        }
        logger.info("***  END TC_LF_016_LoginTest ***");
    }
}
