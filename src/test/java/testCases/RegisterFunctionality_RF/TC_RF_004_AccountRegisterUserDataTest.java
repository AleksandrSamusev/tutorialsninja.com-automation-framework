package testCases.RegisterFunctionality_RF;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_RF_004_AccountRegisterUserDataTest extends BaseClass {

    @Test(groups = {"Regression", "Master"})
    public void test_validation_messages() {
        logger.info("****  Starting TC_RF_004_AccountRegisterUserDataTest ****");
        try {
            HomePage homePage = new HomePage(driver);
            homePage.clickMyAccount();
            logger.info("click on MyAccount");
            homePage.clickRegister();
            logger.info("click on Register");
            AccountRegistrationPage accountRegistrationPage = new AccountRegistrationPage(driver);
            accountRegistrationPage.clickContinue();
            logger.info("click on Continue without providing any data");

            String firstNameMessage = accountRegistrationPage.getFirstNameValidationMessage();
            String lastNameMessage = accountRegistrationPage.getLastNameValidationMessage();
            String emailMessage = accountRegistrationPage.getEmailValidationMessage();
            String phoneMessage = accountRegistrationPage.getPhoneValidationMessage();
            String passwordMessage = accountRegistrationPage.getPasswordValidationMessage();
            String policyMessage = accountRegistrationPage.getPolicyValidationMessage();

            Assert.assertEquals(firstNameMessage, "First Name must be between 1 and 32 characters!");
            Assert.assertEquals(lastNameMessage, "Last Name must be between 1 and 32 characters!");
            Assert.assertEquals(emailMessage, "E-Mail Address does not appear to be valid!");
            Assert.assertEquals(phoneMessage, "Telephone must be between 3 and 32 characters!");
            Assert.assertEquals(passwordMessage, "Password must be between 4 and 20 characters!");
            Assert.assertEquals(policyMessage, "Warning: You must agree to the Privacy Policy!");

        } catch (Exception ex) {
            logger.info("test failed");
            Assert.fail();
        }
        logger.info("***  Finished TC_RF_004_AProperValidationMessagesTest  ***");

    }
}
