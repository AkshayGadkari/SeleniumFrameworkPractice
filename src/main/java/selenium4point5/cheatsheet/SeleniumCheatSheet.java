package selenium4point5.cheatsheet;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.asynchttpclient.util.Assertions;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.interactions.WheelInput;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.locators.RelativeLocator;
import org.openqa.selenium.support.pagefactory.ByAll;
import org.openqa.selenium.support.ui.*;
import org.testng.Assert;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Clock;
import java.time.Duration;
import java.util.List;
import java.util.Set;
import java.util.function.Function;

public class SeleniumCheatSheet {


//  Refer:   https://www.selenium.dev/documentation/

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

//        Pause
        WebElement clickable = driver.findElement(By.id("clickable"));
        new Actions(driver)
                .moveToElement(clickable)
                .pause(Duration.ofSeconds(1))
                .clickAndHold()
                .pause(Duration.ofSeconds(1))
                .sendKeys("abc")
                .perform();

//        Release All Actions

        ((RemoteWebDriver) driver).resetInputState();

//        Keyboard actions

        /*enum Keys: NULL         ('\uE000'),
  CANCEL       ('\uE001'), // ^break
  HELP         ('\uE002'),
  BACK_SPACE   ('\uE003'),
  TAB          ('\uE004'),
  CLEAR        ('\uE005'),
  RETURN       ('\uE006'),
  ENTER        ('\uE007'),
  SHIFT        ('\uE008'),
  LEFT_SHIFT   (Keys.SHIFT),
  CONTROL      ('\uE009'),
  LEFT_CONTROL (Keys.CONTROL),
  ALT          ('\uE00A'),
  LEFT_ALT     (Keys.ALT),
  PAUSE        ('\uE00B'),
  ESCAPE       ('\uE00C'),
  SPACE        ('\uE00D'),
  PAGE_UP      ('\uE00E'),
  PAGE_DOWN    ('\uE00F'),
  END          ('\uE010'),
  HOME         ('\uE011'),
  LEFT         ('\uE012'),
  ARROW_LEFT   (Keys.LEFT),
  UP           ('\uE013'),
  ARROW_UP     (Keys.UP),
  RIGHT        ('\uE014'),
  ARROW_RIGHT  (Keys.RIGHT),
  DOWN         ('\uE015'),
  ARROW_DOWN   (Keys.DOWN),
  INSERT       ('\uE016'),
  DELETE       ('\uE017'),
  SEMICOLON    ('\uE018'),
  EQUALS       ('\uE019'),

  // Number pad keys
  NUMPAD0      ('\uE01A'),
  NUMPAD1      ('\uE01B'),
  NUMPAD2      ('\uE01C'),
  NUMPAD3      ('\uE01D'),
  NUMPAD4      ('\uE01E'),
  NUMPAD5      ('\uE01F'),
  NUMPAD6      ('\uE020'),
  NUMPAD7      ('\uE021'),
  NUMPAD8      ('\uE022'),
  NUMPAD9      ('\uE023'),
  MULTIPLY     ('\uE024'),
  ADD          ('\uE025'),
  SEPARATOR    ('\uE026'),
  SUBTRACT     ('\uE027'),
  DECIMAL      ('\uE028'),
  DIVIDE       ('\uE029'),

  // Function keys
  F1           ('\uE031'),
  F2           ('\uE032'),
  F3           ('\uE033'),
  F4           ('\uE034'),
  F5           ('\uE035'),
  F6           ('\uE036'),
  F7           ('\uE037'),
  F8           ('\uE038'),
  F9           ('\uE039'),
  F10          ('\uE03A'),
  F11          ('\uE03B'),
  F12          ('\uE03C'),

  META         ('\uE03D'),
  COMMAND      (Keys.META),

  ZENKAKU_HANKAKU ('\uE040');*/

//        Key down
        new Actions(driver)
                .keyDown(Keys.SHIFT)
                .sendKeys("a")
                .perform();


//          Key up
        new Actions(driver)
        .keyDown(Keys.SHIFT)
                .sendKeys("a")
                .keyUp(Keys.SHIFT)
                .sendKeys("b")
                .perform();


// Send keys
        new Actions(driver)
                .sendKeys("abc")
                .perform();


//        Designated Element

        WebElement textField = driver.findElement(By.xpath("//input"));
        new Actions(driver)
                .sendKeys(textField, "Selenium!")
                .perform();

//        Copy and Paste

        Keys cmdCtrl = Platform.getCurrent().is(Platform.MAC) ? Keys.COMMAND : Keys.CONTROL;

        WebElement textField1 = driver.findElement(By.id("textInput"));
        new Actions(driver)
                .sendKeys(textField1, "Selenium!")
                .sendKeys(Keys.ARROW_LEFT)
                .keyDown(Keys.SHIFT)
                .sendKeys(Keys.ARROW_UP)
                .keyUp(Keys.SHIFT)
                .keyDown(cmdCtrl)
                .sendKeys("xvv")
                .keyUp(cmdCtrl)
                .perform();

        Assert.assertEquals("SeleniumSelenium!", textField1.getAttribute("value"));

//>>>>>>
        //Mouse actions

//        Click and hold
//This method combines moving the mouse to the center of an element with pressing the left mouse button.
// This is useful for focusing a specific element:
        WebElement clickable1 = driver.findElement(By.id("clickable"));
        new Actions(driver)
                .clickAndHold(clickable1)
                .perform();

//        Click and release
/*This method combines moving to the center of an element with pressing and releasing the left mouse button.
This is otherwise known as “clicking”:*/
        WebElement clickable2 = driver.findElement(By.id("click"));
        new Actions(driver)
                .click(clickable2)
                .perform();

        /*
        Alternate Button Clicks
There are a total of 5 defined buttons for a Mouse:

0 — Left Button (the default)
1 — Middle Button (currently unsupported)
2 — Right Button
3 — X1 (Back) Button
4 — X2 (Forward) Button
*/

/*        Context Click

        This method combines moving to the center of an element with pressing and releasing the right mouse button (button 2).
        This is otherwise known as “right-clicking”:
*/
        WebElement clickable3 = driver.findElement(By.id("clickable"));
        new Actions(driver)
                .contextClick(clickable3)
                .perform();

//        Double click
        WebElement clickable4 = driver.findElement(By.id("clickable"));
        new Actions(driver)
                .doubleClick(clickable4)
                .perform();

//Move to element
        WebElement hoverable = driver.findElement(By.id("hover"));
        new Actions(driver)
                .moveToElement(hoverable)
                .perform();

//        Drag and Drop on Element
        WebElement draggable = driver.findElement(By.id("draggable"));
        WebElement droppable = driver.findElement(By.id("droppable"));
        new Actions(driver)
                .dragAndDrop(draggable, droppable)
                .perform();

//        Drag and Drop by Offset

        WebElement draggable1 = driver.findElement(By.id("draggable"));
        Rectangle start = draggable1.getRect();
        Rectangle finish = driver.findElement(By.id("droppable")).getRect();
        new Actions(driver)
                .dragAndDropBy(draggable1, finish.getX() - start.getX(), finish.getY() - start.getY())
                .perform();

//>>>>>>>
//        Scroll wheel actions

    /*    A representation of a scroll wheel input device for interacting with a web page.
                Selenium v4.2

        Chromium Only

        There are 5 scenarios for scrolling on a page.*/

        WebElement iframe = driver.findElement(By.tagName("iframe"));
        new Actions(driver)
                .scrollToElement(iframe)
                .perform();

//        >>>

        WebElement footer = driver.findElement(By.tagName("footer"));
        int deltaY = footer.getRect().y;
        new Actions(driver)
                .scrollByAmount(0, deltaY)
                .perform();

//        >>>

        WebElement iframe1 = driver.findElement(By.tagName("iframe"));
        WheelInput.ScrollOrigin scrollOrigin = WheelInput.ScrollOrigin.fromElement(iframe1);
        new Actions(driver)
                .scrollFromOrigin(scrollOrigin, 0, 200)
                .perform();

//        >>>
        WebElement footer1 = driver.findElement(By.tagName("footer"));
        WheelInput.ScrollOrigin scrollOrigin1 = WheelInput.ScrollOrigin.fromElement(footer1, 0, -50);
        new Actions(driver)
                .scrollFromOrigin(scrollOrigin1,0, 200)
                .perform();

//        >>>

        WheelInput.ScrollOrigin scrollOrigin2 = WheelInput.ScrollOrigin.fromViewport(10, 10);
        new Actions(driver)
                .scrollFromOrigin(scrollOrigin2, 0, 200)
                .perform();




//        Manage Timeouts

//        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); // Deprecated
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

//        driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS); // Deprecated
        driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(30));

//      Explicit wait
        WebElement firstResult = new WebDriverWait(driver, Duration.ofSeconds(10))
                .until(ExpectedConditions.elementToBeClickable(By.xpath("//a/h3")));

        firstResult.click();




//        Fluent Wait

        /*Waiting 30 seconds for an element to be present on the page, checking
         for its presence once every 5 seconds.
        Users may configure the wait to ignore specific types of exceptions whilst waiting,
        such as NoSuchElementException when searching for an element on the page.*/

        Wait<WebDriver> wait = new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(30))
                .pollingEvery(Duration.ofSeconds(5))
                .ignoring(NoSuchElementException.class);

        WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
            public WebElement apply(WebDriver driver) {
                return driver.findElement(By.id("foo"));
            }
        });


//>>>>>>>>
//        Upload a File

        driver.get("https://the-internet.herokuapp.com/upload");
        //we want to import selenium-snapshot file.
        driver.findElement(By.id("file-upload")).sendKeys("selenium-snapshot.jpg");
        driver.findElement(By.id("file-submit")).submit();
        if(driver.getPageSource().contains("File Uploaded!")) {
            System.out.println("file uploaded");
        }
        else{
            System.out.println("file not uploaded");
        }

//>>>>>>>>
//        Capture Width and Height of an Element

        Point point = element.getLocation();
        int elementWidth = element.getSize().getWidth();
        int elementHeight = element.getSize().getHeight();

        //>>>>>>>>
//        Window Handle

        String handle = driver.getWindowHandle();
        Set<String> handles = driver.getWindowHandles();
        driver.switchTo().window(handle);

        //Example:

        //Store the ID of the original window
        String originalWindow = driver.getWindowHandle();

        //Check we don't have other windows open already
        assert driver.getWindowHandles().size() == 1;

        //Click the link which opens in a new window
        driver.findElement(By.linkText("new window")).click();

        //Wait for the new window or tab
        wait.until(ExpectedConditions.numberOfWindowsToBe(2));

        //Loop through until we find a new window handle
        for (String windowHandle : driver.getWindowHandles()) {
            if(!originalWindow.contentEquals(windowHandle)) {
                driver.switchTo().window(windowHandle);
                break;
            }
        }

         //Wait for the new tab to finish loading content
        wait.until(ExpectedConditions.titleIs("Selenium documentation"));

//>>>>>>>>
//        Create new window (or) new tab and switch

        //Opens a new tab and switches to new tab
        driver.switchTo().newWindow(WindowType.TAB);

         //Opens a new window and switches to new window
        driver.switchTo().newWindow(WindowType.WINDOW);

//>>>>>>>>
//        Scroll Down or Up Web Page

        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("window.scrollBy(0,100)");
        js.executeScript("window.scrollTo(0, document.body.scrollHeight)");
        WebElement elementx = driver.findElement(By.xpath("Value of Element Locator"));

        js.executeScript("arguments[0].scrollIntoView()", elementx);

//>>>>>>>>
//        Information about web elements

        // Get boolean value for is element display
        boolean isButtonVisible = driver.findElement(By.cssSelector("[name='login']")).isDisplayed();

        //returns true if element is enabled else returns false
        boolean value = driver.findElement(By.name("btnK")).isEnabled();

        //returns true if element is checked else returns false
        boolean value1 = driver.findElement(By.cssSelector("input[type='checkbox']:first-of-type")).isSelected();

        //returns TagName of the element
        String value2 = driver.findElement(By.cssSelector("h1")).getTagName();

//        Size and Position
       /* It is used to fetch the dimensions and coordinates of the referenced element.

                The fetched data body contain the following details:

        X-axis position from the top-left corner of the element
        y-axis position from the top-left corner of the element
        Height of the element
        Width of the element*/

        // Returns height, width, x and y coordinates referenced element
        Rectangle res =  driver.findElement(By.cssSelector("h1")).getRect();

        // Rectangle class provides getX,getY, getWidth, getHeight methods
        System.out.println(res.getX());

//        Get CSS Value
     /*   Retrieves the value of specified computed style property of an element in the current browsing context.*/

        // Retrieves the computed style property 'color' of linktext
        String cssValue = driver.findElement(By.linkText("More information...")).getCssValue("color");

//        Text Content
        // Retrieves the text of the element
        String text = driver.findElement(By.cssSelector("h1")).getText();

    }
}
