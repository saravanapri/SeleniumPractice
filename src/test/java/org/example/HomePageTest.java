package org.example;

import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import srp.HomePage;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import static java.lang.Thread.sleep;

public class HomePageTest {
    private WebDriver driver;
    private WebDriverWait wait;
    private HomePage homePage;
    private Actions act;
    private static final Logger log = Logger.getLogger(HomePageTest.class.getName());

    @BeforeTest
    public void setBrowser() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.ebay.com/");
        wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        homePage = new HomePage(driver);
        act=new Actions(driver);
        log.info("Browser started");
    }

    @Test(priority = 2)
    public void footerElementsTest() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("s0-1-0-53-1-2-5-15-0[1]-10-@match-media-0-@ebay-carousel-list")));
        List<String> footerElements = homePage.getFooterNav().getElements();
        Assert.assertFalse(footerElements.isEmpty(), "Footer is empty");
        Assert.assertEquals(footerElements.size(), 7, "Number of elements is not equal to 7");
        log.info(footerElements.toString());
        log.info(String.valueOf(homePage.getFooterNav().linkCount()));

    }

    @Test(priority = 1)
    public void headerElementsTest() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("vl-flyout-nav__container")));
        List<String> HeaderElements = homePage.getHeaderNav().getElements();
        Assert.assertFalse(HeaderElements.isEmpty(), "header is empty");
        Assert.assertEquals(HeaderElements.size(), 12, "Number of elements is not equal to 12");
        log.info(HeaderElements.toString());
        log.info(String.valueOf(homePage.getHeaderNav().linkCount()));
    }
    @Test(priority =3)
    public void actionTest() throws InterruptedException {
        WebElement link = wait.until(ExpectedConditions.elementToBeClickable(By.linkText("Electronics")));
        act.moveToElement(link).click().perform();
        log.info(driver.getTitle());
        //contextClick() -> rightclick, dragAndDrop() -> , doubleClick()
    }
    @Test(priority = 4)
    public void newWindowTest()
    {
        WebElement window =driver.findElement(By.linkText("Motors"));
        act.keyDown(Keys.CONTROL).click(window).keyUp(Keys.CONTROL).perform();
        List<String> ids=new ArrayList<>(driver.getWindowHandles());
        driver.switchTo().window(ids.get(1));
        driver.switchTo().newWindow(WindowType.WINDOW);
        driver.get("https://www.amazon.in/");
        log.info(driver.getTitle());

    }


    @AfterTest
    public void quit() {
        driver.close();
        log.info("Browser closed");
    }
}
