package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ContactUsPage extends BasePage {

    public ContactUsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h1[normalize-space()='Contact Us']")
    WebElement contactUsPageTitle;

    public String getContactUsPageTitle() {
        try {
            return contactUsPageTitle.getText();
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }
}
