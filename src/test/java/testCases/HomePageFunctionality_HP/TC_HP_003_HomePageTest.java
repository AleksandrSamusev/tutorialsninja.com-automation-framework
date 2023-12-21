package testCases.HomePageFunctionality_HP;

import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.DesktopsPage;
import pageObjects.HomePage;
import testBase.BaseClass;

public class TC_HP_003_HomePageTest extends BaseClass {
    @Test(groups = {"Regression", "Master"})
    public void test_When_ClickLogoFromAnyPage_Then_RedirectToHomePage() {
        logger.info("");
        logger.info("***  START TC_HP_003_HomePageTest ***");
        try {
            HomePage homePage = new HomePage(driver);
            logger.info("... create Home Page");
            homePage.clickMenuDesktops();
            logger.info("...click 'Desktops' in menu");

            homePage.clickMenuShowAllDesktops();
            logger.info("...click 'Show All Desktops' option in dropdown");

            DesktopsPage desktopsPage = new DesktopsPage(driver);
            logger.info("... create 'Desktops' Page");
            desktopsPage.clickLogo();
            logger.info("...click on 'Qafox.com' on the top of the page");
            logger.info("...validating redirection to Home Page");

            Assert.assertEquals(driver.getCurrentUrl(),
                    "https://tutorialsninja.com/demo/index.php?route=common/home");

        } catch (Exception ex) {
            logger.info("!! TEST FAILED !!");
            Assert.fail();
        }
        logger.info("***  END TC_HP_003_HomePageTest ***");
    }
}
