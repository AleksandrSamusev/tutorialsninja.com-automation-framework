package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PrivacyPolicyPage extends BasePage {

    public PrivacyPolicyPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h1[normalize-space()='Privacy Policy']")
    WebElement privacyPolicyPageTitle;

    public String getPrivacyPolicyPageTitle() {
        try {
            return privacyPolicyPageTitle.getText();
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }
}
