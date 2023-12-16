package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ComponentsPage extends BasePage {
    public ComponentsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h2[normalize-space()='Components']")
    WebElement componentsPageTitle;

    public String getComponentsPageTitle() {
        try {
            return componentsPageTitle.getText();
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }
}
