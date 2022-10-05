package org.ang.driver;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.Objects;

public final class Driver {

    private Driver(){

    }


    public static void initDriver(){
        if (Objects.isNull(DriverManager.getDriver())) {
            WebDriverManager.chromedriver().setup();
            DriverManager.setDriver(new ChromeDriver());
            DriverManager.getDriver().get("https://google.com");
        }
    }

    public static void quiteDriver(){
        if(Objects.nonNull(DriverManager.getDriver())) {
            DriverManager.getDriver().quit();
            DriverManager.unload();
        }
    }
}
