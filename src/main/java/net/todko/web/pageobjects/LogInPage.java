package net.todko.web.pageobjects;

import net.todko.web.Creds;
import net.todko.web.PageObject;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogInPage extends PageObject {
    @FindBy(id="user")
    private WebElement user;

    @FindBy(id="password")
    private WebElement password;

    @FindBy(xpath="//*[@id=\"login\"]")
    public WebElement logInBtn;

    @FindBy(xpath="/html/body/table/tbody/tr[1]/th[2]/table/tbody/tr[1]/td/font")
    public WebElement companyTitle;

    @FindBy(xpath="//*[@id=\"failed\"]")
    public WebElement failedLoginMsg;

    public StorePage logIn (String user, String pass) {
        enterUserName(user);
        enterPassword(pass);
        return submitCreds();
    }
    public StorePage logIn (Creds currentCreds) {
        return logIn(currentCreds.user, currentCreds.pass);
    }

    public LogInPage() {
        super();
    }

    public void enterUserName (String userName) {
        this.user.clear();
        this.user.sendKeys(userName);
    }
    public void enterPassword (String password) {
        this.password.clear();
        this.password.sendKeys(password);
    }
    public StorePage submitCreds() {
        logInBtn.click();
        return new StorePage();
    }
}
