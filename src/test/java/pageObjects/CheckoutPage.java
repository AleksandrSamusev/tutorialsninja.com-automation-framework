package pageObjects;

import lombok.Getter;
import lombok.Setter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class CheckoutPage extends BasePage {

    public CheckoutPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@id='input-payment-firstname']")
    WebElement inputFirstName;

    @FindBy(xpath = "//input[@id='input-payment-lastname']")
    WebElement inputLastName;

    @FindBy(xpath = "//input[@id='input-payment-company']")
    WebElement inputCompany;

    @FindBy(xpath = "//input[@id='input-payment-address-1']")
    WebElement inputAddress1;

    @FindBy(xpath = "//input[@id='input-payment-address-2']")
    WebElement inputAddress2;

    @FindBy(xpath = "//input[@id='input-payment-city']")
    WebElement inputCity;

    @FindBy(xpath = "//input[@id='input-payment-postcode']")
    WebElement inputPostCode;

    @Getter
    @FindBy(xpath = "//select[@id='input-payment-country']")
    WebElement selectCountry;

    @Getter
    @FindBy(xpath = "//select[@id='input-payment-zone']")
    WebElement selectRegion;

    @FindBy(xpath = "//input[@id='button-payment-address']")
    WebElement btnStep2Continue;

    @FindBy(xpath = "//input[@id='button-shipping-address']")
    WebElement btnStep3Continue;

    @FindBy(xpath = "//input[@id='button-shipping-method']")
    WebElement btnStep4Continue;

    @FindBy(xpath = "//input[@name='agree']")
    WebElement chkTerms;

    @FindBy(xpath = "//input[@id='button-payment-method']")
    WebElement btnStep5Continue;

    @FindBy(xpath = "//input[@id='button-confirm']")
    WebElement btnConfirmOrder;

    public void setFirstName(String fName) {
        inputFirstName.sendKeys(fName);
    }

    public void setLastName(String lName) {
        inputLastName.sendKeys(lName);
    }

    public void setCompany(String company) {
        inputCompany.sendKeys(company);
    }

    public void setAddress1(String address1) {
        inputAddress1.sendKeys(address1);
    }

    public void setAddress2(String address2) {
        inputAddress2.sendKeys(address2);
    }

    public void setCity(String city) {
        inputCity.sendKeys(city);
    }

    public void setPostCode(String postCode) {
        inputPostCode.sendKeys(postCode);
    }

    public void clickStep2Continue() {
        btnStep2Continue.click();
    }

    public void clickStep3Continue() {
        btnStep3Continue.click();
    }

    public void clickStep4Continue() {
        btnStep4Continue.click();
    }

    public void clickTerms() {
        chkTerms.click();
    }

    public void clickStep5Continue() {
        btnStep5Continue.click();
    }

    public void clickConfirmOrder() {
        btnConfirmOrder.click();
    }


}
