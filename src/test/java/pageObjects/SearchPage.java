package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class SearchPage extends BasePage {

    public SearchPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//div[@class='product-layout product-grid col-lg-3 col-md-3 col-sm-6 col-xs-12']//button[1]")
    WebElement btnAddToCard;

    @FindBy(xpath = "//a[normalize-space()='shopping cart']")
    WebElement lnkShoppingCart;

    public void clickAddToCart() {
        btnAddToCard.click();
    }

    public void clickLnkShoppingCart() {
        lnkShoppingCart.click();
    }
}
