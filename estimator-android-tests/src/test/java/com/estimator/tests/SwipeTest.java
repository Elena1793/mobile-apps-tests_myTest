package com.estimator.tests;

import org.testng.annotations.Test;

public class SwipeTest extends TestBase {

    @Test
    public void differentSwipeTests() throws InterruptedException {
        app.swipeScreenDown();
        app.swipeScreenUp();
        app.swipeScreenToTheLeft();
        app.swipeScreenToTheRight();
    }
}
