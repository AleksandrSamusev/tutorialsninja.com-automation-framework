package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutSuccessPage extends BasePage {

    public CheckoutSuccessPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[normalize-space()='Continue']")
    WebElement btnContinue;

    public void clickContinue() {
        btnContinue.click();
    }
}
