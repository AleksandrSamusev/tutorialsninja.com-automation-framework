package testCases.HomePageFunctionality_HP;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.*;
import testBase.BaseClass;

public class TC_HP_002_HomePageTest extends BaseClass {
    @Test(groups = {"Regression", "Master"})
    public void test_When_ClickContinueShoppingOnOrderSuccessPage_Then_RedirectToHomePage() {
        logger.info("");
        logger.info("***  START TC_HP_002_HomePageTest ***");
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

            SuccessPage successPage = new SuccessPage(driver);
            logger.info("... create 'Success' Page");
            successPage.clickContinue();
            logger.info("... click 'Continue' button on 'Success' Page");

            MyAccountPage myAccountPage = new MyAccountPage(driver);
            logger.info("... create 'My Account' Page");
            myAccountPage.clickLogo();
            logger.info("... redirecting to Home Page by click 'Qafox.com' logo on the top of the page");

            homePage.clickMenuDesktops();
            logger.info("... click 'Desktops' in page menu");
            homePage.clickMenuShowAllDesktops();
            logger.info("... click 'Show All Desktops' option in dropdown list");
            DesktopsPage desktopsPage = new DesktopsPage(driver);
            logger.info("... create 'Desktops' Page");
            desktopsPage.clickAddToCart();
            logger.info("... click 'Add to cart' button on product 'HP LP3065'");

            HP_LP3065_Page hpLp3065Page = new HP_LP3065_Page(driver);
            logger.info("... create 'HP LP3065' Page");
            hpLp3065Page.clickAddToCart();
            logger.info("... click 'Add to cart' button on product 'HP LP3065' Page");
            Thread.sleep(500);
            logger.info("... setting 500ms delay");
            hpLp3065Page.clickShoppingCart();
            logger.info("... click 'Shopping cart' link in success message");
            ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
            logger.info("... create 'Shopping Cart' Page");
            shoppingCartPage.clickCheckout();
            logger.info("... click on 'Checkout' button");

            CheckoutPage checkoutPage = new CheckoutPage(driver);
            logger.info("... create 'Checkout' Page");
            checkoutPage.setFirstName("test");
            logger.info("... setting first name - 'test'");
            checkoutPage.setLastName("test");
            logger.info("... setting last name - 'test'");
            checkoutPage.setCompany("test");
            logger.info("... setting company name - 'test'");
            checkoutPage.setAddress1("test");
            logger.info("... setting Address 1 - 'test'");
            checkoutPage.setAddress2("test");
            logger.info("... setting Address 2 - 'test'");
            checkoutPage.setCity("test");
            logger.info("... setting City - 'test'");
            checkoutPage.setPostCode("21000");
            logger.info("... setting Post Code - '21000'");

            Select county = new Select(checkoutPage.getSelectCountry());
            county.selectByVisibleText("Mexico");
            logger.info("... setting country - 'Mexico'");

            Select region = new Select(checkoutPage.getSelectRegion());
            region.selectByVisibleText("Mexico");
            logger.info("... setting region - 'Mexico'");

            checkoutPage.clickStep2Continue();
            logger.info("...click 'Continue' button for STEP 2");
            checkoutPage.clickStep3Continue();
            logger.info("...click 'Continue' button for STEP 3");
            checkoutPage.clickStep4Continue();
            logger.info("...click 'Continue' button for STEP 4");
            checkoutPage.clickTerms();
            logger.info("...click checkbox 'Terms and Conditions'");
            checkoutPage.clickStep5Continue();
            logger.info("...click 'Continue' button for STEP 5");
            checkoutPage.clickConfirmOrder();
            logger.info("...click 'Confirm Order' button");

            CheckoutSuccessPage checkoutSuccessPage = new CheckoutSuccessPage(driver);
            logger.info("... create 'Checkout success' Page");
            checkoutSuccessPage.clickContinue();
            logger.info("... click 'Continue' on 'Checkout success' Page");
            logger.info("... validating redirection to the Home Page");

            Assert.assertEquals(driver.getCurrentUrl(),
                    "https://tutorialsninja.com/demo/index.php?route=common/home");

        } catch (Exception ex) {
            logger.info("!! TEST FAILED !!");
            Assert.fail();
        }
        logger.info("***  END TC_HP_002_HomePageTest ***");
    }
}
