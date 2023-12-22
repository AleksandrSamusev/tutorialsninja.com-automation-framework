package pageObjects;

import lombok.Getter;
import org.openqa.selenium.NoSuchElementException;
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

    @FindBy(xpath = "//label[normalize-space()='I want to use an existing address']//input[@name='shipping_address']")
    WebElement step3radioButtonExistingAddress;

    @FindBy(xpath = "//*[@id=\"collapse-shipping-address\"]/div/form/div[1]/label")
    WebElement textExistingAddress;

    @FindBy(xpath = "//input[@name='shipping_method']")
    WebElement step4radioButtonShippingRate;

    @FindBy(xpath = "//*[@id=\"collapse-shipping-method\"]/div/div[1]/label")
    WebElement textShippingRate;

    @FindBy(xpath = "//input[@name='payment_method']")
    WebElement step5radioButtonCash;

    @FindBy(xpath = "//*[@id=\"collapse-payment-method\"]/div/div[1]/label")
    WebElement textCashOnDelivery;

    // conf locators

    @FindBy(xpath = "//*[@id=\"collapse-checkout-confirm\"]/div/div[1]/table/tbody/tr/td[1]/a")
    WebElement confProductName;

    @FindBy(xpath = "//*[@id=\"collapse-checkout-confirm\"]/div/div[1]/table/tbody/tr/td[1]/small")
    WebElement confDeliveryDate;

    @FindBy(xpath = "//*[@id=\"collapse-checkout-confirm\"]/div/div[1]/table/tbody/tr/td[2]")
    WebElement confModel;

    @FindBy(xpath = "//*[@id=\"collapse-checkout-confirm\"]/div/div[1]/table/tbody/tr/td[3]")
    WebElement confQuantity;

    @FindBy(xpath = "//*[@id=\"collapse-checkout-confirm\"]/div/div[1]/table/tbody/tr/td[4]")
    WebElement confUnitPrice;

    @FindBy(xpath = "//*[@id=\"collapse-checkout-confirm\"]/div/div[1]/table/tbody/tr/td[5]")
    WebElement confTotal;

    @FindBy(xpath = "//*[@id=\"collapse-checkout-confirm\"]/div/div[1]/table/tfoot/tr[1]/td[2]")
    WebElement confSubTotal;

    @FindBy(xpath = "//*[@id=\"collapse-checkout-confirm\"]/div/div[1]/table/tfoot/tr[2]/td[2]")
    WebElement confFlatShippingRate;

    @FindBy(xpath = "//*[@id=\"collapse-checkout-confirm\"]/div/div[1]/table/tfoot/tr[3]/td[2]")
    WebElement confTotalEnd;

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

    public boolean isRadioButtonStep3ExistingAddressSelected() {
        return step3radioButtonExistingAddress.isSelected();
    }

    public String getTextExistingAddress() {
        try {
            return textExistingAddress.getText();
        } catch (NoSuchElementException ex) {
            return ex.getMessage();
        }
    }

    public boolean isStep4radioButtonShippingRateSelected() {
        return step4radioButtonShippingRate.isSelected();
    }

    public String getTextShippingRate() {
        try {
            return textShippingRate.getText();
        } catch (NoSuchElementException ex) {
            return ex.getMessage();
        }
    }

    public boolean isStep5radioButtonCashSelected() {
        return step5radioButtonCash.isSelected();
    }

    public String getTextCashOnDelivery() {
        try {
            return textCashOnDelivery.getText();
        } catch (NoSuchElementException ex) {
            return ex.getMessage();
        }
    }


    // conf locators

    public String getConfProductName() {
        try {
            return confProductName.getText();
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }

    public String getConfDeliveryDate() {
        try {
            return confDeliveryDate.getText();
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }

    public String getConfModel() {
        try {
            return confModel.getText();
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public String getConfQuantity() {
        try {
            return confQuantity.getText();
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }

    public String getConfUnitPrice() {
        try {
            return confUnitPrice.getText();
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }

    public String getConfTotal() {
        try {
            return confTotal.getText();
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }

    public String getConfSubTotal() {
        try {
            return confSubTotal.getText();
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }

    public String getConfFlatShippingRate() {
        try {
            return confFlatShippingRate.getText();
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }

    public String getConfTotalEnd() {
        try {
            return confTotalEnd.getText();
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }
}
