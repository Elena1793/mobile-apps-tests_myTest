package com.inventory.tests;

import org.testng.annotations.Test;

public class CheckInventoryStandaloneTest extends TestBase {

    @Test
        public void checkingAndScanningInProcess() throws InterruptedException {
        //For import jobs that don’t have any inventory
            app.clickOnTheCreateNewInventoryButton();
            app.typeClientLastNameInTheNameField("AddLabels Manually");
            app.hideKeyboard();
            app.clickOnTheCreateButton();
            app.touchOnTheCreatedInventoryOnDiscovery();
            app.clickOnTheAddLabelsField();
            app.typeQuantityOnTheAddField();
            app.clickToTheReturnUpButton();
            app.clickOnTheCheckButtonOnTheDiscovery();
            app.clickOnTheBoxIconToCreateLU();
            app.clickOnTheAddSkidButton();
            app.clickOnTheSelectSkidDropDown();
            app.clickToTheReturnUpButton();
            app.clickToTheReturnUpButton();
            app.typeNewBarcodeNumber("1000336-001");
            app.clickOnTheCheckButton();
            app.selectLUFromDropDown();
            app.clickOnTheSelectedSkidInTheDropDown();
            app.clickOnTheOKLabelButton();
            app.clickOnTheOKButtonOnThePopUp();
    }
}
