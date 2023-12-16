package pageObjects;

import lombok.Getter;
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

    @FindBy(xpath = "//*[@id=\"top-links\"]/ul/li[3]/a/span")
    WebElement wishList;

    @FindBy(xpath = "//span[normalize-space()='Shopping Cart']")
    WebElement shoppingCart;

    @FindBy(xpath = "//span[normalize-space()='Checkout']")
    WebElement checkout;

    @Getter
    @FindBy(xpath = "//a[normalize-space()='Desktops']")
    WebElement desktops;

    @Getter
    @FindBy(xpath = "//a[normalize-space()='Show AllDesktops']")
    WebElement showAllDesktops;

    @Getter
    @FindBy(xpath = "//a[normalize-space()='Laptops & Notebooks']")
    WebElement laptopsAndNotebooks;

    @Getter
    @FindBy(xpath = "//a[normalize-space()='Show AllLaptops & Notebooks']")
    WebElement showAllLaptopsAndNotebooks;

    @Getter
    @FindBy(xpath = "//a[normalize-space()='Components']")
    WebElement components;

    @Getter
    @FindBy(xpath = "//a[normalize-space()='Show AllComponents']")
    WebElement showAllComponents;

    @FindBy(xpath = "//a[normalize-space()='Tablets']")
    WebElement tablets;

    @FindBy(xpath = "//a[normalize-space()='Software']")
    WebElement software;

    @FindBy(xpath = "//a[normalize-space()='Phones & PDAs']")
    WebElement phonesAndPDAs;

    @FindBy(xpath = "//a[normalize-space()='Cameras']")
    WebElement cameras;

    @Getter
    @FindBy(xpath = "//a[normalize-space()='MP3 Players']")
    WebElement mp3Players;

    @Getter
    @FindBy(xpath = "//a[normalize-space()='Show AllMP3 Players']")
    WebElement showAllMp3Players;

    @FindBy(xpath = "//a[@class='list-group-item'][normalize-space()='Login']")
    WebElement rightSideLogin;

    @FindBy(xpath = "//a[@class='list-group-item'][normalize-space()='Register']")
    WebElement rightSideRegister;

    @FindBy(xpath = "//a[normalize-space()='Forgotten Password']")
    WebElement rightSideForgottenPassword;

    @FindBy(xpath = "//a[@class='list-group-item'][normalize-space()='My Account']")
    WebElement rightSideMyAccount;

    @FindBy(xpath = "//a[normalize-space()='Address Book']")
    WebElement rightSideAddressBook;

    @FindBy(xpath = "//a[@class='list-group-item'][normalize-space()='Wish List']")
    WebElement rightSideWishList;


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

    public void clickWishList() {
        wishList.click();
    }

    public void clickShoppingCart() {
        shoppingCart.click();
    }

    public void clickCheckout() {
        checkout.click();
    }

    public void clickDesktops() {
        desktops.click();
    }

    public void clickShowAllDesktops() {
        showAllDesktops.click();
    }

    public void clickShowAllLaptopsAndNotebooks() {
        showAllLaptopsAndNotebooks.click();
    }

    public void clickShowAllComponents() {
        showAllComponents.click();
    }

    public void clickTablets() {
        tablets.click();
    }

    public void clickSoftware() {
        software.click();
    }

    public void clickPhonesAndPDAs() {
        phonesAndPDAs.click();
    }

    public void clickCameras() {
        cameras.click();
    }

    public void clickShowAllMp3Players() {
        showAllMp3Players.click();
    }

    public void clickRightSideLogin() {
        rightSideLogin.click();
    }

    public void clickRightSideRegister() {
        rightSideRegister.click();
    }

    public void clickRightSideForgottenPassword() {
        rightSideForgottenPassword.click();
    }

    public void clickRightSideMyAccount() {
        rightSideMyAccount.click();
    }

    public void clickRightSideAddressBook() {
        rightSideAddressBook.click();
    }

    public void clickRightSideWishList() {
        rightSideWishList.click();
    }




}
