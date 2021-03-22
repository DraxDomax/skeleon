package net.todko.web.pageobjects;

import net.todko.web.PageObject;
import net.todko.web.WebDriverFramework;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class StorePage extends PageObject {
    @FindBy(xpath="//*[@id=\"logout\"]")
    public WebElement logOutBtn;

    @FindBy(xpath="/html/body/table/tbody/tr[2]/td[1]/a/img")
    public WebElement pencil;

    @FindBy(xpath="//*[@id=\"tyCell\"]")
    public WebElement thankYou;


    public void buyPencil () {
        pencil.click();
    }

    public LogInPage logOut () {
        this.logOutBtn.click();
        return new LogInPage();
    }

    public void buyPerforatorPosition(int position) {
        driver.switchTo().frame("frameperf");
        String perfXpath = "/html/body/a[" + position + "]/img";
        WebElement perforator = driver.findElement(By.xpath(perfXpath));
        perforator.click();
    }
    public void answerBuyAlert(boolean accept) {
        Alert alert = driver.switchTo().alert();
        if (accept) {alert.accept();} else {alert.dismiss();}
        driver.switchTo().parentFrame();
    }
}
