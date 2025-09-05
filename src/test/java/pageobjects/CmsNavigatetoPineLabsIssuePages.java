package pageobjects;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.Webdriverwaitutils;


public class CmsNavigatetoPineLabsIssuePages {

	WebDriver driver;
	Webdriverwaitutils wait;

	public CmsNavigatetoPineLabsIssuePages(WebDriver driver) {

		this.driver = driver;
		this.wait = new Webdriverwaitutils(driver);
		PageFactory.initElements(driver, this);
	}

	@FindBy(xpath = "//a[@class='icon-bars sidebar-toggle']")
	private WebElement sidebarbtn;
	@FindBy(xpath = "//span[normalize-space()='Pine Lab Issues']")
	private WebElement pinelabissue;
	@FindBy(xpath = "//h2[normalize-space()='Pine Lab Issues']")
	private WebElement pinelabtextdisplay;

	public void navigatetopinelab() {

        try {

            WebElement ele = wait.waitForClickability(sidebarbtn);
            ele.click();
        } catch (Exception e) {

            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", sidebarbtn);
        }

        try {
            WebElement pineLab = wait.waitForClickability(pinelabissue);
            pineLab.click();
        } catch (Exception e) {
            JavascriptExecutor js = (JavascriptExecutor) driver;
            js.executeScript("arguments[0].click();", pinelabissue);
        }
	}

	public boolean istextdisplayed() {

		try {
			WebElement text = wait.waitForVisibility(pinelabtextdisplay);
			return text.isDisplayed();

		} catch (Exception e) {
			System.out.println("Not displayed");

		}
		return false;

	}

}
