package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class GiftCertificatesPage extends BasePage {

    public GiftCertificatesPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h1[normalize-space()='Purchase a Gift Certificate']")
    WebElement giftCertificatesPageTitle;

    public String getGiftCertificatesPageTitle() {
        try {
            return giftCertificatesPageTitle.getText();
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }
}
