package testCases.RegisterFunctionality_RF;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_RF_023_2_AccountRegisterUserDataTest extends BaseClass {
    @Test(groups = {"Regression", "Master"})
    public void test_whenClickOnPrivacyPolicy_thenProperNavigation() {
        logger.info("");
        logger.info("***  START TC_RF_023_2_AccountRegisterUserDataTest ***");
        try {
            HomePage homePage = new HomePage(driver);
            logger.info("... create Home Page");
            homePage.clickMyAccount();
            logger.info("... click on 'My account' in navbar");
            homePage.clickRegister();
            logger.info("... click on 'Register'");
            AccountRegistrationPage registrationPage = new AccountRegistrationPage(driver);
            logger.info("... create Account Registration Page");

            registrationPage.clickPrivacyPolicyUnderForm();

            String msg = driver.findElement(By.xpath("//h4[@class='modal-title']")).getText();
            Assert.assertEquals(msg, "Privacy Policy", "Title not match !! TEST FAILED !!");

        } catch (Exception ex) {
            logger.info("!! TEST FAILED !!");
            Assert.fail();
        }
        logger.info("***  FINISH TC_RF_023_2_AccountRegisterUserDataTest ***");
    }
}
