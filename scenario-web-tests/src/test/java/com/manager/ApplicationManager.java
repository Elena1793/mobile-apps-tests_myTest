package com.manager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class ApplicationManager {
    WebDriver wd;

    public void start() {
        wd = new ChromeDriver();
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wd.manage().window().maximize();
        openSite("https://mfcdev.voxme.com/Account/Login");
        login("testuser4", "Testuser44");
    }

    public void stop() {
        wd.quit();
    }

    public void login(String userName, String password) {
        click(By.cssSelector("input#username"));
        type(By.cssSelector("input#username"), userName);
        type(By.cssSelector("input#password"), password);
        WebDriverWait wait = new WebDriverWait(wd, 25);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button#loginSubmit"))).click();
    }

    public void openSite(String url){
        wd.get(url);
    }

    public void click(By locator) {
        wd.findElement(locator).click();
    }

    public void waitForElement(long timeout, By locator) {
        WebDriverWait wait = new WebDriverWait(wd, timeout);
        wait.until(ExpectedConditions.presenceOfElementLocated(locator));
    }

    private boolean isElementPresent(By locator) {
        return wd.findElements(locator).size() > 0;
    }

    public void type(By locator, String text) {
        wd.findElement(locator).click();
        wd.findElement(locator).clear();
        wd.findElement(locator).sendKeys(text);
    }

    public void clickOnTheJobsGridField(){
        click(By.xpath("//a[@href=\"/Job/Grid\"]"));
    }

    public void clickOnTheCreateFileButton() {
        click(By.id("submitNewContact"));
    }

    public void selectAnApplicableBookingTypeAgent() {
        click(By.xpath("//*[@data-booking-type='Enum.BookingType.Agent']//a[@class='k-link']"));
    }

    public void selectAnApplicableBookingTypePrivate() {
        click(By.xpath("//*[@data-booking-type='Enum.BookingType.Private']//a[@class='k-link']"));
    }
    public void clickOnSourceDropDown() {
        click(By.xpath("//*[@aria-controls='prSource_listbox']"));
    }

    public void selectSource() {
        click(By.xpath("//ul[@id='prSource_listbox']/li"));
    }

    public void clickOnJobTypeDropDown() throws InterruptedException {
        click(By.xpath("//*[@aria-owns='prJobType_listbox']"));
        Thread.sleep(1000);
    }

    public void selectPrivateJobType() {
        waitForElement(15, By.xpath("//*[@id='prJobType_listbox']//*[contains(text(),'COMMERCIAL')]"));
        click(By.xpath("//li[@class='k-item'][contains(text(),'COMMERCIAL')]"));
    }

    public void clickFirstNameField() {
        type(By.xpath("//*[@id='pr-firstName']"), "Anton");
    }

    public void clickLastNameField() {
        type(By.xpath("//*[@id='pr-lastName']"), "Nakonechnyi");
    }

    public void clickEmailField() {
        type(By.xpath("//*[@id='pr-email']"), "anton150283@gmail.com");
    }

    public void clickPrimaryPhoneField() {
        type(By.xpath("//*[@id='pr-phone']"), "+972536405770");
    }

    public void clickByCreateButton() {
        click(By.xpath("//*[@id='submitCreate']"));
    }

    public void clickOnModeDropDown() {
        click(By.xpath("//*[@aria-owns='mode_listbox']"));
    }

    public void selectMode() {
        click(By.xpath("//ul[@id='mode_listbox']//*"));
    }

    public void clickOnTypeDropDown() {
        click(By.xpath("//*[@aria-owns='type_listbox']"));
    }

    public void selectType() {
        click(By.xpath("//ul[@id='type_listbox']//*"));
    }

    public void clickOnServiceDropDown() {
        click(By.xpath("//*[@aria-owns='service_listbox']"));
    }

    public void selectService() {
        click(By.xpath("//ul[@id='service_listbox']//*"));
    }

    public void clickOnOperationsButton() throws InterruptedException {
        Thread.sleep(10000);
        if(isElementPresent(By.xpath("//a[@key='ClientFileMenu_Transaction_ClientFileGrid_GET_Menu.ClientFile.Operations_']"))){
        click(By.xpath("//a[@key='ClientFileMenu_Transaction_ClientFileGrid_GET_Menu.ClientFile.Operations_']"));
        }else
            click(By.xpath("//a[contains(text(),'Operations')]"));
    }

    public void clickOnTheNewOperationButton() throws InterruptedException {
        Thread.sleep(10000);
        if(isElementPresent(By.xpath("//ul[@id='newOperation']"))) {
            click(By.xpath("//ul[@id='newOperation']"));
        }else
            click(By.xpath("//span[contains(text(),'New operation')]"));
    }

    public void clickOnAgentDropDown() {
        click(By.name("agAgent_input"));
     }

    public void selectAgent() {
        type(By.xpath("//*[@aria-owns='agAgent_listbox']"),"Anton Nakonechnyi");
    }

    public void clickOnAgentContactDropDown() throws InterruptedException {
        click(By.xpath("//*[@aria-controls='agAgentContact_listbox']"));
        Thread.sleep(1000);
    }

    public void selectAgentContact() throws InterruptedException {
        click(By.xpath("//li[contains(text(),'Anton Nakonechnyy')]"));
    }

    public void fillRefField() {
        type(By.xpath("//*[@id='agRef']"), "666666");
    }

    public void fillFirstNameTransfereeContactField() {
        type(By.xpath("//*[@aria-owns='ag-firstName_listbox']"), "John");
    }

    public void fillLastNameTransfereeContactField() {
        type(By.xpath("//*[@id='ag-lastName']"), "Connor");
    }

    public void fillEmailTransfereeContactField() {
        type(By.xpath("//*[@id='ag-email']"), "anton150283@gmail.com");
    }

    public void fillPrimaryPhoneTransfereeContactField() {
        type(By.xpath("//*[@id='ag-phone']"), "+972536405770");
    }

    public void clickOnAgentJobTypeDropDown() throws InterruptedException {
        click(By.xpath("//*[@aria-owns='agJobType_listbox']"));
        Thread.sleep(1000);
    }

    public void selectAgentJobType() {
        waitForElement(15, By.xpath("//*[@id='agJobType_listbox']//*[contains(text(),'COMMERCIAL')]"));
        click(By.xpath("//*[@id='agJobType_listbox']//*[contains(text(),'COMMERCIAL')]"));
    }

    public void clickOnSourceForAgentJobDropDown() throws InterruptedException {
        click(By.xpath("/*//*[@id='bookedSource']//../*//*[@class='k-input']"));
        Thread.sleep(1000);
    }

    public void selectSourceForAgentJob() {
        waitForElement(15, By.xpath("//*[@class='k-item'][contains(text(),'Call')]"));
        click(By.xpath("//*[@class='k-item'][contains(text(),'Call')]"));
    }

    public void clickOnCreateNewAddressButtonFrom() {
        click(By.xpath("//a[@id='newPlacefrom']"));
    }

    public void fillCompanyFieldFrom() {
        type(By.xpath("//*[@id='from-newPlaceCompany']"), "NewCompany");
    }

    public void fillStreet1FieldFrom() {
        type(By.xpath("//*[@id='from-newPlaceStreet1']"), "Zorge 18");
    }

    public void clickOnCountryDropDownFrom() {
        click(By.xpath("//span[@class='k-widget k-dropdown k-header dropdown dropdown_lg js-country']" +
                "//span[@class='k-dropdown-wrap k-state-default drop-invalid']" +
                "//span[@class='k-select']"));
    }

    public void selectCountryFrom() throws InterruptedException {
        click(By.xpath("//*[@id='from-newPlaceCountry-list']"));
        Thread.sleep(1000);
    }

    public void fillSityFieldFrom() {
        type(By.xpath("//*[@id='from-newPlaceCity']"),"Limb");
    }

    public void fillZIPFieldFrom() {
        type(By.xpath("//*[@id='from-newPlaceZIP']"),"8905678");
    }

    public void clickByCreateButtonFrom() {
        click(By.xpath("//*[@id='from-newPlaceSubmit']"));
    }

    public void clickOnCreateNewAddressButtonTo() {
        click(By.xpath("//a[@id='newPlaceto']"));
    }

    public void fillCompanyFieldTo() {
        type(By.xpath("//*[@id='to-newPlaceCompany']"), "MyNewCompany");
    }

    public void fillStreet1FieldTo() {
        type(By.xpath("//*[@id='to-newPlaceStreet1']"), "Zogg 127");
    }

    public void clickOnCountryDropDownTo() {
        click(By.xpath("//span[@class='k-widget k-dropdown k-header dropdown dropdown_lg js-country']" +
                "//span[@class='k-dropdown-wrap k-state-default drop-invalid']" +
                "//span[@class='k-select']"));
    }

    public void selectCountryTo() throws InterruptedException {
        click(By.xpath("//*[@id='to-newPlaceCountry_listbox']"));
        Thread.sleep(1000);
    }

    public void fillSityFieldTo() {
        type(By.xpath("//*[@id='to-newPlaceCity']"),"Kaceo");
    }

    public void fillZIPFieldTo() {
        type(By.xpath("//*[@id='to-newPlaceZIP']"),"8765098");
    }

    public void clickByCreateButtonTo() {
        click(By.xpath("//*[@id='to-newPlaceSubmit']"));
    }

    public void selectPickup() throws InterruptedException {
        Thread.sleep(3000);
        click(By.xpath("//li[@trans-type='Enum.TransactionType.Pickup']"));
    }

    public void selectWRin() throws InterruptedException {
        Thread.sleep(3000);
        click(By.xpath("//li[@trans-type='Enum.TransactionType.WarehouseReceiveIn']"));
    }

    public void selectWRout() throws InterruptedException {
        Thread.sleep(3000);
        click(By.xpath("//li[@trans-type='Enum.TransactionType.WarehouseOutload']"));
    }
}
