package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DesktopsPage extends BasePage {

    @FindBy(xpath = "//h2[normalize-space()='Desktops']")
    WebElement desktopTitle;

    public DesktopsPage(WebDriver driver) {
        super(driver);
    }

    public String getPageTitle() {
        try {
            return desktopTitle.getText();
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }
}
