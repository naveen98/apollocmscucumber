package stepDefinitions;

import drivers.DriverManager;
import io.cucumber.java.en.*;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pageobjects.CmsUpdatepages;
import utils.Excelutils;

public class UpdateIssueSteps {

    private WebDriver driver;
    private CmsUpdatepages updatePage;


    private static final String FILE_PATH  = "E:\\projects\\raj-projects\\apollocms\\src\\test\\resources\\createissuecms.xlsx";
    private static final String SHEET_NAME = "updateissue";

       public UpdateIssueSteps(){
        driver = DriverManager.getDriver();
        updatePage = new CmsUpdatepages(driver);
    }

    @When("I update Pine Lab Issue details from Excel test data")
    public void i_update_issue_details_from_excel() throws Throwable {
        String[][] data = Excelutils.getcelldatas(FILE_PATH, SHEET_NAME);

        for (int i = 0; i < data.length; i++) {

            String issueNo       = data[i][0];
            String storeContact  = data[i][1];
            String category      = data[i][2];
            String description   = data[i][3];

            try {
                updatePage.clickupdatebutton(issueNo);

                updatePage.updateissuedetailsfornew(storeContact, category, description);

                updatePage.updatebtns();

                //updatePage.handlepopup();


                String msg = updatePage.getvalidationmessage();
                boolean success = msg != null && (msg.toLowerCase().contains("updated") || msg.toLowerCase().contains("success"));

                if(success){
                    Assert.assertTrue(true);
                }else{
                    Assert.assertTrue(false);
                }


            } catch (Exception e) {
                Assert.fail(e.getMessage());
            }
        }
    }

    @Then("I should see the update confirmation")
    public void i_should_see_the_update_confirmation() {

        System.out.println("update completed.");
    }
}
