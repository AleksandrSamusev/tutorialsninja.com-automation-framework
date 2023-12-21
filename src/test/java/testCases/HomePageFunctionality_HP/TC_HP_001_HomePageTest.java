package testCases.HomePageFunctionality_HP;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.*;
import testBase.BaseClass;

public class TC_HP_001_HomePageTest extends BaseClass {
    @Test(groups = {"Regression", "Master"})
    public void test_When_ClickContinueShoppingOnCartPage_Then_RedirectToHomePage() {
        logger.info("");
        logger.info("***  START TC_HP_001_HomePageTest ***");
        try {
            HomePage homePage = new HomePage(driver);
            logger.info("... create Home Page");
            homePage.getTxtSearchInput().sendKeys("imac");
            homePage.clickSearch();

            SearchPage searchPage = new SearchPage(driver);
            searchPage.clickAddToCart();
            Thread.sleep(1000);
            searchPage.clickLnkShoppingCart();

            ShoppingCartPage shoppingCartPage = new ShoppingCartPage(driver);
            shoppingCartPage.clickBtnContinueShopping();

            Assert.assertEquals(driver.getCurrentUrl(),
                    "https://tutorialsninja.com/demo/index.php?route=common/home");

        } catch (Exception ex) {
            logger.info("!! TEST FAILED !!");
            Assert.fail();
        }
        logger.info("***  END TC_HP_001_HomePageTest ***");
    }
}
