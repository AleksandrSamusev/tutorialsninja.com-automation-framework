package testCases.HomePageFunctionality_HP;

import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.DesktopsPCPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_HP_004_HomePageTest extends BaseClass {
    @Test(groups = {"Regression", "Master"})
    public void test_When_ClickContinueFromEmptyCategoryPage_Then_RedirectToHomePage() {
        logger.info("");
        logger.info("***  START TC_HP_004_HomePageTest ***");
        try {
            HomePage homePage = new HomePage(driver);
            logger.info("... create Home Page");

            Actions actions = new Actions(driver);
            actions.moveToElement(homePage.getMenuDesktops()).perform();
            homePage.clickPC0();

            DesktopsPCPage desktopsPCPage = new DesktopsPCPage(driver);
            desktopsPCPage.clickContinue();

            Assert.assertEquals(driver.getCurrentUrl(),
                    "https://tutorialsninja.com/demo/index.php?route=common/home");

        } catch (Exception ex) {
            logger.info("!! TEST FAILED !!");
            Assert.fail();
        }
        logger.info("***  END TC_HP_004_HomePageTest ***");
    }
}
