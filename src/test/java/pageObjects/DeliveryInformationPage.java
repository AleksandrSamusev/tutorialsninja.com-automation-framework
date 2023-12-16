package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DeliveryInformationPage extends BasePage {

    public DeliveryInformationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h1[normalize-space()='Delivery Information']")
    WebElement deliveryInformationTitle;

    public String getDeliveryInformationTitle() {
        try {
            return deliveryInformationTitle.getText();
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }
}
