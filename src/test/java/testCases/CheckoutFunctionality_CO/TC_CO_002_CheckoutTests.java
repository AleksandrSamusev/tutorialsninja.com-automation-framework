package testCases.CheckoutFunctionality_CO;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.*;
import testBase.BaseClass;

public class TC_CO_002_CheckoutTests extends BaseClass {
    @Test(groups = {"Regression", "Master"})
    public void test_When_ClickCheckoutButton_Then_CheckoutPage() {
        logger.info("");
        logger.info("***  START TC_CO_002_CheckoutTests ***");
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

            homePage.getTxtSearchInput().sendKeys("LP3065");
            logger.info("... set name of the product (LP3065) to the search field");
            homePage.clickSearch();
            logger.info("...click search button");
            SearchPage searchPage = new SearchPage(driver);
            logger.info("... create new 'Search' Page");
            searchPage.clickAddToCart();
            logger.info("...click 'Add to cart' button in product Card");
            HP_LP3065_Page hpLp3065Page = new HP_LP3065_Page(driver);
            logger.info("... create new Product Page");
            hpLp3065Page.clickAddToCart();
            logger.info("...click 'Add to cart' in Product page");
            hpLp3065Page.clickShoppingCart();
            logger.info("...click 'Shopping Cart' in success message");
            ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
            logger.info("... create new 'Shopping Cart' Page");
            shoppingCartPage.clickCheckout();
            logger.info("...click 'Checkout' in Shopping Cart page");

            Assert.assertEquals(driver.getCurrentUrl(),
                    "https://tutorialsninja.com/demo/index.php?route=checkout/checkout");
            Assert.assertEquals(driver.getTitle(), "Checkout");

        } catch (Exception ex) {
            logger.info("!! TEST FAILED !!");
            Assert.fail();
        }
        logger.info("***  END TC_CO_002_CheckoutTests ***");
    }
}
