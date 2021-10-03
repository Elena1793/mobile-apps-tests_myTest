package com.inventory.tests;

import org.testng.annotations.Test;

public class UserRegistrationTest extends TestBase {

    @Test
        public void newUserRegistration() throws InterruptedException {
            app.clickOnTheSettingsButton();
            app.clickOnTheUserRegistration();
            app.typeCompanyID();
            app.typeCompanyName();
            app.typeCompanyWebsite();
            app.typeCompanyTel();
            app.typeRegistrationUserName("Anton Nakonechnyi");
            app.typeInventoryReturnEmail();
            app.hideKeyboard();
            app.clickOnTheLanguageDropdown();
            app.selectLanguage();
            app.selectUnits();
            app.swipeScreenDown();
            app.clickOnTheActivateServiceButton();
            app.clickOnTheOKButtonOnThePopUp();
            app.clickToTheReturnUpButton();
    }
}
