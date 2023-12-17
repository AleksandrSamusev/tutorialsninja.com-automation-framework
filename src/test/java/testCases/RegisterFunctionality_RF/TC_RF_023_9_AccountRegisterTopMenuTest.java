package testCases.RegisterFunctionality_RF;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.DesktopsPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_RF_023_9_AccountRegisterTopMenuTest extends BaseClass {
    @Test(groups = {"Regression", "Master"})
    public void test_whenEmailFormatIncorrect_thenAccountNotCreated() {
        logger.info("");
        logger.info("***  TC_RF_023_9_AccountRegisterTopMenuTest ***");
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

            actions.moveToElement(registrationPage.getDesktops()).perform();
            logger.info("... perform hover over Desktops option");
            actions.moveToElement(registrationPage.getShowAllDesktops()).perform();
            logger.info("... perform hover over Show AllDesktops option");
            registrationPage.clickShowAllDesktops();
            logger.info("... click on 'Show AllDesktops'");

            DesktopsPage desktopsPage = new DesktopsPage(driver);
            logger.info("... create Desktop Page");

            String msg = desktopsPage.getPageTitle();
            Assert.assertEquals(msg, "Desktops", "Title not match !! TEST FAILED !!");

        } catch (Exception ex) {
            logger.info("!! TEST FAILED !!");
            Assert.fail();
        }
        logger.info("***  TC_RF_023_9_AccountRegisterTopMenuTest ***");
    }
}
