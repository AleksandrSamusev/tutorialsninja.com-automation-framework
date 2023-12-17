package testCases.RegisterFunctionality_RF;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import testBase.BaseClass;

public class TC_RF_007_AccountRegisterNewCustomerTest extends BaseClass {

    @Test(groups = {"Regression", "Master"})
    public void test_whenClickContinueInNewCustomer_thenRegisterPageShown() {
        logger.info("****  starting TC_RF_007_AccountRegisterNewCustomerTest  ****");
        try {
            HomePage homePage = new HomePage(driver);
            homePage.clickMyAccount();
            homePage.clickLogin();
            LoginPage loginPage = new LoginPage(driver);
            loginPage.clickNewCustomerContinueBtn();
            AccountRegistrationPage accountRegistrationPage = new AccountRegistrationPage(driver);
            String title = accountRegistrationPage.getPageTitle();
            Assert.assertEquals(title, "Register Account");
        } catch (Exception e) {
            logger.info("test failed");
            Assert.fail();
        }
        logger.info("***  Finished TC_RF_007_AccountRegisterNewCustomerTest ***");
    }
}
