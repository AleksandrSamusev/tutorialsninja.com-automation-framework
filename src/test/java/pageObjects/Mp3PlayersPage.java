package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class Mp3PlayersPage extends BasePage {
    public Mp3PlayersPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//h2[normalize-space()='MP3 Players']")
    WebElement mp3PlayersPageTitle;

    public String getPageTitle() {
        try {
            return mp3PlayersPageTitle.getText();
        } catch (Exception ex) {
            return ex.getMessage();
        }
    }
}

