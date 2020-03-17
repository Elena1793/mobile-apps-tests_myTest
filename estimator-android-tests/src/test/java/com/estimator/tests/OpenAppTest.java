package com.estimator.tests;

import org.testng.annotations.Test;

public class OpenAppTest extends TestBase {

    @Test
    public void testAppOpened() {
        System.out.println("App opened");
        app.screenshot();
    }
}
