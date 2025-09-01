package stepDefinitions;

import drivers.DriverManager;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageobjects.Appselectionpage;

public class AppSelectionSteps {

    WebDriver driver;
    Appselectionpage appPage;

    @Given("user is on the App Selection page")
    public void user_is_on_the_app_selection_page() {
        driver = DriverManager.getDriver();
        appPage = new Appselectionpage(driver);
    }

    @When("user clicks on the Apollo CMS app")
    public void user_clicks_on_the_apollo_cms_app() {
        appPage.clickOnAppSelection();
    }

    @Then("Apollo CMS app should be displayed")
    public void apollo_cms_app_should_be_displayed() {
        boolean displayed = appPage.isAppDisplayed();
        Assert.assertTrue(displayed, "Apollo CMS app is not displayed");
    }
}
