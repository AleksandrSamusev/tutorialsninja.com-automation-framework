package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class NewsletterPage extends BasePage{
    public NewsletterPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//label[normalize-space()='Yes']/input")
    WebElement radioButtonYes;

    @FindBy(xpath = "//label[normalize-space()='No']/input")
    WebElement radioBtnNo;

    public boolean isYesBtnClicked() {
        return radioButtonYes.isSelected();
    }

    public boolean isNoBtnClicked() {
        return radioBtnNo.isSelected();
    }
}
