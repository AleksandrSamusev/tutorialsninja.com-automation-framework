package testCases.RegisterFunctionality_RF;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import pageObjects.LaptopsAndNotebooksPage;
import testBase.BaseClass;

public class TC_RF_023_10_AccountRegisterHeaderValidationTest extends BaseClass {
    @Test(groups = {"Regression", "Master"})
    public void test_whenEmailFormatIncorrect_thenAccountNotCreated() {
        logger.info("");
        logger.info("***  TC_RF_023_10_AccountRegisterHeaderValidationTest ***");
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

            actions.moveToElement(registrationPage.getLaptopsAndNotebooks()).perform();
            logger.info("... perform hover over Laptops & Notebooks option");
            actions.moveToElement(registrationPage.getShowAllLaptopsAndNotebooks()).perform();
            logger.info("... perform hover over Show AllLaptops & Notebooks option");
            registrationPage.clickShowAllLaptopsAndNotebooks();
            logger.info("... click on 'Show AllLaptops & Notebooks'");

            LaptopsAndNotebooksPage page = new LaptopsAndNotebooksPage(driver);
            logger.info("... create Laptops And NotebooksPage Page");

            String msg = page.getPageTitle();
            Assert.assertEquals(msg, "Laptops & Notebooks", "Title not match !! TEST FAILED !!");

        } catch (Exception ex) {
            logger.info("!! TEST FAILED !!");
            Assert.fail();
        }
        logger.info("***  TC_RF_023_10_AccountRegisterHeaderValidationTest ***");
    }
}
