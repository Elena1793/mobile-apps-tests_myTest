package com.estimator.tests;

import com.estimator.manager.ApplicationManager;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import java.lang.reflect.Method;
import java.net.MalformedURLException;

public class TestBase {
    Logger logger = LoggerFactory.getLogger(TestBase.class);

    protected static ApplicationManager app = new ApplicationManager();

    @BeforeSuite
    public void setUp() throws MalformedURLException { app.start(); }

    @BeforeMethod
    public void logTestStart(Method m){
        logger.info("Start test " + m.getName());
    }

    @AfterMethod
    public void logTestStop(Method m){
        logger.info("Stop test " + m.getName());
    }

//    @AfterSuite
//    public void tearDown() {
//        app.stop();
//    }
}
