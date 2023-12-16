package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class TabletsPage extends BasePage {
    public TabletsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h2[normalize-space()='Tablets']")
    WebElement tabletsPageTitle;

    public String getTabletsPageTitle() {
        try {
            return tabletsPageTitle.getText();
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }
}
