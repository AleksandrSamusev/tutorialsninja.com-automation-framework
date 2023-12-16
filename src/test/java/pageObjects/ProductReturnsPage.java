package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ProductReturnsPage extends BasePage {

    public ProductReturnsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h1[normalize-space()='Product Returns']")
    WebElement productReturnsPageTitle;

    public String getProductReturnsPageTitle() {
        try {
            return productReturnsPageTitle.getText();
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }
}
