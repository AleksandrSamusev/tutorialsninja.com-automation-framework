package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class PhonesAndPDAsPage extends BasePage {

    public PhonesAndPDAsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h2[normalize-space()='Phones & PDAs']")
    WebElement phonesAndPDAsPageTitle;

    public String getPhonesAndPDAsPageTitle() {
        try {
            return phonesAndPDAsPageTitle.getText();
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }
}
