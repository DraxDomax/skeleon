package net.todko.web;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class WebDriverFramework {
    public static final int DEFAULT_LATENCY = 5;
    public static final String CONF_KEY_CHROME = "webdriver.chrome.driver";
    public static final String CONF_VALUE_CHROME = "bin/chromedriver.exe";

    public static WebDriver driver;

    public static WebDriver setUpChrome() {
        System.setProperty(WebDriverFramework.CONF_KEY_CHROME, WebDriverFramework.CONF_VALUE_CHROME);

        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(WebDriverFramework.DEFAULT_LATENCY, TimeUnit.SECONDS);
        driver.manage().window().maximize();

        return driver;
    }

    public static void tearDown() {
        driver.manage().deleteAllCookies();
        driver.quit();
    }

    public static void checkDisplayed(WebElement webElement) {
        if (!webElement.isDisplayed()) throw new AssertionError("Element not displayed: " + webElement.getText());
    }
}
