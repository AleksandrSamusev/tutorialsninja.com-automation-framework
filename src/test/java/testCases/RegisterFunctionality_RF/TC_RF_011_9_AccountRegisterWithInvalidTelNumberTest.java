package testCases.RegisterFunctionality_RF;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_RF_011_9_AccountRegisterWithInvalidTelNumberTest extends BaseClass {
    @Test(groups = {"Regression", "Master"})
    public void test_whenEmailFormatIncorrect_thenAccountNotCreated() {
        logger.info("");
        logger.info("***  TC_RF_011_9_AccountRegisterWithInvalidTelNumberTest ***");
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
            String phone = ",./~_';!@#$%^&*(";
            logger.info("phone number: " + phone);
            String password = randomAlphaNumeric();
            logger.info("password: " + password + ", confirm password: " + password);

            //set parameters to corresponding fields
            logger.info("... setting user data to the corresponding fields");
            registrationPage.setFirstName(fName);
            registrationPage.setLastName(lName);
            registrationPage.setEmail(mail);
            registrationPage.setTelephone(phone);
            registrationPage.setPassword(password);
            registrationPage.setConfirmPassword(password);
            registrationPage.clickPrivacyPolicy();
            logger.info("... click on 'accept policy rules' ");

            registrationPage.clickContinue();
            logger.info("... click 'Continue' button");
            String msg = registrationPage.getPhoneValidationMessage();
            logger.info("... validation message - " + msg);
            String title = registrationPage.getPageTitle();
            logger.info("... validation page title - " + title);
            Assert.assertEquals(msg, "Telephone does not appear to be valid!");
            Assert.assertEquals(title, "Register Account");
        } catch (Exception ex) {
            logger.info("!! TEST FAILED !!");
            Assert.fail();
        }
        logger.info("***  TC_RF_011_9_AccountRegisterWithInvalidTelNumberTest ***");
    }
}
