package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {
    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h2[normalize-space()='My Account']")
    WebElement msgConfirmation;

    @FindBy(xpath = "//ul[@class='dropdown-menu dropdown-menu-right']//a[normalize-space()='Logout']")
    WebElement btnLogout;

    @FindBy(linkText = "Continue")
    WebElement btnContinue;

    public boolean isMyAccountPageExists() {
        try {
            return msgConfirmation.isDisplayed();
        } catch (Exception ex) {
            return false;
        }
    }

    public void clickLogout() {
        btnLogout.click();
    }
    public void clickContinue() {
        btnContinue.click();
    }
}
