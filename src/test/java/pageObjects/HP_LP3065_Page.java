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

    @FindBy(xpath = "//button[@class='btn btn-inverse btn-block btn-lg dropdown-toggle']")
    WebElement btnHeaderShoppingCart;

    @FindBy(xpath = "//strong[normalize-space()='Checkout']")
    WebElement blockCheckout;

    @FindBy(xpath = "//a[@title='Checkout']//i")
    WebElement headerCheckout;

    //actual locators

    @FindBy(xpath = "//*[@id=\"content\"]/div/div[2]/ul[2]/li[1]/h2")
    WebElement actUnitPrice;

    @FindBy(xpath = "//*[@id=\"input-quantity\"]")
    WebElement actQuantity;

    @FindBy(xpath = "//*[@id=\"input-option225\"]")
    WebElement actDeliveryDate;

    @FindBy(xpath = "//h1[normalize-space()='HP LP3065']")
    WebElement actProductName;

    @FindBy(xpath = "//li[normalize-space()='Product Code:Product 21']")
    WebElement actModel;



    public void clickAddToCart() {
        btnAddToCart.click();
    }

    public void clickShoppingCart() {
        lnkShoppingCart.click();
    }

    public void clickBtnHeaderShoppingCart() {
        btnHeaderShoppingCart.click();
    }

    public void clickBlockCheckout() {
        blockCheckout.click();
    }

    public void clickHeaderCheckout() {
        headerCheckout.click();
    }

    public String getActModel() {
        try {
            String[] result = actModel.getText().split(":");
            return result[1];
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }

    public String getActUnitPrice() {
        try {
            return actUnitPrice.getText();
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }

    public String getActQuantity() {
        try {
            return actQuantity.getAttribute("value");
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }

    public String getActDeliveryDate() {
        try {
            return actDeliveryDate.getAttribute("value");
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }

    public String getActProductName() {
        try {
            return actProductName.getText();
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }
}
