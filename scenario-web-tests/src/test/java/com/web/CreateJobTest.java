package com.web;


import org.testng.annotations.Test;

public class CreateJobTest extends TestBase{

    @Test
    public void createJobTest() throws InterruptedException {
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
    }
}

