package com.web;

import org.testng.annotations.Test;

public class CreatePTSInvHandlingProcess extends TestBase {

    @Test
    public void CreateAgentJobTest() throws InterruptedException {
        app.clickOnTheJobsGridField();
        app.clickOnTheCreateFileButton();
        app.selectAnApplicableBookingTypeAgent();
        app.clickOnAgentDropDown();
        app.selectAgent();
        app.clickOnAgentContactDropDown();
        app.selectAgentContact();
        app.fillRefField();
        app.clickOnAgentJobTypeDropDown();
        app.selectAgentJobType();
        app.fillFirstNameTransfereeContactField();
        app.fillLastNameTransfereeContactField();
        app.fillEmailTransfereeContactField();
        app.fillPrimaryPhoneTransfereeContactField();
        app.clickByCreateButton();
        app.clickOnModeDropDown();
        app.selectMode();
        app.clickOnTypeDropDown();
        app.selectType();
        app.clickOnServiceDropDown();
        app.selectService();
        app.clickOnSourceForAgentJobDropDown();
        app.selectSourceForAgentJob();
        app.clickOnCreateNewAddressButtonFrom();
        app.fillCompanyFieldFrom();
        app.fillStreet1FieldFrom();
        app.clickOnCountryDropDownFrom();
        app.selectCountryFrom();
        app.fillSityFieldFrom();
        app.fillZIPFieldFrom();
        app.clickByCreateButtonFrom();
        app.clickOnCreateNewAddressButtonTo();
        app.fillCompanyFieldTo();
        app.fillStreet1FieldTo();
        app.clickOnCountryDropDownTo();
        app.selectCountryTo();
        app.fillSityFieldTo();
        app.fillZIPFieldTo();
        app.clickByCreateButtonTo();
        app.clickOnOperationsButton();
        app.clickOnTheNewOperationButton();
        app.selectPickup();
        app.clickOnOperationsButton();
        app.clickOnTheNewOperationButton();
        app.selectWRin();
        app.clickOnOperationsButton();
        app.clickOnTheNewOperationButton();
        app.selectWRout();
    }
}
