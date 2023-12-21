package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class MyAccountPage extends BasePage {
    public MyAccountPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h2[normalize-space()='My Account']")
    WebElement msgConfirmation;

    @FindBy(xpath = "//a[@class='list-group-item'][normalize-space()='Logout']")
    WebElement btnLogout;

    @FindBy(xpath = "//a[@class='list-group-item'][normalize-space()='Newsletter']")
    WebElement btnNewsletter;

    @FindBy(xpath = "//*[@id=\"content\"]/form/fieldset/div/div/label[1]/input")
    WebElement radioBtnYes;

    @FindBy(xpath = "//a[normalize-space()='Continue']")
    WebElement btnContinue;

    @FindBy(xpath = "//h2[normalize-space()='My Account']")
    WebElement myAccountPageTitle;

    @FindBy(xpath = "//a[@class='list-group-item'][normalize-space()='My Account']")
    WebElement rightSideMyAccount;

    @FindBy(xpath = "//a[normalize-space()='Change your password']")
    WebElement changeYourPassword;

    @FindBy(xpath = "//aside[@id='column-right']//a[normalize-space()='Logout']")
    WebElement rightSideLogout;

    @FindBy(xpath = "//div[@id='top-links']//a[normalize-space()='Logout']")
    WebElement headerLogout;

    @FindBy(xpath = "//span[normalize-space()='My Account']")
    WebElement headerMyAccount;

    @FindBy(xpath = "//a[normalize-space()='Qafox.com']")
    WebElement logo;

    public boolean isMyAccountPageExists() {
        try {
            return msgConfirmation.isDisplayed();
        } catch (Exception ex) {
            return false;
        }
    }

    public void clickLogout() {
        btnLogout.click();
    }

    public void clickContinue() {
        btnContinue.click();
    }

    public void clickNewsletter() {
        btnNewsletter.click();
    }

    public String getMyAccountPageTitle() {
        try {
            return myAccountPageTitle.getText();
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }

    public void clickRightSideMyAccount() {
        rightSideMyAccount.click();
    }

    public void clickChangeYourPassword() {
        changeYourPassword.click();
    }

    public void clickRightSideLogout() {
        rightSideLogout.click();
    }

    public void clickHeaderLogout() {
        headerLogout.click();
    }

    public void clickHeaderMyAccount() {
        headerMyAccount.click();
    }

    public boolean isRightSideLogoutPresent() {
        try {
            driver.findElement(By.xpath(
                    "//aside[@id='column-right']//a[normalize-space()='Logout']"));
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public void clickLogo() {
        logo.click();
    }

}
