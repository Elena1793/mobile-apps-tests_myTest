package com.web;

import com.manager.ApplicationManager;
import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


public class TestBase {

    protected static ApplicationManager app = new ApplicationManager
            (System.getProperty("browser", BrowserType.CHROME));

    @BeforeClass
    public void setUp() {
        app.start();
    }

    @AfterClass
    public void tearDown(){
        app.stop();
    }
}
