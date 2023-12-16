package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AffiliateProgramPage extends BasePage {

    public AffiliateProgramPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h1[normalize-space()='Affiliate Program']")
    WebElement affiliateProgramPageTitle;

    public String getAffiliateProgramPageTitle() {
        try {
            return affiliateProgramPageTitle.getText();
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }
}
