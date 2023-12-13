package testCases.RegisterFunctionality_RF;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_RF_009_AccountRegisterWithSameParamsTest extends BaseClass {

    @Test(groups = {"Regression", "Master"})
    public void test_when_createUserWithSameParams_then_ValidationMessage() {
        logger.info("***  TC_RF_009_AccountRegisterWithSameParamsTest ***");
        try {
            HomePage homePage = new HomePage(driver);
            logger.info(" ----> START CYCLE 1 <----");
            logger.info("... create Home Page");
            homePage.clickMyAccount();
            logger.info("... click on 'My account' in navbar");
            homePage.clickRegister();
            logger.info("... click on 'Register'");
            AccountRegistrationPage registrationPage = new AccountRegistrationPage(driver);
            logger.info("... create Account Registration Page");

            logger.info("... generating user data:");
            //generate and save users params
            String fName = randomString().toUpperCase(); //first name
            logger.info("first name: " + fName);
            String lName = randomString().toUpperCase(); //last name
            logger.info("last name: " + lName);
            String mail = randomString() + "@gmail.com"; //email
            logger.info("email: " + mail);
            String phone = randomNumber(); // telephone
            logger.info("phone number: " + phone);
            String password = randomAlphaNumeric(); //password and confirmation
            logger.info("password: " + password + ", confirm password: " + password);
            logger.info("... setting user data to the corresponding fields");

            registrationPage.setFirstName(fName);
            registrationPage.setLastName(lName);
            registrationPage.setEmail(mail);
            registrationPage.setTelephone(phone);
            registrationPage.setPassword(password);
            registrationPage.setConfirmPassword(password);
            registrationPage.clickPrivacyPolicy();

            logger.info("... click on 'accept policy rules' ");
            registrationPage.clickOnYesRadioBtn();
            logger.info("... click on 'Subscribe -> Yes' button");
            logger.info("... click 'Continue' button");
            registrationPage.clickContinue();

            logger.info("... create My Account Page");
            MyAccountPage myAccountPage = new MyAccountPage(driver);
            logger.info("... click 'Logout' button");
            myAccountPage.clickLogout();
            logger.info("... click 'Continue' button");
            myAccountPage.clickContinue();

            //register new user with same params
            logger.info(" ----> START CYCLE 2 <----");
            logger.info("... crete Home Page");
            HomePage homePage2 = new HomePage(driver);
            logger.info("... click on 'My account' in navbar");
            homePage2.clickMyAccount();
            logger.info("... click on 'Register'");
            homePage2.clickRegister();
            logger.info("... create Account RegistrationP age");
            AccountRegistrationPage registrationPage2 = new AccountRegistrationPage(driver);

            //set earlier generated values
            logger.info("... set earlier generated user values...");
            registrationPage2.setFirstName(fName);
            logger.info("first name: " + fName);
            registrationPage2.setLastName(lName);
            logger.info("last name: " + lName);
            registrationPage2.setEmail(mail);
            logger.info("email: " + mail);
            registrationPage2.setTelephone(phone);
            logger.info("phone number: " + phone);
            registrationPage2.setPassword(password);
            registrationPage2.setConfirmPassword(password);
            logger.info("password : " + password + ", confirm password: " + password);
            registrationPage2.clickPrivacyPolicy();
            logger.info("... click on 'accept policy rules' ");
            registrationPage2.clickOnYesRadioBtn();
            logger.info("... click on 'Subscribe -> Yes' button");
            registrationPage2.clickContinue();

            String msg = registrationPage2.getMsgTop();
            logger.info("... validation message on the top of the page - " + msg);
            Assert.assertEquals(msg, "Warning: E-Mail Address is already registered!");
        } catch (Exception ex) {
            logger.info("!!! TEST FAILED !!!");
            Assert.fail();
        }
        logger.info("*** PASSED  Finished TC_RF_009_AccountRegisterWithSameParamsTest ***");
    }
}
