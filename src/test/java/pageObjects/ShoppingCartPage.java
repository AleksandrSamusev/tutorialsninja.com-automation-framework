package pageObjects;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class ShoppingCartPage extends BasePage {

    public ShoppingCartPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[normalize-space()='Continue Shopping']")
    WebElement btnContinueShopping;

    @FindBy(xpath = "//a[contains(text(),'Checkout')]")
    WebElement btnCheckout;

    @FindBy(xpath = "//div[@id='content']//p[contains(text(),'Your shopping cart is empty!')]")
    WebElement divEmptyText;

    public void clickContinueShopping() {
        btnContinueShopping.click();
    }

    public void clickCheckout() {
        btnCheckout.click();
    }

    public String getTitle() {
       return driver.getTitle();
    }

    public String getEmptyText() {
        try {
            return  divEmptyText.getText();
        } catch (NoSuchElementException ex) {
            return ex.getMessage();
        }
    }
}
