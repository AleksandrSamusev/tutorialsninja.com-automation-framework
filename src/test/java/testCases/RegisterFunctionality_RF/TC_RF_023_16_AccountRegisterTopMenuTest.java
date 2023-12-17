package testCases.RegisterFunctionality_RF;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import pageObjects.Mp3PlayersPage;
import testBase.BaseClass;

public class TC_RF_023_16_AccountRegisterHeaderValidationTest extends BaseClass {
    @Test(groups = {"Regression", "Master"})
    public void test_whenEmailFormatIncorrect_thenAccountNotCreated() {
        logger.info("");
        logger.info("***  START TC_RF_023_16_AccountRegisterHeaderValidationTest ***");
        try {
            HomePage homePage = new HomePage(driver);
            logger.info("... create Home Page");
            homePage.clickMyAccount();
            logger.info("... click on 'My account' in navbar");
            homePage.clickRegister();
            logger.info("... click on 'Register'");
            AccountRegistrationPage registrationPage = new AccountRegistrationPage(driver);
            logger.info("... create Account Registration Page");

            Actions actions = new Actions(driver);
            actions.moveToElement(registrationPage.getMp3Players()).perform();
            actions.moveToElement(registrationPage.getShowAllMp3Players()).perform();
            registrationPage.clickShowAllMp3Players();

            Mp3PlayersPage mp3PlayersPage = new Mp3PlayersPage(driver);

            String msg = mp3PlayersPage.getPageTitle();
            Assert.assertEquals(msg, "MP3 Players", "Title not match !! TEST FAILED !!");

        } catch (Exception ex) {
            logger.info("!! TEST FAILED !!");
            Assert.fail();
        }
        logger.info("***  END TC_RF_023_16_AccountRegisterHeaderValidationTest ***");
    }
}
