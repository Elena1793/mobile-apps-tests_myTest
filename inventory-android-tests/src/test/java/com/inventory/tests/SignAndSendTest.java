package com.inventory.tests;

import org.testng.annotations.Test;

public class SignAndSendTest extends TestBase {

    @Test
    public void signAndSendInventoryToMFC() throws InterruptedException {
        app.selectClientFromTheDiscovery();
        app.clickOnTheReportInventoryButton();
        app.swipeScreenDown();
        app.clickOnTheClientShipperButton();
        app.createSignature();
        app.clickToTheReturnUpButton();
        app.clickOnTheForemanDriverButton();
        app.createSignature();
        app.clickToTheReturnUpButton();
        app.swipeScreenUp();
        app.clickOnTheUploadButton();
        app.clickOnTheOKButtonOnThePopUp();
    }
}
