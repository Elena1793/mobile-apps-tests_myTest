package com.estimator.tests;

import org.testng.annotations.Test;

public class DownloadSurveyTest extends TestBase {

    @Test
    public void downloadNewSurveyTest() throws InterruptedException {
        app.clickOnDownloadButton();
        app.clickOnTheSearchSurvey("11455");
        app.selectFoundedSurvey();
        app.downloadFoundedSurvey();
        app.clickOnTheEditSurveyButton();
        app.selectAnItemFromInventory();
        app.showAttachedPhoto();
        app.downloadAttachedPhoto();
        app.checkCommentField();
        app.clickToTheReturnUpButton();
        app.swipeScreenToTheLeft();
        app.clickOnTheRoomsWithItemsButton();
        app.selectRoomWithItem();
        app.clickToTheReturnUpButton();
        app.swipeScreenToTheLeft();
        app.clickToTheReturnUpButton();
        app.clickOnTheGeneralInfo();
        app.swipeScreenDown();
        app.swipeScreenToTheLeft();
        app.swipeScreenDown();
        app.swipeScreenToTheLeft();
        app.clickOnTheCheckMarkButton();
        app.clickToTheReturnUpButton();
        app.clickOnTheSurveySummary();
        app.clickToTheReturnUpButton();
        app.clickOnTheSummaries();
        app.clickOnTheCratesSummary();
        app.clickToTheReturnUpButton();
        app.clickToTheReturnUpButton();
        app.clickOnTheCartoonsSummary();
        app.clickToTheReturnUpButton();
        app.clickToTheReturnUpButton();
        app.clickOnTheCostsSummary();
        app.clickToTheReturnUpButton();
        app.clickToTheReturnUpButton();
        app.clickOnTheValuablesSummary();
        app.clickToTheReturnUpButton();
        app.clickToTheReturnUpButton();
        app.clickOnTheHandlingSummary();
        app.clickToTheReturnUpButton();
        app.clickToTheReturnUpButton();
        app.clickOnTheAuxiliaries();
        app.clickOnTheAdditionalMaterials();
        app.clickToTheReturnUpButton();
        app.clickToTheReturnUpButton();
        app.clickOnTheServices();
        app.clickToTheReturnUpButton();
        app.clickToTheReturnUpButton();
        app.clickOnTheAdditionalInfo();
        app.clickToTheReturnUpButton();
        app.clickToTheReturnUpButton();
        app.clickOnTheQuotation();
        app.clickToTheReturnUpButton();
        app.clickToTheReturnUpButton();
        app.clickOnTheDocuments();
        app.clickToTheReturnUpButton();
        app.clickToTheReturnUpButton();
        app.clickBackToSurveys();
        app.clickOnTheOKButtonOnThePopUp();
        //app.deselectSurveyFromDiscovery();

    }
}
