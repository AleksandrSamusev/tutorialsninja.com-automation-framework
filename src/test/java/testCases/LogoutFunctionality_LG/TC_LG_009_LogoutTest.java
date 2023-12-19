package testCases.LogoutFunctionality_LG;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.*;
import testBase.BaseClass;

import java.util.List;

public class TC_LG_009_LogoutTest extends BaseClass {
    @Test(groups = {"Regression", "Master"})
    public void test_LogoutPageValidation() {
        logger.info("");
        logger.info("***  START TC_LG_009_LogoutTest ***");
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

            LogoutPage logoutPage = new LogoutPage(driver);
            String title = logoutPage.getLogoutPageTitle();
            WebElement breadcrumbs = logoutPage.getListBreadcrumbs();
            List<WebElement> breadcrumbsCount = breadcrumbs.findElements(By.xpath("//div[@id='common-success']//ul/li"));

            Assert.assertEquals(breadcrumbsCount.size(), 3);
            Assert.assertEquals(breadcrumbsCount.get(1).getText(), "Account");
            Assert.assertEquals(breadcrumbsCount.get(2).getText(), "Logout");
            Assert.assertEquals(title, "Account Logout", "Title not match !! TEST FAILED !!");
            Assert.assertEquals(driver.getCurrentUrl(),
                    "https://tutorialsninja.com/demo/index.php?route=account/logout");

        } catch (Exception ex) {
            logger.info("!! TEST FAILED !!");
            Assert.fail();
        }
        logger.info("***  END TC_LG_009_LogoutTest ***");
    }
}
