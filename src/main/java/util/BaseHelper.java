package util;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.time.Duration;

public class BaseHelper {

    int defaultTimeOut = 30; //setting default timeout to be 30 seconds

    public static WebDriver driver;

    public void setDriver() {
        System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+File.separator +"src" +File.separator +"main" +File.separator +"java" + File.separator + "drivers" + File.separator + "chromedriver.exe");
        driver = new ChromeDriver();
    }

    //Helper method to waitUntil the element is displayed to avoid NoSuchElementException
    public void waitUntilElementDisplayed(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
        wait.until(ExpectedConditions.visibilityOf(element));
    }

    public void launchProduct(String url) {
        driver.get(url);
    }

    //Helper method to find Element and find Elements without writing the long code and takes xpath as parameter
    public WebElement findElement(String xPath) {
        return driver.findElement(By.xpath(xPath));
    }

      /*public List<WebElement> findElements(String xPath) {

      }*/





}
