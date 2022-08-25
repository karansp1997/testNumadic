import data.TestData;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import pom.CareersPage;
import pom.QAEngineerPage;


public class TestNumadic extends BaseTest {

    TestData data = new TestData();


    @BeforeTest
    public void init() {
        setDriver();
        launchProduct(data.baseURL);
    }

    @Test
    public void verifyHeaderText() {
        CareersPage careersPage = new CareersPage();
        assert careersPage.getHeaderText().equals(data.headerText);
    }

    @Test
    public void verifyErrorMessageOnSelectingInternship() {
        CareersPage careersPage = new CareersPage();
        careersPage.selectJobType(data.jobTypeInternship);

        careersPage.getInternshipErrorMessage(); //Not Working due to non-interactable pseudo web elements

    }

    @Test
    public void verifyUserJourney() {
        CareersPage careersPage = new CareersPage();
        QAEngineerPage qaEngineerPage = new QAEngineerPage();
        careersPage.selectJobType(data.jobTypeFullTime);
        careersPage.selectJobFromListing(data.jobName);
        String pageUrl = careersPage.getPageUrl();
        assert pageUrl.equals(data.qaPageURL);
        qaEngineerPage.clickOnApplyButton(); //Not Working due to non-interactable pseudo web elements
    }


    @AfterTest
    public void completeTest() {
        driver.quit();
    }

}
