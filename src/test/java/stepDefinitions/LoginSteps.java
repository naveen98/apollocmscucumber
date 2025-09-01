package stepDefinitions;

import drivers.DriverManager;
import hooks.CmsBaseclass;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageobjects.CmsLoginPage;

public class LoginSteps {

    private WebDriver driver;
    private CmsLoginPage loginPage;

    public LoginSteps() {
        this.driver = DriverManager.getDriver();
        this.loginPage = new CmsLoginPage(driver);
    }

    @Given("I am on the CMS login page")
    public void i_am_on_the_cms_login_page() {
        loginPage=new CmsLoginPage(DriverManager.getDriver());

    }

    @When("I login using valid credentials")
    public void i_login_using_valid_credentials() {
        loginPage.logindata(CmsBaseclass.username, CmsBaseclass.password);
    }

    @Then("I should see the CMS home page")
    public void i_should_see_the_cms_home_page() {
        boolean visible = loginPage.cmsdisplayed();
        Assert.assertTrue(visible, "CMS label not visible after login");
    }
}
