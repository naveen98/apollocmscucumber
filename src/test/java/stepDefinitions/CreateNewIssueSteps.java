package stepDefinitions;

import drivers.DriverManager;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageobjects.CreateNewIssuePage;
import utils.Excelutils;

public class CreateNewIssueSteps {

    WebDriver driver;
    CreateNewIssuePage cc;


    private static final String FILE_PATH = "E:\\projects\\raj-projects\\apollocms\\src\\test\\resources\\createissuecms.xlsx";
    private static final String SHEET_NAME = "createissue";

    @Given("I am on the Pine Lab Issues page")
    public void i_am_on_the_pine_lab_issues_page() {
        driver = DriverManager.getDriver();
        cc = new CreateNewIssuePage(driver);
    }

    @When("I create new issues from Excel test data")
    public void i_create_new_issues_from_excel_test_data() throws Throwable {
        String[][] data = Excelutils.getcelldatas(FILE_PATH, SHEET_NAME);

        for (int i = 0; i < data.length; i++) {
            try {
                // map your Excel columns directly
                String storeInput        = data[i][0];
                String expectedStoreText = data[i][1];
                String category          = data[i][2];
                String deviceId          = data[i][3];
                String description       = data[i][4];

                cc.clickbutton();
                cc.createnewissue(storeInput, expectedStoreText, category, deviceId, description);
                cc.createsubmitbtn();

                String msg = cc.getvalidationmessage();
                boolean success = msg.toLowerCase().contains("created") || msg.toLowerCase().contains("successfully");

                Assert.assertTrue(success, " failed. Toast: " + msg + " | Data = " + storeInput + " / " + expectedStoreText);

            } catch (Exception e) {
                Assert.fail(e.getMessage());
            }
        }
    }

}
