package selenium4point5.cheatsheet;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.pagefactory.ByAll;

import java.net.MalformedURLException;
import java.net.URL;

public class SeleniumCheatSheet {

    public static void main(String[] args) {



//        Driver Initilization
//>>>>>>>>>>>>>>>>>>>>>>

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        //OR

        WebDriver driver1= WebDriverManager.chromedriver().create();

//>>>>>>>>>>>>>>>>>>>>>>

        WebDriverManager.firefoxdriver().setup();
        WebDriver drivera = new FirefoxDriver();

        //OR

        WebDriver drivera1 = WebDriverManager.firefoxdriver().create();

//>>>>>>>>>>>>>>>>>>>>>>

        WebDriverManager.edgedriver().setup();
        WebDriver driverb = new EdgeDriver();

        //OR

        WebDriver driverb1 = WebDriverManager.edgedriver().create();

//>>>>>>>>>>>>>>>>>>>>>>

        WebDriverManager.safaridriver().setup();
        WebDriver driverc = new SafariDriver();

        //OR

        WebDriver driverc1 = WebDriverManager.safaridriver().create();


//>>>>>>>>>>>>>>>>>>>>>>

//        Advanced Browser Configurations
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--ignore-certificate-errors");
        chromeOptions.addArguments("user-data-dir=Path");
        chromeOptions.addArguments("--headless");
        chromeOptions.addArguments("--start-maximized", "--incognito","--disable-notifications" );
              WebDriver  driverco = new ChromeDriver(chromeOptions);

//              Desired Capabilities
        DesiredCapabilities dc = new DesiredCapabilities();
        dc.setCapability("browserName", "chrome");
        dc.setCapability("browserVersion", "96.0");
        dc.setCapability("platformName", "Windows 10");
        try {
            final String URL = "";
            WebDriver driveraa = new RemoteWebDriver(new URL(URL), dc);
        } catch (MalformedURLException e) {
            throw new RuntimeException(e);
        }


//        Element Locators

        driver.findElement(By.id("Id Value"));
        driver.findElement(By.name("Name Value"));
        driver.findElement(By.className("Class Name Value"));
        driver.findElement(By.linkText("Link text Value"));
        driver.findElement(By.partialLinkText("Partial Text Constant Value"));
                driver.findElement(By.tagName("Tag Name Value"));
        driver.findElement(By.cssSelector("CSS Value"));
        driver.findElement(By.xpath("Xpath Value"));
        WebElement passwordField = driver.findElement(By.xpath("abc"));
        driver.findElement(RelativeLocator.with(By.tagName("input"))
                .above(passwordField)); // passwordField is a Element here and not a By.
        WebElement emailAddressField =  driver.findElement(By.xpath("abc"));
        driver.findElement(RelativeLocator.with(By.tagName("input"))
                .below(emailAddressField));
        WebElement submitButton = driver.findElement(By.xpath("abc"));
        driver.findElement(RelativeLocator.with(By.tagName("button"))
                .toLeftOf(submitButton));
        driver.findElement(RelativeLocator.with(By.tagName("button")).toRightOf(submitButton));
        WebElement emailAddressLabel = driver.findElement(By.xpath("abc"));
        driver.findElement(RelativeLocator.with(By.tagName("input")).near(emailAddressLabel));
        driver.findElement(RelativeLocator.with(By.tagName("button")).below(By.id("email")).toRightOf(By.id("cancel")));
        driver.findElement(new ByAll(By.className("ElementClass Name"), By.id("Element Id"), By.name("Element Name")));


    }
}
