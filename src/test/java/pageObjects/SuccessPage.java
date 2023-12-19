package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SuccessPage extends BasePage {

    public SuccessPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[normalize-space()='Continue']")
    WebElement btnContinue;

    public void clickContinue() {
        btnContinue.click();
    }
}
