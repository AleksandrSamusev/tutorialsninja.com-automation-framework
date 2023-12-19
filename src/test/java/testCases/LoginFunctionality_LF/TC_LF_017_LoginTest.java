package testCases.LoginFunctionality_LF;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.*;
import testBase.BaseClass;

import java.util.List;

public class TC_LF_017_LoginTest extends BaseClass {
    @Test(groups = {"Regression", "Master"})
    public void test_usersStaysLoggedInAfterCloseBrowserAndReopenApp() {
        logger.info("");
        logger.info("***  START TC_LF_017_LoginTest ***");
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

            //
// Opens a new tab and switches to new tab
            driver.switchTo().newWindow(WindowType.TAB);
            driver.get("https://tutorialsninja.com/demo/index.php?route=common/home");
            homePage.clickMyAccount();
            homePage.clickOptionMyAccount();

            MyAccountPage myAccountPage = new MyAccountPage(driver);

            String msg = myAccountPage.getMyAccountPageTitle();

            logger.info("... check the number of options in 'My Account' drop-down list");
            Assert.assertEquals(msg, "My Account", "Title not match !! TEST FAILED !!");

        } catch (Exception ex) {
            logger.info("!! TEST FAILED !!");
            Assert.fail();
        }
        logger.info("***  END TC_LF_017_LoginTest ***");
    }
}
