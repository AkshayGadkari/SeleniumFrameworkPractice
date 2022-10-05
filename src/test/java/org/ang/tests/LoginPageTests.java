package org.ang.tests;

import org.ang.driver.Driver;
import org.ang.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

public final class LoginPageTests extends BaseTests {

    private LoginPageTests(){

    }


    @Test
    private void test1(){
//        Driver.initDriver();
        DriverManager.getDriver().findElement(By.name("q")).sendKeys("India", Keys.ENTER);
    }


}
