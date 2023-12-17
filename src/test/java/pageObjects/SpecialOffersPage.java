package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SpecialOffersPage extends BasePage {

    public SpecialOffersPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h2[normalize-space()='Special Offers']")
    WebElement specialOffersPageTitle;

    public String getSpecialOffersPageTitle() {
        try {
            return specialOffersPageTitle.getText();
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }
}
