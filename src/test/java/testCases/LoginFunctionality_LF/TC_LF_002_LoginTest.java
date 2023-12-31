package testCases.LoginFunctionality_LF;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC_LF_002_LoginTest extends BaseClass {
    @Test(groups = {"Regression", "Master"})
    public void test_When_InvalidEmailAndInvalidPassword_Then_Warning() {
        logger.info("");
        logger.info("***  START TC_LF_002_LoginTest ***");
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
            registrationPage.clickLogout();
            logger.info("... click on 'Logout'");
            registrationPage.clickMyAccount();
            logger.info("... click on 'My account' in navbar");
            registrationPage.clickLogin();
            logger.info("... click on 'Login'");

            LoginPage loginPage = new LoginPage(driver);
            logger.info("... create 'Login' Page");

            loginPage.getTxtEmail().sendKeys(randomString() + "@gmail.com");
            logger.info("... setting users email");
            loginPage.getTxtPassword().sendKeys(randomAlphaNumeric());
            logger.info("... setting users password");
            loginPage.clickLogin();
            logger.info("... click on 'Login'");

            String msg = loginPage.getMsgInvalidCredentials();
            logger.info("... check the title on the My Account page");
            Assert.assertEquals(msg, "Warning: No match for E-Mail Address and/or Password.",
                    "Title not match !! TEST FAILED !!");
        } catch (Exception ex) {
            logger.info("!! TEST FAILED !!");
            Assert.fail();
        }
        logger.info("***  END TC_LF_002_LoginTest ***");
    }
}
