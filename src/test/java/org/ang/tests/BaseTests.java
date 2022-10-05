package org.ang.tests;

import org.ang.driver.Driver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTests {

    protected BaseTests(){
    }

    @BeforeMethod
    protected void setUp(){
        Driver.initDriver();
    }

    @AfterMethod
    protected void tearDown(){
        Driver.quiteDriver();
    }

}
