package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HP_LP3065_Page extends BasePage {

    public HP_LP3065_Page(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//button[@id='button-cart']")
    WebElement btnAddToCart;

    @FindBy(xpath = "//a[normalize-space()='shopping cart']")
    WebElement lnkShoppingCart;

    public void clickAddToCart() {
        btnAddToCart.click();
    }

    public void clickShoppingCart() {
        lnkShoppingCart.click();
    }
}
