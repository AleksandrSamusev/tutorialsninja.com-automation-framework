package testCases.HomePageFunctionality_HP;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_HP_008_HomePageTest extends BaseClass {
    @Test(groups = {"Regression", "Master"})
    public void test_When_ClickHomeIconInBreadcrumbs_Then_RedirectToHomePage() {
        logger.info("");
        logger.info("***  START TC_HP_008_HomePageTest ***");
        try {
            HomePage homePage = new HomePage(driver);
            logger.info("... create Home Page");

            homePage.clickMenuDesktops();
            logger.info("...click on 'Desktops' in page menu");
            homePage.clickMenuShowAllDesktops();
            logger.info("... click 'Show All Desktops' option");

            WebElement el = driver.findElement(By.xpath("//*[@id=\"product-category\"]/ul/li[1]/a"));
            JavascriptExecutor exec = (JavascriptExecutor) driver;
            exec.executeScript("arguments[0].click()", el);
            logger.info("...click 'Home' icon in breadcrumbs");

            Assert.assertEquals(driver.getCurrentUrl(),
                    "https://tutorialsninja.com/demo/index.php?route=common/home");

        } catch (Exception ex) {
            logger.info("!! TEST FAILED !!");
            Assert.fail();
        }
        logger.info("***  END TC_HP_008_HomePageTest ***");
    }
}
