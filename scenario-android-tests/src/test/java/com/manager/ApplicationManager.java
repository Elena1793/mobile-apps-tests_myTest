package com.manager;

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

    public void clickOnTheEditInventoryButton() {
        click(By.id("editInventory"));
    }


    public void selectPickUpTransaction() {
        if (isElementPresent(By.xpath("//*[contains(@resource-id,'mf_type') and @text='Enum.TransactionType.Pickup']"))) {
            click(By.xpath("//*[contains(@resource-id,'mf_type') and @text='Enum.TransactionType.Pickup']"));
        } else
            click(By.xpath("//*[contains(@resource-id,'mf_type') and @text='Pickup']"));
    }
    //TODO
    public void addLabelToTheTransaction() {
    }

    public void clickOnTheOKButtonOnThePopUp() {
        waitForElement(25, (By.xpath("//*[contains(@resource-id,'button3') and @text='OK']")));
        click(By.xpath("//*[contains(@resource-id,'button3') and @text='OK']"));
    }

    public void clickOnTheAddPieceButton() {
        click(By.id("add_piece"));
    }

    public void addItemIntoNewPiece() {
        click(By.id("add_item_2"));
        click(By.id("search_text"));
        type(By.id("search_text"), "Cabinet");
        click(By.xpath("//*[contains(@resource-id,'item_name') and @text='Cabinet (4,00)']"));
    }

    public void returnToTheDiscoveryPage() throws InterruptedException{
        driver.pressKey(new KeyEvent().withKey(AndroidKey.BACK));
        Thread.sleep(1000);
    }

    public void clickOnTheReportInventoryButton() {
        click(By.id("reportInventory"));
    }

    public void swipeScreenDown() throws InterruptedException{
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

    public void swipeScreenUp() throws InterruptedException{
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
