package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LaptopsAndNotebooksPage extends BasePage {
    public LaptopsAndNotebooksPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h2[normalize-space()='Laptops & Notebooks']")
    WebElement laptopsAndNotebooksPageTitle;

    public String getPageTitle() {
        try {
            return laptopsAndNotebooksPageTitle.getText();
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }
}
