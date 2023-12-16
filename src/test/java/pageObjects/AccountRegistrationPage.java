package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class AccountRegistrationPage extends BasePage {

    public AccountRegistrationPage(WebDriver driver) {
        super(driver);
    }

    //elements
    @FindBy(name = "firstname")
    WebElement txtFirstName;

    @FindBy(name = "lastname")
    WebElement txtLastName;

    @FindBy(name = "email")
    WebElement txtEmail;

    @FindBy(name = "telephone")
    WebElement txtTelephone;

    @FindBy(name = "password")
    WebElement txtPassword;

    @FindBy(name = "confirm")
    WebElement txtConfirmPassword;

    @FindBy(name = "agree")
    WebElement chkPolicy;

    @FindBy(xpath = "//input[@value='Continue']")
    WebElement btnContinue;

    @FindBy(xpath = "//h1[normalize-space()='Your Account Has Been Created!']")
    WebElement msgConfirmation;

    @FindBy(xpath = "//div[@class='row']//div[2]//div[1]//div[1]")
    WebElement firstNameValidationMessage;

    @FindBy(xpath = "//div[3]//div[1]//div[1]")
    WebElement lastNameValidationMessage;

    @FindBy(xpath = "//div[4]//div[1]//div[1]")
    WebElement emailValidationMessage;

    @FindBy(xpath = "//div[5]//div[1]//div[1]")
    WebElement phoneValidationMessage;

    @FindBy(xpath = "//fieldset[2]//div[1]//div[1]//div[1]")
    WebElement passwordValidationMessage;

    @FindBy(xpath = "//div[@class='alert alert-danger alert-dismissible']")
    WebElement policyValidationMessage;

    @FindBy(xpath = "//label[normalize-space()='Yes']/input")
    WebElement radioBtnYes;

    @FindBy(xpath = "//h1[normalize-space()='Register Account']")
    WebElement pageTitle;

    @FindBy(xpath = "//*[@id=\"content\"]/form/fieldset[2]/div[2]/div/div")
    WebElement passwordConfirmationValidationMessage;

    @FindBy(xpath = "//*[@id=\"account-register\"]/div[1]")
    WebElement msgTop;

    @FindBy(xpath = "//span[normalize-space()='My Account']")
    WebElement lnkMyAccount;

    @FindBy(xpath = "//a[normalize-space()='Register']")
    WebElement lnkRegister;

    @FindBy(xpath = "//a[normalize-space()='Login']")
    WebElement lnkLogin;

    //action methods
    public void setFirstName(String fName) {
        txtFirstName.sendKeys(fName);
    }

    public void setLastName(String lName) {
        txtLastName.sendKeys(lName);
    }

    public void setEmail(String email) {
        txtEmail.sendKeys(email);
    }

    public void setTelephone(String tel) {
        txtTelephone.sendKeys(tel);
    }

    public void setPassword(String pass) {
        txtPassword.sendKeys(pass);
    }

    public void setConfirmPassword(String conf) {
        txtConfirmPassword.sendKeys(conf);
    }

    public void clickPrivacyPolicy() {
        chkPolicy.click();
    }

    public void clickContinue() {
        btnContinue.click();
    }

    public void clickOnYesRadioBtn() {
        radioBtnYes.click();
    }

    public String getStandardEmailValidationMessage() {
        try {
            return txtEmail.getAttribute("validationMessage");
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public String getConfirmationMessage() {
        try {
            return msgConfirmation.getText();
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }

    public String getFirstNameValidationMessage() {
        try {
            return firstNameValidationMessage.getText();
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public String getLastNameValidationMessage() {
        try {
            return lastNameValidationMessage.getText();
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public String getEmailValidationMessage() {
        try {
            return emailValidationMessage.getText();
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public String getPhoneValidationMessage() {
        try {
            return phoneValidationMessage.getText();
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public String getPasswordValidationMessage() {
        try {
            return passwordValidationMessage.getText();
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public String getPolicyValidationMessage() {
        try {
            return policyValidationMessage.getText();
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public String getPageTitle() {
        try {
            return pageTitle.getText();
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public String getPasswordConfirmationValidationMessage() {
        try {
            return passwordConfirmationValidationMessage.getText();
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public String getMsgTop() {
        try {
            return msgTop.getText();
        } catch (Exception e) {
            return e.getMessage();
        }
    }

    public void clickMyAccount() {
        lnkMyAccount.click();
    }

    public void clickRegister() {
        lnkRegister.click();
    }

    public void clickLogin() {
        lnkLogin.click();
    }


}
