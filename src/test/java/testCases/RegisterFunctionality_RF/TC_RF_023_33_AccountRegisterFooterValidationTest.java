package testCases.RegisterFunctionality_RF;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import pageObjects.PrivacyPolicyPage;
import pageObjects.TermsAndConditionsPage;
import testBase.BaseClass;

public class TC_RF_023_33_AccountRegisterFooterValidationTest extends BaseClass {
    @Test(groups = {"Regression", "Master"})
    public void test_whenEmailFormatIncorrect_thenAccountNotCreated() {
        logger.info("");
        logger.info("***  START TC_RF_023_33_AccountRegisterFooterValidationTest ***");
        try {
            HomePage homePage = new HomePage(driver);
            logger.info("... create Home Page");
            homePage.clickMyAccount();
            logger.info("... click on 'My account' in navbar");
            homePage.clickRegister();
            logger.info("... click on 'Register'");
            AccountRegistrationPage registrationPage = new AccountRegistrationPage(driver);
            logger.info("... create Account Registration Page");

            registrationPage.clickFooterTermsAndConditions();
            logger.info("... click on 'Terms & Conditions' on footer");

            TermsAndConditionsPage termsAndConditionsPage = new TermsAndConditionsPage(driver);

            String msg = termsAndConditionsPage.getTermsAndConditionsPageTitle();
            Assert.assertEquals(msg, "Terms & Conditions", "Title not match !! TEST FAILED !!");

        } catch (Exception ex) {
            logger.info("!! TEST FAILED !!");
            Assert.fail();
        }
        logger.info("***  END TC_RF_023_33_AccountRegisterFooterValidationTest ***");
    }
}
