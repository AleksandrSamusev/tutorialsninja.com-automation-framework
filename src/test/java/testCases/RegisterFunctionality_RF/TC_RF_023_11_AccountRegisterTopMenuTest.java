package testCases.RegisterFunctionality_RF;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.ComponentsPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_RF_023_11_AccountRegisterTopMenuTest extends BaseClass {
    @Test(groups = {"Regression", "Master"})
    public void test_whenEmailFormatIncorrect_thenAccountNotCreated() {
        logger.info("");
        logger.info("***  TC_RF_023_11_AccountRegisterTopMenuTest ***");
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

            actions.moveToElement(registrationPage.getComponents()).perform();
            logger.info("... perform hover over 'Components' option");
            actions.moveToElement(registrationPage.getShowAllComponents()).perform();
            logger.info("... perform hover over 'Show AllComponents' option");
            registrationPage.clickShowAllComponents();
            logger.info("... click on 'Show AllComponents'");

            ComponentsPage componentsPage = new ComponentsPage(driver);
            logger.info("... create Components Page");

            String msg = componentsPage.getComponentsPageTitle();
            Assert.assertEquals(msg, "Components", "Title not match !! TEST FAILED !!");

        } catch (Exception ex) {
            logger.info("!! TEST FAILED !!");
            Assert.fail();
        }
        logger.info("***  TC_RF_023_11_AccountRegisterTopMenuTest ***");
    }
}
