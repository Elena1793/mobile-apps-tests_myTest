package com.inventory.manager;

import com.google.common.io.Files;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.LongPressOptions;
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

import static io.appium.java_client.touch.offset.ElementOption.element;

public class ApplicationManager {

    public AndroidDriver driver;

    public void start() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        //capabilities.setCapability("deviceName", "emulator-5554");
        capabilities.setCapability("deviceName", "BH90015L8Z");
        capabilities.setCapability("platformVersion", "9");
        //capabilities.setCapability("platformVersion", "8");
        capabilities.setCapability("appPackage", "com.voxme.inventory.tablet");
        capabilities.setCapability("appActivity", "com.voxme.inventory.tablet.ui.StartupActivity");
        capabilities.setCapability("noReset", "true");
        capabilities.setCapability("unlockType", "pin");
        capabilities.setCapability("unlockKey", "9999");
        capabilities.setCapability("app", "C:/Documents/mobile-apps-tests/inventory-android-tests/src/test/resources/Voxme_Inventory_Universal_v10.8_(Build 575).apk");

        driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), capabilities);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
    }

    public void type(By locator, String text) {
        if (text != null) {
            driver.findElement(locator).clear();
            driver.findElement(locator).sendKeys(text);
        }
    }
    //TODO
    public void attachPhotoToTheNewItem() throws InterruptedException {
        click(By.id("article_photo_btn"));
        if (isElementPresent(By.xpath("//android.widget.FrameLayout[@content-desc='Клавиша камеры']"))) {
            click(By.xpath("//android.widget.FrameLayout[@content-desc='Клавиша камеры']"));
        } else
            click(By.xpath("//*[contains(@resource-id,'NONE') and @text='Shutter']"));
            click(By.xpath("//*[contains(@resource-id,'okay') and @text='OK']"));
        Thread.sleep(3000);
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

    public void stop() {
        driver.quit();
    }

    public void clickToTheReturnUpButton() throws InterruptedException {
        if (isElementPresent(By.xpath("//*[@content-desc='Перейти вверх']"))) {
            click(By.xpath("//*[@content-desc='Перейти вверх']"));
            Thread.sleep(1000);
        } else
            driver.findElement(By.xpath("//*[@content-desc='Navigate up']")).click();
    }

    public void selectClientFromTheDiscovery() {
        click(By.xpath("//*[contains(@resource-id,'name') and @text='Connor']"));
    }

    public void clickOnTheUploadButton() throws InterruptedException {
        click(By.xpath("//*[contains(@resource-id,'upload_button')]"));
        Thread.sleep(35000);
    }

    public void clickOnTheCreateNewInventoryButton() {
        if (isElementPresent(By.id("newInventory"))) {
            click(By.id("newInventory"));
        } else
            click(By.xpath("//*[contains@resource-id,'newInventory']"));
    }

    public void typeClientLastNameInTheNameField(String clientLastName) {
        type(By.id("inventory_name"), clientLastName);
    }

    public void clickOnTheCreateButton() {
        click(By.id("create_btn"));
    }

    public void clickOnDownloadButton() {
        waitForElement(10, By.id("downloadJobs"));
        click(By.id("downloadJobs"));
    }

    public void clickOnTheSearchInventory(String inventoryRef) throws InterruptedException {
        hideKeyboard();
        type(By.id("search_string"), inventoryRef);
        click(By.id("search_mfs"));
        Thread.sleep(1000);
    }

    public void selectFoundedInventory() {
        click(By.id("mf_name"));
        click(By.xpath("//*[contains(@resource-id,'button3') and @text='OK']"));
    }

    public void downloadFoundedInventory() {
        click(By.id("download_mf"));
    }

    private boolean isElementPresent(By locator) {
        return driver.findElements(locator).size() > 0;
    }

    public void touchOnTheCreatedInventoryOnDiscovery() {
        TouchAction touch = new TouchAction(driver);
        WebElement el = driver.findElement(By.xpath("//*[contains(@resource-id,'name') and @text='AddLabels Manually']"));
        touch.longPress(LongPressOptions.longPressOptions().withElement(element(el)).withDuration(Duration.ofMillis(1000)))
                .release()
                .perform();
    }

    public void clickOnTheAddLabelsField() {
        click(By.xpath("//*[contains(@resource-id,'title') and @text='Add Labels']"));
    }

    public void typeQuantityOnTheAddField() {
        type(By.id("add_label_no"), "1");
    }

    public void clickOnTheCheckButtonOnTheDiscovery() {
        click(By.id("checkInventory"));
    }

    public void clickOnTheEditInventoryButton() {
        click(By.id("editInventory"));
    }

    public void clickOnTheAddPieceButton() {
        click(By.id("add_piece"));
    }

    public void selectLocationForTheNewPiece() throws InterruptedException {
        click(By.id("roomSpinner"));
        Thread.sleep(1000);
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()"
                + ".resourceId(\"com.voxme.inventory.tablet:id/simpleItemsList\")).scrollIntoView("
                + "new UiSelector().text(\"Attic/Loft\"));").click();
    }

    public void selectPackageForNewPiece() throws InterruptedException {
        click(By.id("pkgSpinner"));
        Thread.sleep(1000);
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector())" +
                ".scrollIntoView(" + "new UiSelector().text(\"Small carton\"));").click();
    }

    public void selectPBOForNewPiece() {
        click(By.id("piece_pbo"));
    }

    public void addItemIntoNewPiece() {
        click(By.id("add_item_2"));
        click(By.id("search_text"));
        type(By.id("search_text"), "Cabinet");
        click(By.xpath("//*[contains(@resource-id,'item_name') and @text='Cabinet (4,00)']"));
    }

    public void showParametersOfTheItem() {
        click(By.id("show_item"));
    }

    public void changeConditionOfNewItem() {
        click(By.id("piece_item_condition"));
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()"
                + ".resourceId(\"com.voxme.inventory.tablet\")).scrollIntoView("
                + "new UiSelector().text(\"Good\"));").click();
    }

    public void changeTypeOfNewItem() {
        click(By.id("item_details_type"));
        click(By.xpath("//*[contains(@resource-id,'text1') and @text='Others']"));
    }

    public void addConditionToTheNewItem() {
        click(By.id("item_condition_selector"));
        click(By.xpath("//*[contains(@resource-id,'text1') and @text='Good']"));
        click(By.xpath("//*[contains(@resource-id,'button1') and @text='OK']"));
    }

    public void addLocationToTheNewItem() {
        click(By.id("item_location_selector"));
        click(By.xpath("//*[contains(@resource-id,'text1') and @text='Location1']"));
        click(By.xpath("//*[contains(@resource-id,'button1') and @text='OK']"));
    }

    public void clickOnTheRoomsButtonOnTheInventoryScreen() {
        click(By.id("rooms"));
    }

    public void selectRoomWithItem() {
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()"
                + ".resourceId(\"com.voxme.inventory.tablet:id/roomSummaryList\")).scrollIntoView("
                + "new UiSelector().text(\"Attic/Loft\"));").click();
    }

    public void clickOnTheShowRoomButtonOnTheRoomsScreen() {
        click(By.xpath("//*[contains(@resource-id,'show_room') and @text='...']"));
    }

    public void fillDescriptionField() {
        click(By.id("room_description"));
        type(By.id("room_description"), "DescriptionTEST");
    }

    public void fillConditionField() {
        click(By.id("room_condition"));
        type(By.id("room_condition"), "ConditionTEST");
    }

    public void selectPropertyBeforePacking() {
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()"
                + ".resourceId(\"com.voxme.inventory.tablet:id/prop_name\")).scrollIntoView("
                + "new UiSelector().text(\"Walls\"));").click();
    }

    public void clickOnTheSelectConditionButtonOfPropertyBeforePacking() {
        click(By.xpath("//*[contains(@resource-id,'text1') and @text='Good']"));
        click(By.xpath("//*[contains(@resource-id,'button1') and @text='OK']"));
    }

    public void clickOnPropertyConditionsButtonBeforePacking() {
        click(By.xpath("//*[contains(@resource-id,'show_property') and @text='...']"));
    }

    public void clickOnPropertyConditionsFieldAfterPacking() {
        waitForElement(10, By.xpath("//*[contains(@text, 'After Packing')]"));
        click(By.xpath("//*[contains(@text, 'After Packing')]"));
    }

    public void selectPropertyAfterPacking() {
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()"
                + ".resourceId(\"com.voxme.inventory.tablet:id/prop_name\")).scrollIntoView("
                + "new UiSelector().text(\"Walls\"));").click();
    }

    public void clickOnTheSelectConditionButtonOfPropertyAfterPacking() {
        click(By.xpath("//*[contains(@resource-id,'text1') and @text='Good']"));
        click(By.xpath("//*[contains(@resource-id,'button1') and @text='OK']"));
    }

    public void clickOnPropertyConditionsButtonAfterPacking() {
        click(By.xpath("//*[contains(@resource-id,'show_property') and @text='...']"));
    }

    public void clickOnTheAdditionalListButton() {
        if (isElementPresent(By.xpath("//*[@content-desc='More options']"))) {
            click(By.xpath("//*[@content-desc='More options']"));
        } else
            click(By.xpath("//*[@content-desc='Ещё']"));
    }
    //TODO
    public void clickOnTheInventoryList() throws InterruptedException {
        if (isElementPresent(By.id("inventory_summary"))) {
            click(By.id("inventory_summary"));
            Thread.sleep(5000);
        } else
            click(By.xpath("//*[@content-desc='Ещё']"));
        //click(By.xpath("//*[contains(@resource-id,'title') and @text='Inventory List']")); - for Polina's device
    }
    //TODO
    public void clickOnTheAppliances() {
        if (isElementPresent(By.id("appliances"))) {
            click(By.id("appliances"));
        } else
            click(By.xpath("//*[@content-desc='Ещё']"));
        //click(By.xpath("//*[contains(@resource-id,'title') and @text='Appliances']")); - for Polina's device
    }

    public void clickOnThePackers() {
        click(By.xpath("//*[contains(@resource-id,'title') and @text='Packers']"));
    }

    public void clickOnTheLoader() {
        click(By.xpath("//*[contains(@resource-id,'title') and @text='Loader']"));
    }

    public void clickOnTheAddSkidButton() {
        click(By.xpath("//*[contains(@resource-id, 'add_skid') and @text='+']"));
    }

    public void clickOnTheSelectSkidDropDown() {
        click(By.id("skidType"));
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()"
                + ".resourceId(\"android:id/text1\")).scrollIntoView("
                + "new UiSelector().text(\"Pallet\"));").click();
    }

    public void clickOnTheLoadSkidButton() {
        waitForElement(10, By.xpath("//*[contains(@resource-id,'load_skid') and @text='Load']"));
        click(By.xpath("//*[contains(@resource-id,'load_skid') and @text='Load']"));
    }

    public void clickOnTheCartonsSummary() {
        click(By.xpath("//*[contains(@resource-id,'title') and @text='Cartons Summary']"));
    }

    public void clickOnTheAdditionalMaterials() {
        click(By.xpath("//*[contains(@resource-id,'title') and @text='Additional Materials']"));
    }

    public void clickOnTheServices() {
        click(By.xpath("//*[contains(@resource-id,'title') and @text='Services']"));
    }

    public void clickOnTheAdditionalInfo() {
        click(By.xpath("//*[contains(@resource-id,'title') and @text='Additional Info']"));
    }

    public void clickOnTheDocuments() {
        click(By.xpath("//*[contains(@resource-id,'title') and @text='Documents']"));
    }

    public void clickOnTheAddDocumentButton() {
        click(By.xpath("//*[contains(@resource-id,'add_doc') and @text='+']"));
    }

    public void fillDocumentNameField() {
        click(By.id("document_name"));
        type(By.id("document_name"), "testFile");
    }

    public void returnToTheDiscoveryPage() throws InterruptedException {
        driver.pressKey(new KeyEvent().withKey(AndroidKey.BACK));
        Thread.sleep(1000);
        driver.pressKey(new KeyEvent().withKey(AndroidKey.BACK));
        Thread.sleep(1000);
        driver.pressKey(new KeyEvent().withKey(AndroidKey.BACK));
        Thread.sleep(1000);
        driver.pressKey(new KeyEvent().withKey(AndroidKey.BACK));
        Thread.sleep(1000);
        driver.pressKey(new KeyEvent().withKey(AndroidKey.BACK));
    }

    public void clickOnTheReportInventoryButton() {
        click(By.id("reportInventory"));
    }

    public void clickOnTheClientShipperButton() {
        waitForElement(15, (By.xpath("//*[contains(@resource-id,'sign_survey') and @text='Sign']")));
        click(By.xpath("//*[contains(@resource-id,'sign_survey') and @text='Sign']"));
    }

    public void createSignatureInTheInventory() {
        click(By.xpath("//*[contains(@resource-id, 'signature_view')]"));
    }

    public void clickOnTheForemanDriverButton() {
        waitForElement(15, (By.xpath("//*[contains(@resource-id,'driver_sign_survey') and @text='Sign']")));
        click(By.xpath("//*[contains(@resource-id,'driver_sign_survey') and @text='Sign']"));
    }

    public void clickOnTheOKButtonOnThePopUp() {
        waitForElement(25, (By.xpath("//*[contains(@resource-id,'button3') and @text='OK']")));
        click(By.xpath("//*[contains(@resource-id,'button3') and @text='OK']"));
    }

    public void clickOnTheDeviceReturnButton() throws InterruptedException {
        Thread.sleep(1000);
        driver.pressKey(new KeyEvent().withKey(AndroidKey.BACK));
    }
    //TODO
    public void attachPhotoToThePropertyForPacking() throws InterruptedException {
        waitForElement(25,(By.id("add_photo")));
        click(By.id("add_photo"));
        if (isElementPresent(By.xpath("//android.widget.FrameLayout[@content-desc='Клавиша камеры']"))) {
            click(By.xpath("//android.widget.FrameLayout[@content-desc='Клавиша камеры']"));
        } else
            click(By.xpath("//*[contains(@resource-id,'NONE') and @text='Shutter']"));
        //click(By.xpath("//*[contains(@resource-id,'okay') and @text='OK']")); - for Polina's device
        Thread.sleep(10000);
    }
    //TODO
    public void attachPhotoToTheNewSkid() throws InterruptedException {
        click(By.id("skid_photo_btn"));
        if (isElementPresent(By.xpath("//android.widget.FrameLayout[@content-desc='Клавиша камеры']"))) {
            click(By.xpath("//android.widget.FrameLayout[@content-desc='Клавиша камеры']"));
        } else
            click(By.xpath("//*[contains(@resource-id,'NONE') and @text='Shutter']"));
        //click(By.xpath("//*[contains(@resource-id,'okay') and @text='OK']")); - for Polina's device
        Thread.sleep(5000);
    }
    //TODO
    public void attachPhotoToTheDocumentSection() throws InterruptedException {
        click(By.id("add_photo_btn"));
        if (isElementPresent(By.xpath("//android.widget.FrameLayout[@content-desc='Клавиша камеры']"))) {
            click(By.xpath("//android.widget.FrameLayout[@content-desc='Клавиша камеры']"));
        } else
            click(By.xpath("//*[contains(@resource-id,'NONE') and @text='Shutter']"));
        //click(By.xpath("//*[contains(@resource-id,'okay') and @text='OK']")); - for Polina's device
        Thread.sleep(5000);
    }

    public void selectAnItemFromInventory() {
        if (isElementPresent(By.xpath("//*[contains(@text, 'Cabinet')]"))) {
            click(By.xpath("//*[contains(@text, 'Cabinet')]"));
        } else
            click(By.xpath("//*[contains(@text, 'Table')]"));
    }

    public void showAttachedPhoto() {
        click(By.xpath("//*[contains(@resource-id,'imageGallery')]"));
    }

    public void downloadAttachedPhoto() {
        if (isElementPresent(By.xpath("//*[contains(@resource-id,'button1') and @text='Yes']"))) {
            click(By.xpath("//*[contains(@resource-id,'button1') and @text='Yes']"));
        } else
            click(By.xpath("//*[contains(@resource-id,'cancel')]"));
    }

    public void clickOnTheInfoButton() {
        click(By.xpath("//*[contains(@resource-id,'info')]"));
    }

    public void clickOnTheSchedulesButton() {
        click(By.xpath("//*[contains(@resource-id,'general_schedules') and @text='Schedules']"));
    }

    public void clickOnTheOriginButton() {
        click(By.xpath("//*[contains(@resource-id,'general_origin') and @text='Origin']"));
    }

    public void clickOnTheDestinationButton() {
        click(By.xpath("//*[contains(@resource-id,'general_destination') and @text='Destination']"));
    }

    public void typeNewBarcodeNumber(String text) {
        if (text != null) {
            driver.findElement(By.id("checker_filter_field_id")).click();
            driver.findElement(By.id("checker_filter_field_id")).clear();
            driver.findElement(By.id("checker_filter_field_id")).sendKeys(text);
        }
    }

    public void clickOnTheCheckButton() {
        click(By.id("check_btn"));
    }

    public void clickOnTheBoxIconToCreateLU() {
        click(By.id("loader"));
    }

    public void selectLUFromDropDown() {
        click(By.xpath("//*[@text='Not Loaded']"));
    }

    public void clickOnTheSelectedSkidInTheDropDown() {
        click(By.xpath("//*[contains(@resource-id,'text1') and @text='1 - Pallet']"));
    }

    public void clickOnTheOKLabelButton() {
        click(By.id("ok_label_btn"));
    }

    public void swipeScreenDown() throws InterruptedException {
        Thread.sleep(3000);
        WebElement panel = driver.findElement(By.id("decor_content_parent"));
        Dimension dimension = panel.getSize();
        Double ScreenHeightStart = dimension.getHeight() * 0.7;
        int scrollStart = ScreenHeightStart.intValue();
        Double ScreenHeightEnd = dimension.getHeight() * 0.2;
        int scrollEnd = ScreenHeightEnd.intValue();

        new TouchAction(driver)
                .press(PointOption.point(0, scrollStart))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(0, scrollEnd))
                .release().perform();
    }

    public void swipeScreenUp() throws InterruptedException {
        Thread.sleep(3000);
        WebElement panel = driver.findElement(By.id("decor_content_parent"));
        Dimension dimension = panel.getSize();
        Double ScreenHeightStart = dimension.getHeight() * 0.2;
        int scrollStart = ScreenHeightStart.intValue();
        Double ScreenHeightEnd = dimension.getHeight() * 0.7;
        int scrollEnd = ScreenHeightEnd.intValue();

        new TouchAction(driver)
                .press(PointOption.point(0, scrollStart))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(0, scrollEnd))
                .release().perform();
    }
}
