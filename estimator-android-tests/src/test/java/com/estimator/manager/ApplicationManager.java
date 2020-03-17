package com.estimator.manager;

import com.google.common.io.Files;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.concurrent.TimeUnit;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofSeconds;

public class ApplicationManager {

    public AndroidDriver driver;

    public void start() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("deviceName", "BH90015L8Z");
        capabilities.setCapability("platformVersion", "9");
        capabilities.setCapability("appPackage", "com.voxme.estimator.tablet");
        capabilities.setCapability("appActivity", "com.voxme.estimator.tablet.ui.StartupActivity");
        capabilities.setCapability("noReset", "true");
        capabilities.setCapability("unlockType", "pin");
        capabilities.setCapability("unlockKey", "9999");
        capabilities.setCapability("app", "C:/Documents/mobile-apps-tests/estimator-android-tests/src/test/resources/Voxme_Estimator_Universal_v10.1_(Build 402).apk");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    public void stop() {
        driver.quit();
    }

    public void type(By locator, String text) {
        if (text != null) {
            waitForElement(10, locator);
            driver.findElement(locator).clear();
            driver.findElement(locator).sendKeys(text);
        }
    }

    public void attachPhotoToObject() throws InterruptedException {
        waitForElement(10, By.xpath("//android.widget.FrameLayout[@content-desc='Клавиша камеры']"));
        click(By.xpath("//android.widget.FrameLayout[@content-desc='Клавиша камеры']"));
        Thread.sleep(5000);
    }

    public void waitForElement(long timeout, By locator) {
        WebDriverWait wait = new WebDriverWait(driver, timeout);
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    public void screenshot() {
        File tmp = driver.getScreenshotAs(OutputType.FILE);
        File screenshot = new File("src/test/resources/Screenshots/screen" + System.currentTimeMillis() + ".png");
        try {
            Files.copy(tmp, screenshot);
            System.out.println(screenshot);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void click(By locator) {
        driver.findElement(locator).click();
    }

    public void hideKeyboard() {
        driver.hideKeyboard();
    }

    public void swipeScreenToTheLeft() throws InterruptedException {
        WebElement panel = driver.findElement(By.id("pager"));
        Dimension dimension = panel.getSize();

        int anchor = panel.getSize().getHeight() / 2;

        Double ScreenWidthStart = dimension.getWidth() * 0.8;
        int scrollStart = ScreenWidthStart.intValue();

        Double ScreenWidthEnd = dimension.getWidth() * 0.2;
        int scrollEnd = ScreenWidthEnd.intValue();

        new TouchAction(driver)
                .press(point(scrollStart, anchor))
                .waitAction(waitOptions(ofSeconds(1)))
                .moveTo(point(scrollEnd, anchor))
                .release().perform();

        Thread.sleep(3000);
    }

    public void swipeScreenDown() {
        WebElement panel = driver.findElement(By.id("pager"));
        Dimension dimension = panel.getSize();
        Double ScreenHeightStart = dimension.getHeight() * 0.8;
        int scrollStart = ScreenHeightStart.intValue();
        Double ScreenHeightEnd = dimension.getHeight() * 0.2;
        int scrollEnd = ScreenHeightEnd.intValue();

        new TouchAction(driver)
                .press(PointOption.point(0, scrollStart))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(0, scrollEnd))
                .release().perform();
    }

    //TODO
    public void swipeScreenUp() {
    }

    public void clickOnTheDeviceReturnButton() throws InterruptedException {
        Thread.sleep(1000);
        driver.pressKey(new KeyEvent().withKey(AndroidKey.BACK));
    }

    private boolean isElementPresent(By locator) {
        return driver.findElements(locator).size() > 0;
    }

    public void clickToTheReturnUpButton() {
        waitForElement(10, By.xpath("//*[@content-desc='Перейти вверх']"));
        click(By.xpath("//*[@content-desc='Перейти вверх']"));
    }

    public void clickOnTheCreateSurveyButton() {
        click(By.id("newSurvey"));
    }

    public void clickOnTheCreateButton() {
        click(By.id("create_btn"));
    }

    public void clickOnTheEditSurveyButton() {
        click(By.id("editSurvey"));
    }

    public void clickOnTheAddItemButton() {
        click(By.id("fab_add"));
    }

    public void selectLocationForTheNewItem() throws InterruptedException {
        click(By.id("room_field"));
        Thread.sleep(500);
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector())" +
                ".scrollIntoView(" + "new UiSelector().text(\"Attic/Loft\"));").click();
    }

    public void selectModeForTheNewItem() throws InterruptedException {
        click(By.id("mode_field"));
        Thread.sleep(500);
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector())" +
                ".scrollIntoView(" + "new UiSelector().text(\"Sea\"));").click();
    }

    public void clickOnTheStdItemsButton() {
        click(By.id("stdItemsButton"));
    }

    public void selectStandardItemFromList() {
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector())" +
                ".scrollIntoView(" + "new UiSelector().text(\"Chest (10,00)\"));").click();
        click(By.xpath("//*[@text='Chest (10,00)']"));
    }

    public void addStandardItems() {
        click(By.xpath("//*[contains(@resource-id,'cancel') and @text='ADD']"));
    }

    public void showParametersOfTheItem() {
        click(By.xpath("//*[contains(@resource-id,'name') and @text='Chest']"));
    }

    public void clickOnThePhotoIcon() {
        if (isElementPresent(By.id("article_photo_btn"))) {
            click(By.id("article_photo_btn"));
        } else
            click(By.id("address_photo"));
    }

    public void selectAnAction() {
        click(By.xpath("//*[contains(@resource-id,'text1') and @text='Take Photo']"));
    }

    public void clickOnThePackageDropDown() {
        click(By.id("pkgSpinner"));
    }

    public void addPackageToTheNewItem() {
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector())" +
                ".scrollIntoView(" + "new UiSelector().text(\"Small carton (5,00)\"));").click();
    }

    public void addPBO() {
        click(By.id("article_pbo"));
    }

    public void addCrate() {
        click(By.id("detail_crate"));
    }

    public void fillCommentField() {
        WebElement element = driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()." +
                "scrollable(true).instance(0)).scrollIntoView(new UiSelector()." +
                "resourceId(\"com.voxme.estimator.tablet:id/detail_comment\"))");
        element.click();
        type(By.id("detail_comment"), "testCommentToItem");
    }

    public void clickOnTheRoomsWithItemsButton() {
        click(By.xpath("//*[contains(@resource-id,'tabsText') and @text='Rooms With Items']"));
    }

    public void selectRoomWithItem() {
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()"
                + ".resourceId(\"com.voxme.estimator.tablet:id/tabcontent\")).scrollIntoView("
                + "new UiSelector().text(\"Attic/Loft\"));").click();
    }

    public void clickOnTheGeneralInfo() {
        click(By.xpath("//*[contains(@resource-id,'submenu') and @text='General Info']"));
    }

    public void addMobilePhone() {
        type(By.id("general_mobile_phone"), "123456789");
    }

    public void addEmail() {
        type(By.id("email"), "testEmail@gmail.com");
    }

    public void clickOnTheCommentField() {
        click(By.id("general_comment"));
    }

    public void addComment() {
        type(By.id("value_edit"), "testComment");
    }

    public void clickOnTheOKButtonOnThePopUp() {
        if (isElementPresent(By.id("button1"))) {
            click(By.id("button1"));
        } else
            click(By.xpath("//*[@text='OK']"));
    }

    public void clickOnThePreferencesField() {
        WebElement element = driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()." +
                "scrollable(true).instance(0)).scrollIntoView(new UiSelector()." +
                "resourceId(\"com.voxme.estimator.tablet:id/schedules_comment\"))");
        element.click();
    }

    public void fillTheCompanyNameField() {
        type(By.id("address_company"), "TestCompany");
    }

    public void fillTheStreetField() {
        type(By.id("address_street"), "TestStreet");
    }

    public void fillTheCityField() {
        type(By.id("address_city"), "Ashkelon");
    }

    public void fillTheCountryField() {
        type(By.id("address_country"), "Israel");
    }

    public void fillTheZIPField() {
        type(By.id("address_zip"), "12345678");
    }

    public void fillTheFloorField() {
        type(By.id("address_floor"), "5");
    }

    public void fillTheElevatorField() {
        type(By.id("address_el_details"), "yes");
    }

    public void clickOnTheElevatorSwitch() {
        click(By.id("address_el"));
    }

    public void selectTypeOhTheElevator() {
        click(By.id("access_el_type"));
        click(By.xpath("//*[contains(@resource-id,'text1') and @text='Electrical']"));
    }

    public void selectResidenceType() {
        click(By.id("resTypeSpinner"));
        click(By.xpath("//*[contains(@resource-id,'text1') and @text='Apartment']"));
    }

    public void fillCarryDistanceField() {
        type(By.id("access_carry_distance"), "500");
    }

    public void fillCarryDetails() {
        type(By.id("access_carry_details"), "testCarryDetails");
    }

    public void fillStairDistanceField() {
        type(By.id("access_stairs_distance"), "300");
    }

    public void fillStairsDetails() {
        type(By.id("access_stairs_details"), "testStairsDetails");
    }

    public void fillStopDetails() {
        type(By.id("access_additional_stop"), "testStopDetails");
    }

    public void fillShuttleDistanceField() {
        type(By.id("access_shuttle_distance"), "200");
    }

    public void clickReserveParkingSwitch() {
        click(By.id("access_reserve_parking"));
    }

    public void selectParkingType() {
        click(By.id("access_parking_type"));
        click(By.xpath("//*[contains(@resource-id,'text1') and @text='Permit parking']"));
    }

    public void clickOnTheCheckMarkButton() {
        click(By.id("checkmark"));
    }

    public void clickOnTheSurveySummary() {
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()"
                + ".resourceId(\"com.voxme.estimator.tablet:id/navigationmenu\")).scrollIntoView("
                + "new UiSelector().text(\"Survey Summary\"));").click();
    }

    public void clickOnTheSummaries() {
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()"
                + ".resourceId(\"com.voxme.estimator.tablet:id/navigationmenu\")).scrollIntoView("
                + "new UiSelector().text(\"Summaries\"));").click();
    }

    public void clickOnTheCratesSummary() {
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()"
                + ".resourceId(\"com.voxme.estimator.tablet:id/navigationmenu\")).scrollIntoView("
                + "new UiSelector().text(\"Crates Summary\"));").click();
    }

    public void clickOnTheCartoonsSummary() {
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()"
                + ".resourceId(\"com.voxme.estimator.tablet:id/navigationmenu\")).scrollIntoView("
                + "new UiSelector().text(\"Cartons Summary\"));").click();
    }

    public void clickOnTheCostsSummary() {
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()"
                + ".resourceId(\"com.voxme.estimator.tablet:id/navigationmenu\")).scrollIntoView("
                + "new UiSelector().text(\"Costs Summary\"));").click();
    }

    public void clickOnTheValuablesSummary() {
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()"
                + ".resourceId(\"com.voxme.estimator.tablet:id/navigationmenu\")).scrollIntoView("
                + "new UiSelector().text(\"Valuables Summary\"));").click();
    }

    public void clickOnTheHandlingSummary() {
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()"
                + ".resourceId(\"com.voxme.estimator.tablet:id/navigationmenu\")).scrollIntoView("
                + "new UiSelector().text(\"Handling Summary\"));").click();
    }

    public void clickOnTheAuxiliaries() {
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()"
                + ".resourceId(\"com.voxme.estimator.tablet:id/navigationmenu\")).scrollIntoView("
                + "new UiSelector().text(\"Auxiliaries\"));").click();


    }

    public void clickOnTheAdditionalMaterials() {
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()"
                + ".resourceId(\"com.voxme.estimator.tablet:id/navigationmenu\")).scrollIntoView("
                + "new UiSelector().text(\"Additional Materials\"));").click();
    }

    public void clickOnTheServices() {
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()"
                + ".resourceId(\"com.voxme.estimator.tablet:id/navigationmenu\")).scrollIntoView("
                + "new UiSelector().text(\"Services\"));").click();
    }

    public void clickOnTheAdditionalInfo() {
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()"
                + ".resourceId(\"com.voxme.estimator.tablet:id/navigationmenu\")).scrollIntoView("
                + "new UiSelector().text(\"Additional Info\"));").click();
    }

    public void clickOnTheQuotation() {
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()"
                + ".resourceId(\"com.voxme.estimator.tablet:id/navigationmenu\")).scrollIntoView("
                + "new UiSelector().text(\"Quotation\"));").click();
    }

    public void clickOnTheDocuments() {
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()"
                + ".resourceId(\"com.voxme.estimator.tablet:id/navigationmenu\")).scrollIntoView("
                + "new UiSelector().text(\"Documents\"));").click();
    }

    public void clickOnTheAddDocumentButton() {
        click(By.id("add_doc"));
    }

    public void fillDocumentNameField() {
        type(By.id("document_name"), "testFile");
    }

    public void clickOnTheShareIcon() {
        click(By.id("fab_share"));
    }

    public void clickOnTheSignButton() {
        click(By.xpath("//*[contains(@resource-id,'sign_survey') and @text='Sign']"));
    }

    public void createSignatureOnSurvey() {
        click(By.xpath("//*[contains(@resource-id,'signature_view')]"));
    }

    public void clickOnTheUploadButton() {
        if (isElementPresent(By.id("upload_button"))) {
            click(By.id("upload_button"));
        } else
            driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()"
                    + ".resourceId(\"com.voxme.inventory.tablet:id/upload_button\")).scrollIntoView(new UiSelector()));").click();
    }

    public void clickOnThePhotoIconInTheDocumentSection() {
        click(By.id("add_photo_btn"));
    }

    public void clickOnDownloadButton() {
        click(By.id("downloadJobs"));
    }

    public void clickOnTheSearchSurvey(String inventoryRef) throws InterruptedException {
        hideKeyboard();
        type(By.id("search_string"), inventoryRef);
        click(By.id("search_mfs"));
        Thread.sleep(1000);
    }

    public void selectFoundedSurvey() {
        click(By.id("mf_name"));
        click(By.xpath("//*[contains(@resource-id,'button3') and @text='OK']"));
    }

    public void downloadFoundedSurvey() {
        click(By.id("download_mf"));
    }

    public void selectAnItemFromInventory() {
        if (isElementPresent(By.xpath("//*[contains(@text, 'Cabinet')]"))) {
            click(By.xpath("//*[contains(@text, 'Cabinet')]"));
        } else
            click(By.xpath("//*[contains(@text, 'Table')]"));
    }

    public void showAttachedPhoto() {
        click(By.xpath("//*[contains(@resource-id,'photo_thumbnail')]"));
    }

    public void downloadAttachedPhoto() {
        if (isElementPresent(By.xpath("//*[contains(@resource-id,'button1') and @text='Yes']"))) {
            click(By.xpath("//*[contains(@resource-id,'button1') and @text='Yes']"));
        } else
            click(By.xpath("//*[contains(@resource-id,'cancel') and @text='CANCEL']"));
    }

    public void checkCommentField() {
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()." +
                "scrollable(true).instance(0)).scrollIntoView(new UiSelector()." +
                "resourceId(\"com.voxme.estimator.tablet:id/detail_comment\"))");
    }

    public void clickBackToSurveys() {
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()"
                + ".resourceId(\"com.voxme.estimator.tablet:id/navigationmenu\")).scrollIntoView("
                + "new UiSelector().text(\"Back to Surveys\"));").click();
    }

    public void deselectSurveyFromDiscovery() {

    }
}
