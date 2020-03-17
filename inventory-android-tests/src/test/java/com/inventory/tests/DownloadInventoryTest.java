package com.inventory.tests;

import org.testng.annotations.Test;

public class DownloadInventoryTest extends TestBase {

    @Test
    public void downloadInventoryFromMFC() throws InterruptedException {
      app.clickOnDownloadButton();
      app.clickOnTheSearchInventory("2357-1-1");
      app.selectFoundedInventory();
      app.downloadFoundedInventory();
      app.clickOnTheEditInventoryButton();
      app.selectAnItemFromInventory();
      app.showParametersOfTheItem();
      app.showAttachedPhoto();
      app.downloadAttachedPhoto();
      app.clickToTheReturnUpButton();
      app.clickToTheReturnUpButton();
      app.clickOnTheInfoButton();
      //app.clickOnTheSchedulesButton();
      //app.clickToTheReturnUpButton();
      app.swipeScreenDown();
      app.clickOnTheOriginButton();
      app.clickToTheReturnUpButton();
      app.swipeScreenDown();
      app.clickOnTheDestinationButton();
      app.clickToTheReturnUpButton();
      app.clickOnTheRoomsButtonOnTheInventoryScreen();
      app.selectRoomWithItem();
      app.clickOnTheShowRoomButtonOnTheRoomsScreen();
      app.showAttachedPhoto();
      app.downloadAttachedPhoto();
      app.clickOnPropertyConditionsFieldAfterPacking();
      app.showAttachedPhoto();
      app.downloadAttachedPhoto();
      app.clickToTheReturnUpButton();
      app.clickOnTheInventoryList();
      app.clickOnTheAppliances();
      app.clickOnTheAdditionalListButton();
      app.clickOnThePackers();
      app.clickOnTheAdditionalListButton();
      app.clickOnTheLoader();
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
      app.returnToTheDiscoveryPage();
    }
}
