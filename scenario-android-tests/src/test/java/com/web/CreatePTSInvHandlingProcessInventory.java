package com.web;

import org.testng.annotations.Test;

public class CreatePTSInvHandlingProcessInventory extends TestBase{

    @Test
    public void DownloadPTSInvTest() throws InterruptedException {
        app.clickOnDownloadButton();
        app.clickOnTheSearchInventory("55555");
        app.selectPickUpTransaction();
        app.clickOnTheOKButtonOnThePopUp();
        app.downloadFoundedInventory();
        app.clickOnTheEditInventoryButton();
        app.addLabelToTheTransaction();
        app.clickOnTheAddPieceButton();
        app.addItemIntoNewPiece();
        app.returnToTheDiscoveryPage();
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
        app.screenshot();
        app.clickToTheReturnUpButton();
    }
}
