package quantilope.script;

import Pages.BasePage;
import Pages.DashboardPage;
import Pages.SurveyPage;
import org.testng.Assert;
import org.testng.annotations.Test;


public class QuantilopeTest extends BasePage {

    // Initialize pages
    DashboardPage dashboardPage = new DashboardPage();
    SurveyPage surveyPage = new SurveyPage();

    // Urls
    String surveyURL = "https://survey.quantilope.com/SfidqfGjdrvMzwzWK/pvrLDDxk4s7ty75yn/9xednGW4bJAGd7sv2";
    String dashboardURL= "https://app.quantilope.com/share/ELxib6zdYkwCgYsCD?type=dashboard";

    @Test
    public void dashboardValues() throws InterruptedException {

        // Get value for horizontal bar for Q3
        String barValueBefore = dashboardPage.getBarValue(1);

        // Get the value for number of questions answered before completing the survey again
        String[] beforeValue = barValueBefore.split(" ");

        // Get old value and convert to integer
        int oldValue = Integer.parseInt(beforeValue[0]);

        // Switch tab to Survey
        dashboardPage.switchTabs(surveyURL);

        // Fill the Survey with valid answers
        surveyPage.fillSurvey("Red", "4", "2");

        // Switch back to the Dashboard tab
        dashboardPage.switchBackTo(dashboardURL);

        // Get the value for number of questions answered after completing the survey again
        String barValueAfter = dashboardPage.getBarValue(1);

        // Verify that number of questions are different after completing the survey
        Assert.assertNotEquals(barValueBefore, barValueAfter);

        // Get actual number of question only
        String[] afterValue = barValueAfter.split(" ");

        // Get new value and convert to integer
        int newValue = Integer.parseInt(afterValue[0]);

        // Verify that specific answered value is increased by 1
        Assert.assertEquals(newValue, oldValue+1);

    }

}
