import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class CreateNewJobTest {
    WebDriver wd;

    @BeforeClass
    public void setUp() {
        wd = new ChromeDriver();
        wd.get("https://mfcdev.voxme.com/Account/Login");
        wd.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        wd.manage().window().maximize();
    }

    @Test
    public void login(){
        WebDriverWait wait = new WebDriverWait(wd, 25);
        wait.until(ExpectedConditions.elementToBeClickable(By.cssSelector("button#loginSubmit")));
        wd.findElement(By.cssSelector(""));
    }

    @AfterClass
    public void tearDown(){
        wd.quit();
    }
}

