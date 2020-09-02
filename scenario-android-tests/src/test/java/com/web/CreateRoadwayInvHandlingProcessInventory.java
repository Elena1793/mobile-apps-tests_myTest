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

public class CreateRoadwayInvHandlingProcessInventory extends TestBase {

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
    public void downloadRoadwayInvTest() throws InterruptedException {
        app.clickOnDownloadButton();
        app.clickOnTheSearchInventory("2901-1");
        app.selectPickUpTransaction();
        //app.clickOnTheOKButtonOnThePopUp();
        app.downloadFoundedInventory();
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

        app.clickOnDownloadButton();
        app.clickOnTheSearchInventory("2901-1");
        app.selectWarehouseReceiveInTransaction();
        app.clickOnTheCheckButtonOnTheDiscovery();
        app.typeNewBarcodeNumber("2901-1 001");
        app.hideKeyboard();
        app.clickOnTheCheckButton();
        app.typeNewBarcodeNumber("2901-1 002");
        app.hideKeyboard();
        app.clickOnTheCheckButton();
        app.clickOnTheTruckIconToCreateLU();
        app.clickOnTheAddSkidButton();
        app.clickOnTheSelectSkidDropDown();
        app.swipeScreenDown();
        app.selectSkid();
        app.enterSkidLocation();
        app.returnBack();
        app.returnBack();
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

        app.clickOnDownloadButton();
        app.clickOnTheSearchInventory("2901-1");
        app.selectWarehouseOutloadTransaction();
        app.downloadFoundedInventory();
        app.clickOnTheCheckButtonOnTheDiscovery();
        app.clickOnTheYesButton();
        app.typeNewBarcodeNumber("2900-1 001");
        app.hideKeyboard();
        app.clickOnTheCheckButton();
        app.clickOnTheOKButton();
        app.typeNewBarcodeNumber("2900-1 002");
        app.hideKeyboard();
        app.clickOnTheCheckButton();
        app.clickOnTheOKButton();
        app.returnBack();
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

        app.clickOnDownloadButton();
        app.clickOnTheSearchInventory("2901-1");
        app.selectDeliveryTransaction();
        app.downloadFoundedInventory();
        app.clickOnTheCheckButtonOnTheDiscovery();
        app.clickOnTheYesButton();
        app.typeNewBarcodeNumber("2900-1 001");
        app.hideKeyboard();
        app.clickOnTheCheckButton();
        app.clickOnTheOKButton();
        app.typeNewBarcodeNumber("2900-1 002");
        app.hideKeyboard();
        app.clickOnTheCheckButton();
        app.clickOnTheOKButton();
        app.returnBack();
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
    }
}
