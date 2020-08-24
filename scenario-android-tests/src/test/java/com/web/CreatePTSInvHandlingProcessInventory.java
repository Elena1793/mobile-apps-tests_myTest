package com.web;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class CreatePTSInvHandlingProcessInventory extends TestBase{

    @DataProvider
    public Iterator<Object[]> barcodes() throws IOException {
        List<Object[]> list = new ArrayList<>();
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/barcodes.csv")));
        String line = reader.readLine();
        while(line!=null){
            String[] split = line.split(";");
            line = reader.readLine();
        }
        return list.iterator();
    }

    @Test
    public void DownloadPTSInvTest() throws InterruptedException {
        app.clickOnDownloadButton();
        app.clickOnTheSearchInventory("7777777");
        app.selectPickUpTransaction();
        //app.clickOnTheOKButtonOnThePopUp();
        app.downloadFoundedInventory();
        app.clickOnTheEditInventoryButton();
        app.clickOnTheAddPieceButton();
        app.swipeScreenDown();
        app.addItemIntoNewFirstPiece();
        app.returnBack();
        app.clickOnTheAddPieceButton();
        app.swipeScreenDown();
        app.addItemIntoNewSecondPiece();
        app.returnToTheDiscoveryPage();
        app.clickOnTheReportInventoryButton();
        app.swipeScreenDown();
        app.clickOnTheClientShipperButton();
        app.createSignatureInTheInventory();
        app.returnBack();
        app.clickOnTheForemanDriverButton();
        app.createSignatureInTheInventory();
        app.returnBack();
        app.swipeScreenUp();
        app.clickOnTheUploadButton();
        app.clickOnTheServerURLOKButton();
        app.clickOnTheOKButtonOnThePopUp();
        app.returnBack();

        app.clickOnTheEditInventoryButton();
        app.clickOnTheAddPieceButton();
        app.swipeScreenDown();
        app.addItemIntoNewThirdPiece();
        app.returnToTheDiscoveryPage();
        app.clickOnTheReportInventoryButton();
        app.swipeScreenDown();
        app.clickOnTheClientShipperButton();
        app.createSignatureInTheInventory();
        app.returnBack();
        app.clickOnTheForemanDriverButton();
        app.createSignatureInTheInventory();
        app.returnBack();
        app.swipeScreenUp();
        app.clickOnTheUploadButton();
        app.clickOnTheServerURLOKButton();
        app.clickOnTheOKButtonOnThePopUp();
        app.returnBack();

        app.clickOnTheEditInventoryButton();
        app.clickOnTheAddPieceButton();
        app.swipeScreenDown();
        app.addItemIntoNewFourthPiece();
        app.returnToTheDiscoveryPage();
        app.clickOnTheReportInventoryButton();
        app.swipeScreenDown();
        app.clickOnTheClientShipperButton();
        app.createSignatureInTheInventory();
        app.returnBack();
        app.clickOnTheForemanDriverButton();
        app.createSignatureInTheInventory();
        app.returnBack();
        app.swipeScreenUp();
        app.clickOnTheUploadButton();
        app.clickOnTheServerURLOKButton();
        app.clickOnTheOKButtonOnThePopUp();
        app.returnBack();
        app.deselectSurveyFromDiscovery();
        app.clickOnDownloadButton();
        app.clickOnTheSearchInventory("7777777");
        app.selectWarehouseReceiveInTransaction();
        //app.clickOnTheOKButtonOnThePopUp();
        app.downloadFoundedInventory();
        app.clickOnTheCheckButtonOnTheDiscovery();
        app.clickOnTheBoxIconToCreateLU();
        app.clickOnTheAddSkidButton();
        app.clickOnTheSelectSkidDropDown();
        app.enterSkidLocation();
        app.returnBack();
        app.returnBack();
        app.typeNewBarcodeNumber("2787-1-1");
        app.hideKeyboard();
        app.clickOnTheCheckButton();
        app.typeNewBarcodeNumber("2787-1-2");
        app.hideKeyboard();
        app.clickOnTheCheckButton();
        app.typeNewBarcodeNumber("2787-1-3");
        app.hideKeyboard();
        app.clickOnTheCheckButton();
        app.typeNewBarcodeNumber("2787-1-4");
        app.hideKeyboard();
        app.clickOnTheCheckButton();
        app.clickOnTheOKButtonOnThePopUp();
    }
}
