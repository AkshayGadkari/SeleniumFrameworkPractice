package selenium4point5.cheatsheet;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.pagefactory.ByAll;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Clock;
import java.time.Duration;
import java.util.List;
import java.util.Set;

public class SeleniumCheatSheet {

    public static void main(String[] args) {


//        Driver Initilization
//>>>>>>>>>>>>>>>>>>>>>>

        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();

        //OR

        WebDriver driver1 = WebDriverManager.chromedriver().create();

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
        chromeOptions.addArguments("--start-maximized", "--incognito", "--disable-notifications");
        WebDriver driverco = new ChromeDriver(chromeOptions);

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
        WebElement emailAddressField = driver.findElement(By.xpath("abc"));
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


//>>>>>>>>>>>>>>

        //Elements Operations

        WebElement element = driver.findElement(By.xpath("Value of Element Locator"));

        element.click();
        element.sendKeys("Input Text");
        element.clear();
        element.submit();
        element.getAttribute("type");
        String innerText = element.getText();
        boolean enabledstatus = element.isEnabled();
        boolean displayedstatus = element.isDisplayed();
        boolean selectedstatus = element.isSelected();

//Operation on drop down

        Select select = new Select(element);
        int index=1;
        select.selectByIndex(index);
        select.selectByVisibleText("Text");
        select.selectByValue("Value");
        select.deselectAll();
        select.deselectByIndex(index);
        select.deselectByVisibleText("Text");
        select.deselectByValue("Value");
        List<WebElement> selectedOptions = select.getOptions();

//Browser Operations

        String pageTitle = driver.getTitle();
        String currentURL = driver.getCurrentUrl();
        String currentPageSource = driver.getPageSource();

// Navigation history

        driver.get("https://www.facebook.com/");
        driver.manage().window().maximize();
        driver.manage().window().fullscreen();
        driver.navigate().to("https://www.google.com/");
        driver.navigate().back();
        driver.navigate().forward();
        driver.navigate().refresh();
        driver.close();
        driver.quit();

// Handle Alert
        Alert alert = driver.switchTo().alert();

        alert.accept();
        alert.dismiss();
        alert.getText();
        alert.sendKeys("Input Data");
//Handle Cookies
        Cookie cookie = new Cookie("cookieName", "cookieValue");

        driver.manage().addCookie(cookie);
        driver.manage().getCookies();
        driver.manage().getCookieNamed("cookieName");
        driver.manage().deleteAllCookies();
        driver.manage().deleteCookieNamed("cookieName");
        driver.manage().deleteCookie(cookie);

// Handle frames

        int frameIndex= 2;
        driver.switchTo().frame(frameIndex);
        driver.switchTo().frame("frameName");
        WebElement elementa = driver.findElement(By.xpath("Value of Element Locator"));
        driver.switchTo().frame(elementa);
        driver.switchTo().defaultContent();

//        Screenshots Capture

        TakesScreenshot screenshot = ((TakesScreenshot) driver);
        File srcFile = screenshot.getScreenshotAs(OutputType.FILE);

        screenshot.getScreenshotAs(OutputType.BASE64);
        screenshot.getScreenshotAs(OutputType.BYTES);

        File destFile = new File("");
        try {
            FileHandler.copy(srcFile, destFile);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

//        Actions Class/MouseEvent

        WebElement webElement = driver.findElement(By.xpath("abc"));

        Actions action = new Actions(driver);
        action.keyDown(Keys.CONTROL);
        action.keyUp(Keys.CONTROL);
        action.clickAndHold(webElement).build().perform();
        action.doubleClick(webElement).build().perform();
        action.moveToElement(webElement).build().perform();
        int xOffset = 5;
        int yOffset = 6;
        action.moveByOffset(xOffset, yOffset).build().perform();
        WebElement sourceEle = driver.findElement(By.xpath("abc"));
        WebElement targetEle = driver.findElement(By.xpath("abc"));
        action.dragAndDrop(sourceEle, targetEle).build().perform();
        action.release().build().perform();

//        Manage Timeouts

//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // Deprecated
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));


//        WebDriverWait wait = null;
//        Duration timeout;
//        webElement = wait.until(wait = new
//                        WebDriverWait(driver, timeout)
//        ExpectedConditions.elementToBeClickable(element);
//        element.click();


//        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS); // Deprecated
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));


//        Upload a File
//
//        WebElement elementn = driver.findElement(By.ElementLocator("Value of Element Locator"));
//
//        elementn.sendKeys(filePath);


//        Capture Width and Height of an Element

        Point point = element.getLocation();
        int elementWidth = element.getSize().getWidth();
        int elementHeight = element.getSize().getHeight();

//        Window Handle

        String handle = driver.getWindowHandle();
        Set<String> handles = driver.getWindowHandles();
        driver.switchTo().window(handle);

//        Scroll Down or Up Web Page

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,100)");
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        WebElement elementx = driver.findElement(By.xpath("Value of Element Locator"));

        js.executeScript("arguments[0].scrollIntoView()", element);


    }
}
