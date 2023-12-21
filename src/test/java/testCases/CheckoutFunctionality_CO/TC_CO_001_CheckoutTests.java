package testCases.CheckoutFunctionality_CO;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.ShoppingCartPage;
import testBase.BaseClass;

public class TC_CO_001_CheckoutTests extends BaseClass {
    @Test(groups = {"Regression", "Master"})
    public void test_When_ClickCheckoutAndNoProducts_Then_ShoppingCartIsEmpty() {
        logger.info("");
        logger.info("***  START TC_CO_001_CheckoutTests ***");
        try {
            HomePage homePage = new HomePage(driver);
            logger.info("... create Home Page");
            homePage.clickCheckout();
            ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);

            String msg = shoppingCartPage.getEmptyText();

            Assert.assertEquals(shoppingCartPage.getTitle(),"Shopping Cart");
            Assert.assertEquals(msg, "Your shopping cart is empty!");

        } catch (Exception ex) {
            logger.info("!! TEST FAILED !!");
            Assert.fail();
        }
        logger.info("***  END TC_CO_001_CheckoutTests ***");
    }
}
