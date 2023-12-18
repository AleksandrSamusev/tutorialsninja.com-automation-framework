package pageObjects;

import lombok.Getter;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends BasePage{
    public LoginPage(WebDriver driver) {
        super(driver);
    }

    //elements
    @Getter
    @FindBy(name = "email")
    WebElement txtEmail;

    @Getter
    @FindBy(name = "password")
    WebElement txtPassword;

    @FindBy(xpath = "//input[@value='Login']")
    WebElement btnLogin;

    @FindBy(xpath = "//a[normalize-space()='Continue']")
    WebElement newCustomerContinueBtn;

    @FindBy(xpath = "//h2[normalize-space()='New Customer']")
    WebElement newCustomerTitle;

    @FindBy(xpath = "//div[contains(text(),'Warning: No match for E-Mail Address and/or Passwo')]")
    WebElement msgInvalidCredentials;

    @Getter
    @FindBy(xpath = "//div[contains(text(),'Warning: Your account has exceeded allowed number ')]")
    WebElement msgAttemptsExceeded;

    @Getter
    @FindBy(linkText = "Forgotten Password")
    WebElement linkForgottenPassword;

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

    public String getPageTitle() {
        return driver.getTitle();
    }

    public String getNewCustomerTitle() {
        try {
            return newCustomerTitle.getText();
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }

    public String getMsgInvalidCredentials() {
        try {
            return msgInvalidCredentials.getText();
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }

    public void clickLinkForgottenPassword() {
        linkForgottenPassword.click();
    }

    public String getMessageAttemptsExceeded() {
        try {
            return msgAttemptsExceeded.getText();
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }


}
