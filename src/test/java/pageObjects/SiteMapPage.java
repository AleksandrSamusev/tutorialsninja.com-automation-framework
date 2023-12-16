package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SiteMapPage extends BasePage {

    public SiteMapPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h1[normalize-space()='Site Map']")
    WebElement siteMapPageTitle;

    public String getSiteMapPageTitle() {
        try {
            return siteMapPageTitle.getText();
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }
}
