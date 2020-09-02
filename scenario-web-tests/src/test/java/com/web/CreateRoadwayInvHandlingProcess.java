package com.web;

import org.testng.annotations.Test;

public class CreateRoadwayInvHandlingProcess extends TestBase{

    @Test
    public void createJobsTest() throws InterruptedException {
        app.clickOnTheJobsGridField();
        app.clickOnTheCreateFileButton();
        app.selectAnApplicableBookingTypePrivate();
        app.clickOnSourceDropDown();
        app.selectSource();
        app.clickOnJobTypeDropDown();
        app.selectPrivateJobType();
        app.clickFirstNameField();
        app.clickLastNameField();
        app.clickEmailField();
        app.clickPrimaryPhoneField();
        app.clickByCreateButton();
        app.clickOnModeDropDown();
        app.selectMode();
        app.clickOnTypeDropDown();
        app.selectType();
        app.clickOnServiceDropDown();
        app.selectService();
        app.clickOnOperationsButton();
        app.clickOnTheNewOperationButton();
        app.selectPickup();
        app.clickOnOperationsButton();
        app.clickOnTheNewOperationButton();
        app.selectWRin();
        app.clickOnOperationsButton();
        app.clickOnTheNewOperationButton();
        app.selectWRout();
        app.clickOnTheNewOperationButton();
        app.selectDelivery();
    }
}
