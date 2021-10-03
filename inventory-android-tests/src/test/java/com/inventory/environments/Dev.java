package com.inventory.environments;


import com.inventory.tests.TestBase;
import org.testng.annotations.Test;

public class Dev extends TestBase {

    @Test
        public void downloadProdConfiguration() throws InterruptedException {
            app.clickOnTheSettingsButton();
            app.clickOnTheSettings();
            app.clickOnTheVoxmeCloud();
            app.clickOnTheServerURL();
            app.selectProtocol();
            app.typeDevURL();
            app.typeApplication();
            app.clickToTheReturnUpButton();
            app.typeUserName("testuser3");
            app.typePassword("testuser3");
            //app.clickToTheReturnUpButton();
            app.clickOnConfigurations();
            app.clickOnTheDownloadConfigurationButton();
            app.clickOnTheYesButton();
            app.clickOnTheOKButtonOnThePopUp();
            app.clickToTheReturnUpButton();
            //app.clickToTheReturnUpButton();
    }
}
