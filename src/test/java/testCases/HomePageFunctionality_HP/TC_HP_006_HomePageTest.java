package testCases.HomePageFunctionality_HP;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import testBase.BaseClass;

import java.util.List;

public class TC_HP_006_HomePageTest extends BaseClass {
    @Test(groups = {"Regression", "Master"})
    public void test_CheckFourFeaturedProductsShownOnHomePage() {

        String MACBOOK_URL = "https://tutorialsninja.com/demo/index.php?route=product/product&product_id=43";
        String IPHONE_URL = "https://tutorialsninja.com/demo/index.php?route=product/product&product_id=40";
        String APPLE_CINEMA_URL = "https://tutorialsninja.com/demo/index.php?route=product/product&product_id=42";
        String CANON_URL = "https://tutorialsninja.com/demo/index.php?route=product/product&product_id=30";

        logger.info("");
        logger.info("***  START TC_HP_006_HomePageTest ***");
        try {
            HomePage homePage = new HomePage(driver);
            logger.info("... create Home Page");

            List<WebElement> elements =
                    driver.findElements(By.xpath("//*[@id=\"content\"]/div[2]/div"));
            Assert.assertEquals(elements.size(),4);

            elements.get(0).click();
            Assert.assertEquals(driver.getCurrentUrl(), MACBOOK_URL);

            driver.navigate().back();

            elements.get(1).click();
            Assert.assertEquals(driver.getCurrentUrl(), IPHONE_URL);

            driver.navigate().back();

            elements.get(2).click();
            Assert.assertEquals(driver.getCurrentUrl(), APPLE_CINEMA_URL);

            driver.navigate().back();

            elements.get(3).click();
            Assert.assertEquals(driver.getCurrentUrl(), CANON_URL);

            driver.navigate().back();

        } catch (Exception ex) {
            logger.info("!! TEST FAILED !!");
            Assert.fail();
        }
        logger.info("***  END TC_HP_006_HomePageTest ***"); 
    }
}
