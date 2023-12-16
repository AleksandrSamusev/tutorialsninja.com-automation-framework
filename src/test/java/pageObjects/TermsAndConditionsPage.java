package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TermsAndConditionsPage extends BasePage {

    public TermsAndConditionsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h1[normalize-space()='Terms & Conditions']")
    WebElement termsAndConditionsPageTitle;

    public String getTermsAndConditionsPageTitle() {
        try {
            return termsAndConditionsPageTitle.getText();
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }
}
