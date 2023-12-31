package pageObjects;

import lombok.Getter;
import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HomePage extends BasePage {
    public HomePage(WebDriver driver) {
        super(driver);
    }

    //elements
    @FindBy(xpath = "//span[normalize-space()='My Account']")
    WebElement lnkMyAccount;

    @FindBy(xpath = "//ul//ul//a[normalize-space()='My Account']")
    WebElement optionMyAccount;

    @FindBy(xpath = "//a[normalize-space()='Register']")
    WebElement lnkRegister;


    @FindBy(xpath = "//a[normalize-space()='Login']")
    WebElement lnkLogin;

    @FindBy(xpath = "//a[normalize-space()='Logout']")
    WebElement lnkLogout;

    @Getter
    @FindBy(xpath = "//input[@placeholder='Search']")
    WebElement txtSearchInput;

    @FindBy(xpath = "//div[@id='search']//button[@type='button']")
    WebElement btnSearch;

    @Getter
    @FindBy(xpath = "//a[normalize-space()='Desktops']")
    WebElement menuDesktops;

    @Getter
    @FindBy(xpath = "//a[normalize-space()='Show AllDesktops']")
    WebElement menuShowAllDesktops;

    @FindBy(xpath = "//a[normalize-space()='PC (0)']")
    WebElement lnkEmptyCategoryPC0;

    @FindBy(xpath = "//span[normalize-space()='Checkout']")
    WebElement btnHeaderCheckout;

    //action methods
    public void clickMyAccount() {
        lnkMyAccount.click();
    }

    public void clickRegister() {
        lnkRegister.click();
    }

    public void clickLogin() {
        lnkLogin.click();
    }

    public void clickOptionMyAccount() {
        optionMyAccount.click();
    }

    public void clickLogout() {
        lnkLogout.click();
    }

    public boolean isLoginPresent() {
        try {
            driver.findElement(By.xpath("//a[normalize-space()='Login']"));
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public boolean isLogoutPresent() {
        try {
            driver.findElement(By.xpath("//a[normalize-space()='Logout']"));
            return true;
        } catch (NoSuchElementException ex) {
            return false;
        }
    }

    public void clickSearch() {
        btnSearch.click();
    }

    public void clickMenuDesktops() {
        menuDesktops.click();
    }

    public void clickMenuShowAllDesktops() {
        menuShowAllDesktops.click();
    }

    public void clickPC0() {
        lnkEmptyCategoryPC0.click();
    }

    public void clickCheckout() {
        btnHeaderCheckout.click();
    }

}
