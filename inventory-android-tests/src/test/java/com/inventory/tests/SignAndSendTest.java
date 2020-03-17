package com.inventory.tests;

import org.testng.annotations.Test;

public class SignAndSendTest extends TestBase {

    @Test
    public void signAndSendInventoryToMFC() throws InterruptedException {
        app.selectClientFromTheDiscovery();
        app.clickOnTheReportInventoryButton();
        app.swipeScreenDown();
        app.clickOnTheClientShipperButton();
        app.createSignatureInTheInventory();
        app.clickToTheReturnUpButton();
        app.clickOnTheForemanDriverButton();
        app.createSignatureInTheInventory();
        app.clickToTheReturnUpButton();
        app.swipeScreenUp();
        app.clickOnTheUploadButton();
        app.clickOnTheOKButtonOnThePopUp();
    }
}
