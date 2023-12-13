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

    public boolean isYesBtnClicked() {
        return radioButtonYes.isSelected();
    }
}
