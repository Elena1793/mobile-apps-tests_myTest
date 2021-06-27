package com.inventory.manager;

import com.google.common.io.Files;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.android.nativekey.KeyEvent;
import io.appium.java_client.touch.LongPressOptions;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import org.openqa.selenium.*;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static io.appium.java_client.touch.WaitOptions.waitOptions;
import static io.appium.java_client.touch.offset.ElementOption.element;
import static io.appium.java_client.touch.offset.PointOption.point;
import static java.time.Duration.ofSeconds;

public class ApplicationManager {

    public AndroidDriver driver;

    public void start() throws MalformedURLException {
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("platformName", "Android");
        //capabilities.setCapability("deviceName", "emulator-5554");                              //emulator for Android
        //capabilities.setCapability("deviceName", "CB5A21NP7A");                                 //tablet Sony Xperia Z3
        capabilities.setCapability("deviceName", "BH90015L8Z");                 //phone Sony Xperia XZ1
        capabilities.setCapability("platformVersion", "9");                     //phone Sony Xperia XZ1
        //capabilities.setCapability("platformVersion", "8");                                     //emulator for Android
        //capabilities.setCapability("platformVersion", "6");                                     //tablet Sony Xperia Z3
        capabilities.setCapability("appPackage", "com.voxme.inventory.tablet");
        capabilities.setCapability("appActivity", "com.voxme.inventory.ui.StartupActivity");
        capabilities.setCapability("noReset", "true");
        capabilities.setCapability("unlockType", "pin");
        capabilities.setCapability("unlockKey", "9999");
        //capabilities.setCapability("unlockKey", "9955");
        capabilities.setCapability("app", "C:/Tools/VoxmeInventory-Redesigned-v11.4_Build_642.apk");
        capabilities.setCapability("sauceLabsImageInjectionEnabled", true);

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
    public void attachPhotoFromCamera() throws InterruptedException {
        click(By.id("article_photo_btn"));
        if (isElementPresent(By.xpath("//android.widget.FrameLayout[@content-desc=\"Camera key\"]/android.widget.ImageView"))) {
            click(By.xpath("//android.widget.FrameLayout[@content-desc=\"Camera key\"]/android.widget.ImageView"));
        } else
            click(By.xpath("//*[contains(@resource-id,'NONE') and @text='Shutter']"));
            //click(By.xpath("//*[contains(@resource-id,'okay') and @text='OK']"));
        Thread.sleep(3000);
    }

    public void attachPhotoFromGallery() {
        click(By.id("article_img_gallery_btn"));
        click(By.xpath("//*[contains(@resource-id,'icon_thumb')]"));
        //click((By.xpath("//*[contains(@resource-id,'date') and @text='Dec 3, 2019']")));
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
        if (isElementPresent(By.xpath("//*[@content-desc='Navigate up']"))) {
            click(By.xpath("//*[@content-desc='Navigate up']"));
            Thread.sleep(1000);
        } else
            driver.findElement(By.xpath("//*[@content-desc='Перейти вверх']")).click();
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
        //click(By.xpath("//*[contains(@resource-id,'mf_name') and @text='Anton Nakonechnyi']"));

    }

    public void downloadFoundedInventory() {
        click(By.id("download_mf"));
    }

    private boolean isElementPresent(By locator) {
        return driver.findElements(locator).size() > 0;
    }

    public void touchOnTheCreatedInventoryOnDiscovery() {
        waitForElement(2000, By.xpath("//*[contains(@resource-id,'name') and @text='Anton Nakonechnyi']"));
        TouchAction touch = new TouchAction(driver);
        WebElement el = driver.findElement(By.xpath("//*[contains(@resource-id,'name') and @text='Anton Nakonechnyi']"));
        touch.longPress(LongPressOptions.longPressOptions().withElement(element(el)).withDuration(Duration.ofMillis(2000)))
                .release()
                .perform();
    }

    public void clickOnTheAddLabelsField() {
        click(By.xpath("//*[contains(@resource-id,'title') and @text='Add Labels']"));
    }

    public void typeQuantityOnTheAddField() {
        type(By.id("add_label_no"), "2");
    }

    public void clickOnTheCheckButtonOnTheDiscovery() {
        click(By.id("checkInventory"));
    }

    public void clickOnTheEditInventoryButton() {
        click(By.id("editInventory"));
    }

    public void clickOnTheAddPieceButton() {
        click(By.id("fab_add"));
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
                ".scrollIntoView(" + "new UiSelector().text(\"4 Cubes\"));").click();
    }

    public void selectPBOForNewPiece() {
        click(By.id("piece_pbo"));
    }

    public void addItemIntoNewPiece() {
        click(By.id("add_item"));
        click(By.id("search_text"));
        type(By.id("search_text"), "Cabinet");
        click(By.xpath("//*[contains(@resource-id,'item_name') and @text='Cabinet (4.00)']"));
    }

    public void showParametersOfTheItem() {
        click(By.id("item_name"));
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
        click(By.id("piece_item_condition"));
        click(By.xpath("//*[contains(@resource-id,'text1') and @text='Good']"));
    }

    public void addCommentToTheNewItem() {
        click(By.id("detail_comment"));
        type(By.id("detail_comment"), "CommentTEST");
    }

    public void addLocation() {
        click(By.id("add_location_btn"));
        click(By.xpath("//*[contains(@resource-id,'text1') and @text='Location1']"));
        click(By.xpath("//*[contains(@resource-id,'button1') and @text='OK']"));
    }

    public void addCondition() {
        click(By.id("add_condition_btn"));
        click(By.xpath("//*[contains(@resource-id,'text1') and @text='Broken']"));
        click(By.xpath("//*[contains(@resource-id,'button1') and @text='OK']"));
    }

    public void selectRoomWithItem() {
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()"
                + ".resourceId(\"com.voxme.inventory.tablet:id/roomSummaryList\")).scrollIntoView("
                + "new UiSelector().text(\"Attic/Loft\"));").click();
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
                + "new UiSelector().text(\"Floors\"));").click();
    }

    public void clickOnTheSelectConditionButtonOfPropertyBeforePacking() {
        click(By.xpath("//*[contains(@resource-id,'text1') and @text='Good']"));
        click(By.xpath("//*[contains(@resource-id,'button1') and @text='OK']"));
    }

    public void clickOnPropertyConditionsButtonBeforePacking() {
        click(By.xpath("//*[contains(@resource-id,'show_property') and @text='...']"));
    }

    public void clickOnPropertyConditionsFieldAfterPacking() {
        //waitForElement(10, By.xpath("//*[contains(@text, 'After Packing')]"));
        //click(By.xpath("//*[contains(@text, 'After Packing')]"));
        click(By.xpath("//*[contains(@resource-id,'tabsText') and @text='After Packing']"));
    }

    public void selectPropertyAfterPacking() {
        driver.findElementByAndroidUIAutomator("new UiScrollable(new UiSelector()"
                + ".resourceId(\"com.voxme.inventory.tablet:id/prop_name\")).scrollIntoView("
                + "new UiSelector().text(\"Floors\"));").click();
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
            Thread.sleep(3000);
        } else
            //click(By.xpath("//*[@content-desc='Ещё']"));
        click(By.xpath("//*[contains(@resource-id,'submenu') and @text='Inventory List']")); // for Polina's device
    }
    //TODO
    public void clickOnTheAppliances() {
        click(By.xpath("//*[contains(@resource-id,'submenu') and @text='Appliances']")); // for Polina's device
    }

    public void clickOnThePackers() {
        click(By.xpath("//*[contains(@resource-id,'submenu') and @text='Packers']"));
    }

    public void clickOnTheAddSkidButton() {
        click(By.xpath("//*[contains(@resource-id, 'add_skid') and @text='+']"));
    }

    public void clickOnTheSelectSkidDropDown() {
        click(By.id("skidType"));
    }

    public void selectContainer() {
        click(By.xpath("//*[contains(@resource-id,'text1') and @text='Container 40 ft']"));
    }

    public void selectLiftvan() {
        click(By.xpath("//*[contains(@resource-id,'text1') and @text='Liftvan']"));
    }

    public void clickOnTheLoadSkidButton() {
        waitForElement(10, By.xpath("//*[contains(@resource-id,'load_skid') and @text='Load']"));
        click(By.xpath("//*[contains(@resource-id,'load_skid') and @text='Load']"));
    }

    public void clickOnTheCartonsSummary() {
        click(By.xpath("//*[contains(@resource-id,'submenu') and @text='Cartons Summary']"));
    }

    public void clickOnTheAdditionalMaterials() {
        click(By.xpath("//*[contains(@resource-id,'submenu') and @text='Additional Materials']"));
    }

    public void clickOnTheServices() {
        click(By.xpath("//*[contains(@resource-id,'submenu') and @text='Services']"));
    }

    public void clickOnTheAdditionalInfo() {
        click(By.xpath("//*[contains(@resource-id,'submenu') and @text='Additional Info']"));
    }

    public void clickOnTheDocuments() {
        //click(By.xpath("//*[contains(@resource-id,'title') and @text='Documents']"));
        click(By.xpath("//*[contains(@resource-id,'submenu') and @text='Documents']"));
    }

    public void clickOnTheAddDocumentButton() {
        //click(By.xpath("//*[contains(@resource-id,'add_doc') and @text='+']"));
        click(By.id("add_doc"));
    }

    public void fillDocumentNameField() {
        click(By.id("document_name"));
        type(By.id("document_name"), "testFile");
    }

    public void returnToTheDiscoveryPage() throws InterruptedException {
        driver.pressKey(new KeyEvent().withKey(AndroidKey.BACK));
        Thread.sleep(1000);
    }

    public void clickOnTheReportInventoryButton() throws InterruptedException {
        if (isElementPresent(By.id("reportInventory"))) {
            click(By.id("reportInventory"));
        } else
            click(By.id("fab_share"));
        Thread.sleep(5000);
    }

    public void clickOnTheClientShipperButton() throws InterruptedException {
        if (isElementPresent(By.xpath("//*[contains(@resource-id,'sign_survey') and @text='Sign']"))) {
            click(By.xpath("//*[contains(@resource-id,'sign_survey') and @text='Sign']"));
        } else
            click(By.xpath("//*[contains(@resource-id,'sign_survey') and @text='Re-Sign']"));
        Thread.sleep(5000);
    }

    public void createSignature() throws InterruptedException {
        //click(By.xpath("//*[contains(@resource-id, 'signature_view')]"));
            Thread.sleep(3000);
            new TouchAction(driver)
                    .press(PointOption.point(795, 901))
                    .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                    .moveTo(PointOption.point(277, 912))
                    .release().perform();
    }

    public void clickOnTheForemanDriverButton() throws InterruptedException {
        if (isElementPresent(By.xpath("//*[contains(@resource-id,'driver_sign_survey') and @text='Sign']"))) {
            click(By.xpath("//*[contains(@resource-id,'driver_sign_survey') and @text='Sign']"));
        } else
            click(By.xpath("//*[contains(@resource-id,'driver_sign_survey') and @text='Re-Sign']"));
        Thread.sleep(5000);
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
    public void attachPhotoConditions() throws InterruptedException {
        waitForElement(25,(By.id("add_photo")));
        click(By.id("add_photo"));
        if (isElementPresent(By.xpath("//android.widget.FrameLayout[@content-desc=\"Camera key\"]/android.widget.ImageView"))) {
            click(By.xpath("//android.widget.FrameLayout[@content-desc=\"Camera key\"]/android.widget.ImageView"));
        } else
            //click(By.xpath("//*[contains(@resource-id,'NONE') and @text='Shutter']"));
        click(By.xpath("//*[contains(@resource-id,'okay') and @text='OK']")); // for Polina's device
        Thread.sleep(10000);
    }
    //TODO
    public void attachPhotoToTheNewSkid() throws InterruptedException {
        click(By.id("skid_photo_btn"));
        if (isElementPresent(By.xpath("//android.widget.FrameLayout[@content-desc=\"Camera key\"]/android.widget.ImageView"))) {
            click(By.xpath("//android.widget.FrameLayout[@content-desc=\"Camera key\"]/android.widget.ImageView"));
        } else
            //click(By.xpath("//*[contains(@resource-id,'NONE') and @text='Shutter']"));
        click(By.xpath("//*[contains(@resource-id,'okay') and @text='OK']")); // for Polina's device
        Thread.sleep(5000);
    }
    //TODO
    public void attachPhotoToTheDocumentSection() throws InterruptedException {
        click(By.id("add_photo_btn"));
        if (isElementPresent(By.xpath("//android.widget.FrameLayout[@content-desc=\"Camera key\"]/android.widget.ImageView"))) {
            click(By.xpath("//android.widget.FrameLayout[@content-desc=\"Camera key\"]/android.widget.ImageView"));
        } else
            //click(By.xpath("//*[contains(@resource-id,'NONE') and @text='Shutter']"));
        click(By.xpath("//*[contains(@resource-id,'okay') and @text='OK']")); // for Polina's device
        Thread.sleep(5000);
    }

    public void attachPhotoToTheDocumentSectionFromGallery() throws InterruptedException {
        click(By.id("doc_img_gallery_btn"));
        click((By.xpath("//*[contains(@resource-id,'date') and @text='Dec 3, 2019']")));
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

    public void clickOnTheTruckIconToCreateLU() {
        click(By.id("loader"));
    }

    public void selectLUFromDropDown() {
        //click(By.xpath("//*[@text='Not Loaded']"));
        if (isElementPresent(By.xpath("//*[@text='Not Loaded']"))) {
            click(By.xpath("//*[@text='Not Loaded']"));
        } else
            click(By.xpath("//*[contains(@resource-id,'skidSpinner') and @text='1 - Container 40 ft']"));

    }

    public void clickOnTheSelectedSkidInTheDropDown() {
        click(By.xpath("//*[contains(@resource-id,'text1') and @text='1 - Pallet']"));
    }

    public void clickOnTheSelectedSkidInTheDropDownContainer() {
        click(By.xpath("//*[contains(@resource-id,'text1') and @text='1 - Container 40 ft']"));
    }

    public void clickOnTheSelectedSkidInTheDropDownLiftvan() {
        click(By.xpath("//*[contains(@resource-id,'text1') and @text='2 - Liftvan']"));
    }

    public void clickOnTheOKLabelButton() {
        click(By.id("ok_label_btn"));
    }

    public void clickOnTheOKLabelButtonSkid() {
        click(By.id("ok_label_btn1"));
    }

    public void swipeScreenDownMenu() throws InterruptedException {
        Thread.sleep(3000);
        WebElement panel = driver.findElement(By.id("hamburger_view"));
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

    public void swipeSkidScreenUp() throws InterruptedException {
        Thread.sleep(3000);
        WebElement panel = driver.findElement(By.id("simpleItemsList"));
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

    public void swipeScreenToTheLeft() throws InterruptedException {
        WebElement panel = driver.findElement(By.id("pager"));
        Dimension dimension = panel.getSize();

        int anchor = panel.getSize().getHeight() / 2;

        Double ScreenWidthStart = dimension.getWidth() * 0.9;
        int scrollStart = ScreenWidthStart.intValue();

        Double ScreenWidthEnd = dimension.getWidth() * 0.1;
        int scrollEnd = ScreenWidthEnd.intValue();

        new TouchAction(driver)
                .press(point(scrollStart, anchor))
                .waitAction(waitOptions(ofSeconds(1)))
                .moveTo(point(scrollEnd, anchor))
                .release().perform();

        Thread.sleep(3000);
    }

    public void swipeScreenToTheRight() throws InterruptedException {
        WebElement panel = driver.findElement(By.id("pager"));
        Dimension dimension = panel.getSize();

        int anchor = panel.getSize().getHeight() / 2;

        Double ScreenWidthStart = dimension.getWidth() * 0.1;
        int scrollStart = ScreenWidthStart.intValue();

        Double ScreenWidthEnd = dimension.getWidth() * 0.9;
        int scrollEnd = ScreenWidthEnd.intValue();

        new TouchAction(driver)
                .press(point(scrollStart, anchor))
                .waitAction(waitOptions(ofSeconds(1)))
                .moveTo(point(scrollEnd, anchor))
                .release().perform();

        Thread.sleep(3000);
    }

    public void clickToAddSkidButton() {
        click(By.id("fab_skid_add"));
    }

    public void clickToTheSkidContentButton() {
        click(By.id("skid_contents_button"));
    }

    public void clickToTheLoadSkidButton() {
        click(By.id("load_skid"));
    }

    public void clickToTheSkidOKButton() {
        click(By.id("skid_ok_button"));
    }

    public void clickToTheInspectionInfoButton() {
        click(By.xpath("//*[contains(@resource-id,'inspection_info') and @text='Inspection Info']"));
    }

    public void clickOnTheMenuButton() {
        waitForElement(25,(By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']")));
        click(By.xpath("//android.widget.ImageButton[@content-desc='Navigate up']"));
    }

    public void clickToTheGeneralInfo() {
        click(By.xpath("//*[contains(@resource-id,'submenu') and @text='General Info']"));
    }

    public void clickOnTheSummaries() {
        click(By.xpath("//*[contains(@resource-id,'submenu') and @text='Summaries']"));
    }


    public void clickOnTheAdditionalServicesButton() {
        click(By.xpath("//*[contains(@resource-id,'submenu') and @text='Additional Services']"));
    }

    public void clickOnTheBackToJobListButton() {
        click(By.xpath("//*[contains(@resource-id,'submenu') and @text='Back to Job List']"));
    }

    public void clickToTheSignAndSendButton() {
        click(By.xpath("//*[contains(@resource-id,'submenu') and @text='Sign And Send']"));
    }

    public void addDictionaryFile() throws IOException {
        driver.pushFile(
                "//This PC/Xperia Z3 Tablet Compact/Internal storage/Android/data/com.voxme.inventory.tablet/files/Dictionary.xml",
                new File("C:/Tools/Dictionary.xml"));
    }

    public void addConfigurationFile() throws IOException {
        driver.pushFile(
                "//This PC/Xperia Z3 Tablet Compact/Internal storage/Android/data/com.voxme.inventory.tablet/files/Configuration.xml",
                new File("C:/Tools/Configuration.xml"));
    }

    public void openServiceList() {
        click(By.xpath("//*[contains(@resource-id,'group_name') and @text='Group3-US']"));
    }

    public void addContextText() {
        click(By.id("item_quantity"));
        type(By.id("item_quantity"), "ContextTEST");
    }

    public void addValueFromList() {
        click(By.xpath("//*[contains(@resource-id,'item_value') and @text='Tap to select value']"));
        if (isElementPresent(By.xpath("//*[contains(@resource-id,'text1') and @text='service1']"))) {
            click(By.xpath("//*[contains(@resource-id,'text1') and @text='service1']"));
        } else
            click(By.xpath("//*[contains(@resource-id,'text1') and @text='value1']"));
    }

    public void attachSignature() throws InterruptedException {
        click(By.id("signature_view"));
        Thread.sleep(3000);
        new TouchAction(driver)
                .press(PointOption.point(795, 901))
                .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
                .moveTo(PointOption.point(277, 912))
                .release().perform();
    }

    public void attachPhotoFromCameraToService() throws InterruptedException {
        click(By.id("photo_thumbnail"));
        if (isElementPresent(By.xpath("//android.widget.FrameLayout[@content-desc=\"Camera key\"]/android.widget.ImageView"))) {
            click(By.xpath("//android.widget.FrameLayout[@content-desc=\"Camera key\"]/android.widget.ImageView"));
        } else
            click(By.xpath("//*[contains(@resource-id,'NONE') and @text='Shutter']"));
        //click(By.xpath("//*[contains(@resource-id,'okay') and @text='OK']"));
        Thread.sleep(3000);

    }

    public void openFirstPropertiesList() {
        click(By.xpath("//*[contains(@resource-id,'group_name') and @text='Group1-US']"));
    }

    public void addQuestionText() {
        click(By.xpath("//*[contains(@resource-id,'item_value') and @text='Tap to edit']"));
        type(By.id("value_edit"), "QuestionTEST");

    }

    public void clickOnTheOKButton() {
        click(By.xpath("//*[contains(@resource-id,'button1') and @text='OK']"));
    }

    public void openSecondPropertiesList() {
        click(By.xpath("//*[contains(@resource-id,'group_name') and @text='Lena_GroupNameTransaction-US']"));
    }

    public void selectAnAction() {
        click(By.xpath("//*[contains(@resource-id,'text1') and @text='New Inventory']"));
    }
}
