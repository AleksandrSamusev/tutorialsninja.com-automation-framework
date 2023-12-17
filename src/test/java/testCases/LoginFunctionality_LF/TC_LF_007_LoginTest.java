package testCases.LoginFunctionality_LF;
import org.openqa.selenium.Keys;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.AccountRegistrationPage;
import pageObjects.HomePage;
import pageObjects.MyAccountPage;
import testBase.BaseClass;

public class TC_LF_007_LoginTest extends BaseClass {
    @Test(groups = {"Regression", "Master"})
    public void test_checkIfUserAbleToLoginUsingTabAndEnter() {
        logger.info("");
        logger.info("***  START TC_LF_007_LoginTest ***");
        try {
            HomePage homePage = new HomePage(driver);
            logger.info("... create Home Page");
            homePage.clickMyAccount();
            logger.info("... click on 'My account' in navbar");
            homePage.clickRegister();
            logger.info("... click on 'Register'");
            AccountRegistrationPage registrationPage = new AccountRegistrationPage(driver);
            logger.info("... create Account Registration Page");

            //generate and save users params
            logger.info("... generating user data:");
            String fName = randomString().toUpperCase();
            logger.info("first name: " + fName);
            String lName = randomString().toUpperCase();
            logger.info("last name: " + lName);
            String mail = randomString() + "@gmail.com";
            logger.info("email: " + mail);
            String phone = randomNumber();
            logger.info("phone number: " + phone);
            String password = randomAlphaNumeric();
            logger.info("password: " + password + ", confirm password: " + password);

            //set parameters to corresponding fields
            logger.info("... setting user data to the corresponding fields");
            registrationPage.setFirstName(fName);
            registrationPage.setLastName(lName);
            registrationPage.setEmail(mail);
            registrationPage.setTelephone(randomNumber());
            registrationPage.setPassword(password);
            registrationPage.setConfirmPassword(password);
            registrationPage.clickPrivacyPolicy();
            logger.info("... click on 'accept policy rules' ");
            registrationPage.clickContinue();
            logger.info("... click 'Continue' button");
            registrationPage.clickMyAccount();
            logger.info("... click on 'My account' in navbar");
            registrationPage.clickLogout();
            logger.info("... click on 'Logout'");
            registrationPage.clickMyAccount();
            logger.info("... click on 'My account' in navbar");
            registrationPage.clickLogin();
            logger.info("... click on 'Login'");

            Actions actions = new Actions(driver);
            for (int i = 0; i < 23; i++) {
                actions.sendKeys(Keys.TAB).perform();
            }
            logger.info("... move to email input field by pressing TAB");
            actions.sendKeys(mail);
            logger.info("... insert valid email address: " + mail + " <----");
            actions.sendKeys(Keys.TAB).perform();
            logger.info("... move to password input field by pressing TAB");
            actions.sendKeys(password).perform();
            logger.info("... insert valid password: " + password + " <----");
            actions.sendKeys(Keys.TAB).perform();
            actions.sendKeys(Keys.TAB).perform();
            logger.info("... move to login button by pressing TAB");
            actions.sendKeys(Keys.ENTER).perform();
            logger.info("... click on 'Login' button with ENTER");

            MyAccountPage myAccountPage = new MyAccountPage(driver);
            logger.info("... create 'My Account' Page");
            String msg = myAccountPage.getMyAccountPageTitle();
            logger.info("... check the title on the My Account page");
            Assert.assertEquals(msg, "My Account", "Title not match !! TEST FAILED !!");

        } catch (Exception ex) {
            logger.info("!! TEST FAILED !!");
            Assert.fail();
        }
        logger.info("***  END TC_LF_007_LoginTest ***");
    }
}
