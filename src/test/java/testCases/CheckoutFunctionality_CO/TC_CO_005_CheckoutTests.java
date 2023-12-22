package testCases.CheckoutFunctionality_CO;

import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.*;
import testBase.BaseClass;

public class TC_CO_005_CheckoutTests extends BaseClass {
    @Test(groups = {"Regression", "Master"})
    public void test_When_ClickContinueShoppingOnOrderSuccessPage_Then_RedirectToHomePage() {

        String productName;
        String productDeliveryDate;
        String productModel;
        String productQuantity;
        String productUnitPrice;
        String productTotal;
        String productSubTotal;
        String flatShippingRate;
        String productTotalEnd;


        logger.info("");
        logger.info("***  START TC_CO_005_CheckoutTests ***");
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
            Thread.sleep(1000);
            logger.info("... redirecting to Home Page by click 'Qafox.com' logo on the top of the page");

            homePage.getTxtSearchInput().sendKeys("LP3065");
            logger.info("... set name of the product (LP3065) to the search field");
            homePage.clickSearch();
            Thread.sleep(1000);
            logger.info("...click search button");
            SearchPage searchPage = new SearchPage(driver);
            logger.info("... create new 'Search' Page");
            searchPage.clickAddToCart();
            Thread.sleep(1000);
            logger.info("...click 'Add to cart' button in product Card");
            Thread.sleep(1000);

            HP_LP3065_Page hpLp3065Page = new HP_LP3065_Page(driver);
            logger.info("... create 'HP LP3065' Page");

            // Get product params
            logger.info("... save product name from product page <-----");
            productName = hpLp3065Page.getActProductName();
            logger.info("... ACTUAL PRODUCT NAME: " + productName + " <-----");

            logger.info("... save delivery date from product page <-----");
            productDeliveryDate = hpLp3065Page.getActDeliveryDate();
            logger.info("... ACTUAL DELIVERY DATE: " + productDeliveryDate + " <-----");

            logger.info("... save model from product page <-----");
            productModel = hpLp3065Page.getActModel();
            logger.info("... ACTUAL PRODUCT MODEL: " + productModel + " <-----");

            logger.info("... save quantity from product page <-----");
            productQuantity = hpLp3065Page.getActQuantity();
            logger.info("... ACTUAL PRODUCT QUANTITY: " + productQuantity + " <-----");

            logger.info("... save unit price from product page <-----");
            productUnitPrice = hpLp3065Page.getActUnitPrice();
            logger.info("... ACTUAL UNIT PRICE: " + productUnitPrice + " <-----");

            logger.info("... calculating 'Total'");
            productTotal = "$" + calculateTotal(productUnitPrice, productQuantity) +"0";
            logger.info("...  'Total' = " + productTotal + " <-----");
            logger.info("... calculating 'Sub-Total'");
            productSubTotal = productTotal;
            logger.info("...  'Sub-Total' = " + productSubTotal + " <-----");
            logger.info("... 'flatShippingRate' is $5.00" );
            flatShippingRate = "$5.00";
            logger.info("... calculating 'Total End'");
            productTotalEnd = "$" + calculateTotalEnd(productSubTotal, flatShippingRate) +"0";
            logger.info("...  'Total-End' = " + productTotalEnd + " <-----");

            hpLp3065Page.clickAddToCart();
            logger.info("... click 'Add to cart' button on product 'HP LP3065' Page");
            Thread.sleep(1000);
            logger.info("... setting 500ms delay");
            hpLp3065Page.clickShoppingCart();
            Thread.sleep(1000);
            logger.info("... click 'Shopping cart' link in success message");
            ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
            logger.info("... create 'Shopping Cart' Page");
            shoppingCartPage.clickCheckout();
            Thread.sleep(1000);
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
            Thread.sleep(1000);

            Assert.assertTrue(checkoutPage.isRadioButtonStep3ExistingAddressSelected());
            logger.info("...check if 'I want to use my existing address' radio button is selected by default");
            Assert.assertEquals(checkoutPage.getTextExistingAddress(), "I want to use an existing address");

            checkoutPage.clickStep3Continue();
            logger.info("...click 'Continue' button for STEP 3");
            Thread.sleep(1000);

            Assert.assertTrue(checkoutPage.isStep4radioButtonShippingRateSelected());
            logger.info("...check if 'Flat Shipping Rate -$5.00' radio button is selected by default");
            Assert.assertEquals(checkoutPage.getTextShippingRate(), "Flat Shipping Rate -$5.00");

            checkoutPage.clickStep4Continue();
            logger.info("...click 'Continue' button for STEP 4");
            Thread.sleep(1000);

            Assert.assertTrue(checkoutPage.isStep5radioButtonCashSelected());
            logger.info("...check if 'Cash On Delivery' radio button is selected by default");
            Assert.assertEquals(checkoutPage.getTextCashOnDelivery(), "Cash On Delivery");

            checkoutPage.clickTerms();
            logger.info("...click checkbox 'Terms and Conditions'");
            checkoutPage.clickStep5Continue();
            logger.info("...click 'Continue' button for STEP 5");
            Thread.sleep(1000);

            Assert.assertEquals(checkoutPage.getConfProductName(), productName);
            Assert.assertEquals(checkoutPage.getConfDeliveryDate(), "-Delivery Date:" + productDeliveryDate);
            Assert.assertEquals(checkoutPage.getConfModel(), productModel);
            Assert.assertEquals(checkoutPage.getConfQuantity(), productQuantity);
            Assert.assertEquals(checkoutPage.getConfUnitPrice(), "$100.00");
            Assert.assertEquals(productUnitPrice, "$122.00");
            Assert.assertEquals(checkoutPage.getConfTotal(), productTotal);
            Assert.assertEquals(checkoutPage.getConfSubTotal(), productSubTotal);
            Assert.assertEquals(checkoutPage.getConfTotalEnd(), productTotalEnd);

            checkoutPage.clickConfirmOrder();
            logger.info("...click 'Confirm Order' button");
            Thread.sleep(1000);

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
        logger.info("***  END TC_CO_005_CheckoutTests ***");
    }

    public double calculateTotal(String unitPrice, String quantity) {
        double unitPriceDouble = Double.parseDouble(unitPrice.substring(1)) - 22;
        double quantityDouble = Double.parseDouble(quantity);
        return unitPriceDouble * quantityDouble;
    }

    public double calculateTotalEnd(String subTotal, String flatShippingRate) {
        double subTotalDouble = Double.parseDouble(subTotal.substring(1));
        double flatShippingRateDouble = Double.parseDouble(flatShippingRate.substring(1));
        return subTotalDouble + flatShippingRateDouble;
    }
}
