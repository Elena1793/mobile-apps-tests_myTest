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
        app.swipeScreenDown();
        app.addItemIntoNewPiece();
        app.showParametersOfTheItem();
        app.changeTypeOfNewItem();
        app.addConditionToTheNewItem();
        app.hideKeyboard();
        app.addCommentToTheNewItem();
        app.hideKeyboard();
        app.addCondition();
        app.addLocation();
        app.hideKeyboard();
        app.attachPhotoToTheNewItemFromGallery();
        app.attachPhotoToTheNewItemFromCamera();
        app.clickOnTheDeviceReturnButton();
        app.clickToTheReturnUpButton();
        //app.clickToTheReturnUpButton();
        app.swipeScreenToTheLeft();
        app.selectRoomWithItem();
        app.clickToTheInspectionInfoButton();
        app.fillDescriptionField();
        app.hideKeyboard();
        app.fillConditionField();
        app.hideKeyboard();
        app.attachPhotoToTheNewItemFromGallery();
        app.attachPhotoConditions();
        //app.clickOnTheDeviceReturnButton();
        app.selectPropertyBeforePacking();
        app.clickOnTheSelectConditionButtonOfPropertyBeforePacking();
        app.clickOnPropertyConditionsFieldAfterPacking();
        app.attachPhotoToTheNewItemFromGallery();
        app.attachPhotoConditions();
        //app.clickOnTheDeviceReturnButton();
        app.selectPropertyAfterPacking();
        app.clickOnTheSelectConditionButtonOfPropertyAfterPacking();
        app.clickToTheReturnUpButton();
        app.clickToTheReturnUpButton();
        app.swipeScreenToTheLeft();
        app.clickToAddSkidButton();
        app.swipeScreenDown();
        app.clickToTheSkidContentButton();
        app.clickToTheLoadSkidButton();
        app.clickToTheReturnUpButton();
        app.attachPhotoToTheNewItemFromGallery();
        app.attachPhotoToTheNewSkid();
        //app.clickOnTheDeviceReturnButton();
        app.clickToTheSkidOKButton();
        app.clickOnTheMenuButton();
        app.clickOnTheSummaries();
        app.clickOnThePackers();
        app.clickToTheReturnUpButton();
        app.clickOnTheMenuButton();
        app.clickOnTheCartonsSummary();
        app.clickToTheReturnUpButton();
        app.clickOnTheMenuButton();
        app.clickOnTheAppliances();
        app.clickToTheReturnUpButton();
        app.clickOnTheMenuButton();
        app.swipeScreenDownMenu();
        app.clickOnTheAdditionalServicesButton();
        app.clickOnTheAdditionalMaterials();
        app.clickToTheReturnUpButton();
        app.clickOnTheMenuButton();
        app.clickOnTheServices();
        app.clickToTheReturnUpButton();
        app.clickOnTheMenuButton();
        app.clickOnTheAdditionalInfo();
        app.clickToTheReturnUpButton();
        app.clickOnTheMenuButton();
        app.clickOnTheDocuments();
        app.clickOnTheAddDocumentButton();
        app.fillDocumentNameField();
        app.hideKeyboard();
        app.attachPhotoToTheDocumentSectionFromGallery();
        app.clickOnTheAddDocumentButton();
        app.fillDocumentNameField();
        app.hideKeyboard();
        app.attachPhotoToTheDocumentSection();
        app.clickOnTheDeviceReturnButton();
        app.clickToTheReturnUpButton();
        app.clickToTheReturnUpButton();
        app.clickOnTheMenuButton();
        app.swipeScreenDownMenu();
        app.clickToTheSignAndSendButton();
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
