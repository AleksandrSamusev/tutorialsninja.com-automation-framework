package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CamerasPage extends BasePage {
    public CamerasPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h2[normalize-space()='Cameras']")
    WebElement camerasPageTitle;

    public String getCamerasPageTitle() {
        try {
            return camerasPageTitle.getText();
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }
}
