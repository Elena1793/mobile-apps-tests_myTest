package com.inventory.tests;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import java.io.IOException;

public class CreateInventoryTest extends TestBase {

    @Test
    public void createNewInventory() throws InterruptedException, IOException {
        app.clickOnTheCreateNewInventoryButton();
        app.type(By.id("inventory_name"),"Connor");
        app.type(By.id("inventory_id"), "2189-1-1");
        app.hideKeyboard();
        app.clickOnTheCreateButton();
        app.clickOnTheEditInventoryButton();
        app.clickOnTheAddPieceButton();
        app.selectLocationForTheNewPiece();
        app.selectPackageForNewPiece();
        app.selectPBOForNewPiece();
        app.addItemIntoNewPiece();
        app.showParametersOfTheItem();
        app.changeConditionOfNewItem();
        app.changeTypeOfNewItem();
        app.addConditionToTheNewItem();
        app.hideKeyboard();
        app.addLocationToTheNewItem();
        app.hideKeyboard();
        app.attachPhotoToTheNewItem();
        app.clickToTheReturnUpButton();
        app.clickToTheReturnUpButton();
        app.clickOnTheRoomsButtonOnTheInventoryScreen();
        app.selectRoomWithItem();
        app.clickOnTheShowRoomButtonOnTheRoomsScreen();
        app.fillDescriptionField();
        app.hideKeyboard();
        app.fillConditionField();
        app.hideKeyboard();
        app.attachPhotoToThePropertyForPacking();
        app.selectPropertyBeforePacking();
        app.clickOnTheSelectConditionButtonOfPropertyBeforePacking();
        app.clickOnPropertyConditionsButtonBeforePacking();
        app.attachPhotoToThePropertyForPacking();
        app.clickToTheReturnUpButton();
        app.clickOnPropertyConditionsFieldAfterPacking();
        app.attachPhotoToThePropertyForPacking();
        app.selectPropertyAfterPacking();
        app.clickOnTheSelectConditionButtonOfPropertyAfterPacking();
        app.clickOnPropertyConditionsButtonAfterPacking();
        app.attachPhotoToThePropertyForPacking();
        app.clickToTheReturnUpButton();
        app.clickToTheReturnUpButton();
        app.clickOnTheInventoryList();
        app.clickOnTheAppliances();
        app.clickOnTheAdditionalListButton();
        app.clickOnThePackers();
        app.clickOnTheAdditionalListButton();
        app.clickOnTheLoader();
        app.clickOnTheAddSkidButton();
        app.clickOnTheSelectSkidDropDown();
        app.attachPhotoToTheNewSkid();
        app.clickOnTheLoadSkidButton();
        app.clickToTheReturnUpButton();
        app.clickToTheReturnUpButton();
        app.clickOnTheAdditionalListButton();
        app.clickOnTheCartonsSummary();
        app.clickOnTheAdditionalListButton();
        app.clickOnTheAdditionalMaterials();
        app.clickToTheReturnUpButton();
        app.clickOnTheAdditionalListButton();
        app.clickOnTheServices();
        app.clickToTheReturnUpButton();
        app.clickOnTheAdditionalListButton();
        app.clickOnTheAdditionalInfo();
        app.clickToTheReturnUpButton();
        app.clickOnTheAdditionalListButton();
        app.clickOnTheDocuments();
        app.clickOnTheAddDocumentButton();
        app.fillDocumentNameField();
        app.hideKeyboard();
        app.attachPhotoToTheDocumentSection();
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
