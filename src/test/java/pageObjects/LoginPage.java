package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    //elements
    @FindBy(name = "email")
    WebElement txtEmail;

    @FindBy(name = "password")
    WebElement txtPassword;

    @FindBy(xpath = "//input[@value='Login']")
    WebElement btnLogin;

    @FindBy(xpath = "//a[normalize-space()='Continue']")
    WebElement newCustomerContinueBtn;

    public void setEmail(String email) {
        txtEmail.sendKeys(email);
    }

    public void setPassword(String pass) {
        txtPassword.sendKeys(pass);
    }

    public void clickLogin() {
        btnLogin.click();
    }
    
    public void clickNewCustomerContinueBtn() {
        newCustomerContinueBtn.click();
    }


}
