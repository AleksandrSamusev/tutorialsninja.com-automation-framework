package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SoftwarePage extends BasePage {
    public SoftwarePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h2[normalize-space()='Software']")
    WebElement softwarePageTitle;

    public String getSoftwarePageTitle() {
        try {
            return softwarePageTitle.getText();
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }
}
