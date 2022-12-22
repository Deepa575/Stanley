package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class AddUser_Page {
    private WebDriver driver;

    private By userMGMT = By.xpath("//button[text()=' User Management ']");
    private By users_link = By.xpath("//a[text()=' Users']");
    private By addUser_btn = By.xpath("//button[text()=' Add User ']");
    private By email_txt = By.xpath("//input[@placeholder='Email']");
    private By firstName_txt = By.name("firstName");
    private By lastName_txt = By.name("lastName");
    private By phone_txt = By.id("phone");
    private By userName_txt = By.id("//input[@placeholder='Enter User Name']");
    private By customers_select = By.id("customers");
    private By add_btn = By.xpath("//button[text()='Add']");

    public AddUser_Page(WebDriver driver) {
        this.driver = driver;
    }


}
