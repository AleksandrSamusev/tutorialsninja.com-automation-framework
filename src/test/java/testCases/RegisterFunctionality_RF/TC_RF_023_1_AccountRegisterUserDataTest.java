package testCases.RegisterFunctionality_RF;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC_RF_023_1_AccountRegisterUserDataTest extends BaseClass {
    @Test(groups = {"Regression", "Master"})
    public void test_whenClickOnPrivacyPolicy_thenProperNavigation() {
        logger.info("");
        logger.info("***  START TC_RF_023_1_AccountRegisterUserDataTest ***");
        try {
            HomePage homePage = new HomePage(driver);
            logger.info("... create Home Page");
            homePage.clickMyAccount();
            logger.info("... click on 'My account' in navbar");
            homePage.clickRegister();
            logger.info("... click on 'Register'");
            AccountRegistrationPage registrationPage = new AccountRegistrationPage(driver);
            logger.info("... create Account Registration Page");

            registrationPage.clickLoginPageLinkUnderTitle();

            LoginPage loginPage = new LoginPage(driver);


            String msg = loginPage.getNewCustomerTitle();
            Assert.assertEquals(msg, "New Customer", "Title not match !! TEST FAILED !!");

        } catch (Exception ex) {
            logger.info("!! TEST FAILED !!");
            Assert.fail();
        }
        logger.info("***  FINISH TC_RF_023_1_AccountRegisterUserDataTest ***");
    }
}
