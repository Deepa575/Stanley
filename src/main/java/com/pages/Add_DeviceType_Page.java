package com.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Add_DeviceType_Page {

    private WebDriver driver;
private By administrator = By.xpath("//button[text()=' Administration ']");
private By deviceType_link = By.xpath("//a[text()=' Device Type']");
private By addDeviceType_btn = By.xpath("//button[text()='Add Device Type ']");
private By deviceType_Txt = By.xpath("//label[text()='Device Type *']//following-sibling::input");
private By description_Txt = By.xpath("//label[text()='Description *']//following-sibling::textarea");
private By submit_btn = By.xpath("//button[text()=' Submit ']");
private By message_toaster = By.xpath("//*[@id=\"toast-container\"]/div/div");

    public Add_DeviceType_Page(WebDriver driver) {

        this.driver = driver;
    }


    public void clickOnAdministration(){
        driver.findElement(administrator).click();
    }
    public void clickOnDeviceType(){
        driver.findElement(deviceType_link).click();
    }

    public void clickOnAddDeviceType(){
        driver.findElement(addDeviceType_btn).click();
    }
    public void enterDeviceTypeDetails(String deviceType, String description){
        driver.findElement(deviceType_Txt).sendKeys(deviceType);
        driver.findElement(description_Txt).sendKeys(description);
    }
    public void clickOnSubmit(){
        driver.findElement(submit_btn).click();
    }

    public void verifyToasterMessage(String sMessage) throws InterruptedException {
       String successfullMessage = driver.findElement(message_toaster).getText();
       System.out.println(successfullMessage);
        Assert.assertEquals(sMessage,successfullMessage);
        Thread.sleep(5000);
    }
}
