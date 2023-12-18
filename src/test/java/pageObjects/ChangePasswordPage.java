package pageObjects;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ChangePasswordPage extends BasePage {

    public ChangePasswordPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h1[normalize-space()='Change Password']")
    WebElement pageTitle;

    @Getter
    @FindBy(xpath = "//input[@id='input-password']")
    WebElement txtPassword;

    @Getter
    @FindBy(xpath = "//input[@id='input-confirm']")
    WebElement txtConfirmPassword;

    @FindBy(xpath = "//input[@value='Continue']")
    WebElement btnContinue;

    public String getPageTitle() {
        try {
            return pageTitle.getText();
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }

    public void clickContinue() {
        btnContinue.click();
    }
}
