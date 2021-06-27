package com.inventory.tests;

import org.testng.annotations.Test;

public class CheckInventoryTest extends TestBase {

    @Test
        public void checkingAndScanningInProcess() throws InterruptedException {

            app.clickOnDownloadButton();
            app.clickOnTheSearchInventory("3407-4-1");
            app.selectFoundedInventory();
            app.downloadFoundedInventory();
            app.clickOnTheEditInventoryButton();
            app.clickOnTheAddPieceButton();
            app.selectLocationForTheNewPiece();
            app.swipeScreenDown();
            app.addItemIntoNewPiece();
            app.clickToTheReturnUpButton();
            app.clickOnTheAddPieceButton();
            app.selectLocationForTheNewPiece();
            app.swipeScreenDown();
            app.addItemIntoNewPiece();
            app.clickToTheReturnUpButton();
            app.clickOnTheMenuButton();
            app.swipeScreenDown();
            app.clickOnTheBackToJobListButton();
            app.clickOnTheCheckButtonOnTheDiscovery();
            app.clickOnTheTruckIconToCreateLU();
            app.clickToAddSkidButton();
            app.clickOnTheSelectSkidDropDown();
            app.swipeSkidScreenUp();
            app.selectContainer();
            app.clickToTheSkidOKButton();
            app.clickToAddSkidButton();
            app.clickOnTheSelectSkidDropDown();
            app.selectLiftvan();
            app.clickToTheSkidOKButton();
            app.clickToTheReturnUpButton();
            app.typeNewBarcodeNumber("3407-4-001");
            app.hideKeyboard();
            app.clickOnTheCheckButton();
            app.selectLUFromDropDown();
            app.clickOnTheSelectedSkidInTheDropDownContainer();
            app.clickOnTheOKLabelButtonSkid();
            app.typeNewBarcodeNumber("3407-4-002");
            app.hideKeyboard();
            app.clickOnTheCheckButton();
            app.selectLUFromDropDown();
            app.clickOnTheSelectedSkidInTheDropDownLiftvan();
            app.clickOnTheOKLabelButtonSkid();
            app.clickOnTheOKButtonOnThePopUp();
            app.clickToTheReturnUpButton();
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
            app.screenshot();
            app.clickToTheReturnUpButton();
    }
}
