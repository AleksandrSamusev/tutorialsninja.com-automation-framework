package testCases.RegisterFunctionality_RF;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import pageObjects.MyAccountPage;
import pageObjects.NewsletterPage;
import testBase.BaseClass;

public class TC_RF_006_AccountRegisterWithNoNewsletterOptionTest extends BaseClass {

    @Test(groups = {"Regression", "Master"})
    public void test_account_registration_with_yes_newsletter_option() {
        logger.info("***  TC_RF_006_AccountRegisterWithNoNewsletterOptionTest ***");
        try {
            HomePage homePage = new HomePage(driver);
            homePage.clickMyAccount();
            logger.info("clicked on Account link");
            homePage.clickRegister();
            logger.info("clicked on Register link");
            AccountRegistrationPage registrationPage = new AccountRegistrationPage(driver);

            logger.info("providing customers data");
            registrationPage.setFirstName(randomString().toUpperCase());
            registrationPage.setLastName(randomString().toUpperCase());
            registrationPage.setEmail(randomString() + "@gmail.com");
            registrationPage.setTelephone(randomNumber());

            String password = randomAlphaNumeric();

            registrationPage.setPassword(password);
            registrationPage.setConfirmPassword(password);
            registrationPage.clickPrivacyPolicy();
            registrationPage.clickContinue();
            logger.info("clicked on Continue");

            MyAccountPage myAccountPage = new MyAccountPage(driver);
            myAccountPage.clickContinue();
            myAccountPage.clickNewsletter();
            Thread.sleep(2000);

            NewsletterPage newsletterPage = new NewsletterPage(driver);
            boolean noSelected = newsletterPage.isNoBtnClicked();

            Assert.assertTrue(noSelected);

        } catch (Exception ex) {
            logger.info("test failed");
            Assert.fail();
        }
        logger.info("***  TC_RF_006_AccountRegisterWithNoNewsletterOptionTest ***");
    }
}
