package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class BrandsPage extends BasePage {

    public BrandsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h1[normalize-space()='Find Your Favorite Brand']")
    WebElement brandsPageTitle;

    public String getBrandsPageTitle() {
        try {
            return brandsPageTitle.getText();
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }
}
