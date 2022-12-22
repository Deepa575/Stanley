package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class Login_Page {

    private WebDriver driver;
    private By userName_Txt = By.id("username");
    private By password_Txt = By.id("password");
    private By signin_Btn = By.id("kc-login");
    private By home_button = By.xpath("//button[text()=' Home']");

    public Login_Page(WebDriver driver) {
        this.driver = driver;
    }

    public void enterUsername(String Username) {

        driver.findElement(userName_Txt).sendKeys(Username);
    }

    public void enterPassword(String Password) {
        driver.findElement(password_Txt).sendKeys(Password);

    }

    public void clickOnSignin() {
        driver.findElement(signin_Btn).click();

    }


    public void verifyTheLogin(){

        driver.findElement(home_button).isDisplayed();
    }
}