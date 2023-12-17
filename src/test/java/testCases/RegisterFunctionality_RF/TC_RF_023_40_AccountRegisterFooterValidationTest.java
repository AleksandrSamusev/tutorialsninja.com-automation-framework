package testCases.RegisterFunctionality_RF;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.AffiliateProgramPage;
import pageObjects.HomePage;
import pageObjects.SpecialOffersPage;
import testBase.BaseClass;

public class TC_RF_023_40_AccountRegisterFooterValidationTest extends BaseClass {
    @Test(groups = {"Regression", "Master"})
    public void test_whenEmailFormatIncorrect_thenAccountNotCreated() {
        logger.info("");
        logger.info("***  START TC_RF_023_40_AccountRegisterFooterValidationTest ***");
        try {
            HomePage homePage = new HomePage(driver);
            logger.info("... create Home Page");
            homePage.clickMyAccount();
            logger.info("... click on 'My account' in navbar");
            homePage.clickRegister();
            logger.info("... click on 'Register'");
            AccountRegistrationPage registrationPage = new AccountRegistrationPage(driver);
            logger.info("... create Account Registration Page");

            registrationPage.clickFooterSpecials();
            logger.info("... click on 'Specials' on footer");

            SpecialOffersPage specialOffersPage = new SpecialOffersPage(driver);

            String msg = specialOffersPage.getSpecialOffersPageTitle();
            Assert.assertEquals(msg, "Special Offers", "Title not match !! TEST FAILED !!");

        } catch (Exception ex) {
            logger.info("!! TEST FAILED !!");
            Assert.fail();
        }
        logger.info("***  END TC_RF_023_40_AccountRegisterFooterValidationTest ***");
    }
}
