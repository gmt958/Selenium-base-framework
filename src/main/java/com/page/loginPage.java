package com.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class loginPage {

    public static WebDriver driver;
    public static WebDriverWait wait;

    @FindBy(how= How.XPATH,using="//a[@href='https://www.adobe.com/index.html']")
    public static WebElement logo;


    public loginPage(WebDriver driver, WebDriverWait wait) {
        this.driver = driver;
        this.wait = wait;
        PageFactory.initElements(driver,this);
    }


}