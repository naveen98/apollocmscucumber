package stepDefinitions;

import drivers.DriverManager;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageobjects.CmsNavigatetoPineLabsIssuePages;

public class NavigatetoPinelabs {

    WebDriver driver;
    CmsNavigatetoPineLabsIssuePages pineLabsPage;

    @Given("I am logged into the CMS and on the CMS home page")
    public void i_am_logged_into_the_cms_and_on_the_cms_home_page() {
        driver = DriverManager.getDriver();
        pineLabsPage = new CmsNavigatetoPineLabsIssuePages(driver);
    }

    @When("I navigate to Pine Lab Issues from the sidebar")
    public void i_navigate_to_pine_lab_issues_from_the_sidebar() {
        pineLabsPage.navigatetopinelab();
    }

    @Then("the Pine Lab Issues page should be visible")
    public void the_pine_lab_issues_page_should_be_visible() {
        boolean displayed = pineLabsPage.istextdisplayed();
        Assert.assertTrue(displayed, "Pine Lab Issues page is not visible");
    }
}
