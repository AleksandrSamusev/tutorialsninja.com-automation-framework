package testCases.RegisterFunctionality_RF;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import pageObjects.TabletsPage;
import testBase.BaseClass;

public class TC_RF_023_12_AccountRegisterHeaderValidationTest extends BaseClass {
    @Test(groups = {"Regression", "Master"})
    public void test_whenEmailFormatIncorrect_thenAccountNotCreated() {
        logger.info("");
        logger.info("***  TC_RF_023_12_AccountRegisterHeaderValidationTest ***");
        try {
            HomePage homePage = new HomePage(driver);
            logger.info("... create Home Page");
            homePage.clickMyAccount();
            logger.info("... click on 'My account' in navbar");
            homePage.clickRegister();
            logger.info("... click on 'Register'");
            AccountRegistrationPage registrationPage = new AccountRegistrationPage(driver);
            logger.info("... create Account Registration Page");

            registrationPage.clickTablets();
            logger.info("... click on 'Tablets'");

            TabletsPage tabletsPage = new TabletsPage(driver);
            logger.info("... create Tablets Page");

            String msg = tabletsPage.getTabletsPageTitle();
            Assert.assertEquals(msg, "Tablets", "Title not match !! TEST FAILED !!");

        } catch (Exception ex) {
            logger.info("!! TEST FAILED !!");
            Assert.fail();
        }
        logger.info("***  TC_RF_023_12_AccountRegisterHeaderValidationTest ***");
    }
}
