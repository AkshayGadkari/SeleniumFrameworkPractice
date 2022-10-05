package org.ang.tests;

import org.ang.driver.DriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.testng.annotations.Test;


public final class HomePageTests extends BaseTests{

 private HomePageTests(){

 }

    @Test
    private void test2(){
      DriverManager.getDriver().findElement(By.name("q")).sendKeys("Vacation Places", Keys.ENTER);
    }

    @Test
    private void test3(){
        DriverManager.getDriver().findElement(By.name("q")).sendKeys("Mumbai", Keys.ENTER);
    }

}
