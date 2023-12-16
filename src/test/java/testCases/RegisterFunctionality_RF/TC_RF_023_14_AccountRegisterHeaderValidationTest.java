package testCases.RegisterFunctionality_RF;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import pageObjects.PhonesAndPDAsPage;
import pageObjects.SoftwarePage;
import testBase.BaseClass;

public class TC_RF_023_14_AccountRegisterHeaderValidationTest extends BaseClass {
    @Test(groups = {"Regression", "Master"})
    public void test_whenEmailFormatIncorrect_thenAccountNotCreated() {
        logger.info("");
        logger.info("***  START TC_RF_023_14_AccountRegisterHeaderValidationTest ***");
        try {
            HomePage homePage = new HomePage(driver);
            logger.info("... create Home Page");
            homePage.clickMyAccount();
            logger.info("... click on 'My account' in navbar");
            homePage.clickRegister();
            logger.info("... click on 'Register'");
            AccountRegistrationPage registrationPage = new AccountRegistrationPage(driver);
            logger.info("... create Account Registration Page");

            registrationPage.clickPhonesAndPDAs();
            logger.info("... click on 'Phones & PDAs'");

            PhonesAndPDAsPage phonesAndPDAsPage = new PhonesAndPDAsPage(driver);
            logger.info("... create 'Phones and PDAs' Page");

            String msg = phonesAndPDAsPage.getPhonesAndPDAsPageTitle();
            Assert.assertEquals(msg, "Phones & PDAs", "Title not match !! TEST FAILED !!");

        } catch (Exception ex) {
            logger.info("!! TEST FAILED !!");
            Assert.fail();
        }
        logger.info("***  END TC_RF_023_14_AccountRegisterHeaderValidationTest ***");
    }
}
