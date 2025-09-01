package pageobjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Webdriverwaitutils;


public class Appselectionpage {
    WebDriver driver;
    Webdriverwaitutils wait;
    JavascriptExecutor js;

    public Appselectionpage(WebDriver driver) {
        this.driver = driver;
        this.wait = new Webdriverwaitutils(driver);
        PageFactory.initElements(driver, this);
        this.js=(JavascriptExecutor) driver;
    }

    // Locators
    @FindBy(xpath = "//div[@id='apollo']//div[@class='mngdescription']")
    private WebElement appselection;

    @FindBy(xpath = "//div[@title='Apollo admin Cms']")
    private WebElement textdisplay;

    // Actions
    public void clickOnAppSelection() {
        try {
           WebElement app= wait.waitForClickability(appselection);
           app.click();
        }
        catch (Exception e){
            js.executeScript("arguments[0].click();", appselection);        }
    }

    public boolean isAppDisplayed() {
        try {
            WebElement text = wait.waitForVisibility(textdisplay);
            return text.isDisplayed();
        } catch (Exception e) {
            System.out.println("App not displayed: " + e.getMessage());
        }
        return false;
    }
}
