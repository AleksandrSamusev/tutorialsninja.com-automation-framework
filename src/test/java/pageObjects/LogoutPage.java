package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogoutPage extends BasePage {

    public LogoutPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[normalize-space()='Continue']")
    WebElement bntContinue;

    @FindBy(xpath = "//span[normalize-space()='My Account']")
    WebElement headerMyAccount;

    @FindBy(xpath = "//div[@id='top-links']//a[normalize-space()='Login']")
    WebElement headerLogin;

    public void clickContinue() {
        bntContinue.click();
    }

    public void clickHeaderMyAccount() {
        headerMyAccount.click();
    }

    public void clickHeaderLogin() {
        headerLogin.click();
    }
}
