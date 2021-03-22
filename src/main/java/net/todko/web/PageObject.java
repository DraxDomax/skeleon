package net.todko.web;

import org.openqa.selenium.support.PageFactory;

public class PageObject extends WebDriverFramework{

    public PageObject() {
        PageFactory.initElements(driver, this);
    }
}
