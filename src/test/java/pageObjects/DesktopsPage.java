package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DesktopsPage extends BasePage {

    @FindBy(xpath = "//h2[normalize-space()='Desktops']")
    WebElement desktopTitle;

    @FindBy(xpath = "//div[3]//div[1]//div[2]//div[2]//button[1]")
    WebElement btnAddToCart;

    @FindBy(xpath = "//a[normalize-space()='Qafox.com']")
    WebElement logo;

    public DesktopsPage(WebDriver driver) {
        super(driver);
    }

    public String getPageTitle() {
        try {
            return desktopTitle.getText();
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }

    public void clickAddToCart() {
        btnAddToCart.click();
    }

    public void clickLogo() {
        logo.click();
    }
}
