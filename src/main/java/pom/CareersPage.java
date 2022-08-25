package pom;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import util.BaseHelper;

import java.time.Duration;

public class CareersPage extends BaseHelper {


    WebElement header = findElement("//h1[@class='animated fadeIn mb-md']");
    WebElement jobTypeDropDown = findElement("//section//div[@class='row job-filters']//select[@id='job_type']");







    public WebElement getJobTypeOptionElement(String jobType) {
        return findElement("//option[text()='"+jobType+"']");
    }

    public WebElement getJobFromListing(String jobName) {
        return findElement("//a[text()='"+jobName+"']");
    }

    public String getHeaderText() {
        waitUntilElementDisplayed(header);
        return header.getText();
    }

    public void selectJobType(String jobType) {
        waitUntilElementDisplayed(jobTypeDropDown);
        jobTypeDropDown.click();
        waitUntilElementDisplayed(getJobTypeOptionElement(jobType));
        getJobTypeOptionElement(jobType).click();
        jobTypeDropDown.click();
    }

    public void getInternshipErrorMessage() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,250)", "");

        String script = "return window.getComputedStyle(document.querySelector('.dataTables_empty'),':after').getPropertyValue('content')";
        String content = (String) js.executeScript(script);
        System.out.println(content);
    }

    public void selectJobFromListing(String jobName) {
        waitUntilElementDisplayed(getJobFromListing(jobName));
        getJobFromListing(jobName).click();
    }

    public String getPageUrl() {
        return driver.getCurrentUrl();
    }




}
