package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ForgottenPasswordPage extends BasePage {

    public ForgottenPasswordPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h1[normalize-space()='Forgot Your Password?']")
    WebElement forgottenPasswordTitle;

    public String getForgottenPasswordTitle() {
        try {
            return forgottenPasswordTitle.getText();
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }
}
