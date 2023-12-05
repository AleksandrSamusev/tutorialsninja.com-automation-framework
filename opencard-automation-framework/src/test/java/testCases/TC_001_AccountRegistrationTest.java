package testCases;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_001_AccountRegistrationTest extends BaseClass {

    @Test
    void test_account_registration() {
        try {
            HomePage homePage = new HomePage(driver);
            homePage.clickMyAccount();
            Thread.sleep(1000);
            homePage.clickRegister();

            AccountRegistrationPage registrationPage = new AccountRegistrationPage(driver);
            registrationPage.setFirstName(randomString().toUpperCase());
            registrationPage.setLastName(randomString().toUpperCase());
            registrationPage.setEmail(randomString() + "@gmail.com");
            registrationPage.setTelephone(randomNumber());

            String password = randomAlphaNumeric();

            registrationPage.setPassword(password);
            registrationPage.setConfirmPassword(password);
            registrationPage.clickPrivacyPolicy();
            registrationPage.clickContinue();

            String confMsg = registrationPage.getConfirmationMessage();

            Assert.assertEquals(confMsg, "Your Account Has Been Created!");
        } catch (Exception ex) {
            Assert.fail();
        }
    }

}
