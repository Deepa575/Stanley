package com.vassarlabs.stanley.pages;

import static org.testng.Assert.assertEquals;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.Activity;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;

public class StanleyLogin_Page {
	
	private AndroidDriver driver;

	public StanleyLogin_Page() {

	}

	private By terms_and_conditions = By.xpath("//android.widget.TextView[@text='Terms and Conditions']");
	private By checkbox = By.id("com.stanleyaccesstechnologies.iqtoolbox:id/checkbox_accept_term");
	
	private By EmailAddress_txt = By.xpath("//android.widget.EditText[@text='Email address']");
	private By Password_txt = By.xpath("//android.widget.EditText[@text='Password']");
	private By Login_btn = By.xpath("//android.widget.Button[@text='LOGIN']");
	private By continue_btn = By.xpath("//android.widget.Button[@text='Continue']");
	private By eye_icon = By.className("android.widget.ImageButton");

	public StanleyLogin_Page(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	public void open_the_stanley_iq_toolbox_app() throws InterruptedException {
		Thread.sleep(2000);

		MobileElement element = (MobileElement) driver.findElement(terms_and_conditions);
		String elText = element.getText();

		assertEquals(elText, "Terms and Conditions", "App Has Opened Successfully");

	}

	public void accept_the_terms_and_conditions() throws InterruptedException {
		
		
		Thread.sleep(5000);

		(new TouchAction(driver)).press(PointOption.point(508, 1836))
				.waitAction(WaitOptions.waitOptions(Duration.ofMillis(100))).moveTo(PointOption.point(504, 645))
				.perform();
		(new TouchAction(driver)).press(PointOption.point(508, 1836))
				.waitAction(WaitOptions.waitOptions(Duration.ofMillis(100))).moveTo(PointOption.point(504, 645))
				.release().perform();
		(new TouchAction(driver)).press(PointOption.point(508, 1836))
				.waitAction(WaitOptions.waitOptions(Duration.ofMillis(100))).moveTo(PointOption.point(504, 645))
				.release().perform();
		(new TouchAction(driver)).press(PointOption.point(508, 1836))
				.waitAction(WaitOptions.waitOptions(Duration.ofMillis(100))).moveTo(PointOption.point(504, 645))
				.release().perform();
		(new TouchAction(driver)).press(PointOption.point(508, 1836))
				.waitAction(WaitOptions.waitOptions(Duration.ofMillis(100))).moveTo(PointOption.point(504, 645))
				.release().perform();
		(new TouchAction(driver)).press(PointOption.point(508, 1836))
				.waitAction(WaitOptions.waitOptions(Duration.ofMillis(100))).moveTo(PointOption.point(504, 645))
				.release().perform();
		(new TouchAction(driver)).press(PointOption.point(508, 1836))
				.waitAction(WaitOptions.waitOptions(Duration.ofMillis(100))).moveTo(PointOption.point(504, 645))
				.release().perform();
		(new TouchAction(driver)).press(PointOption.point(508, 1836))
				.waitAction(WaitOptions.waitOptions(Duration.ofMillis(100))).moveTo(PointOption.point(504, 645))
				.release().perform();
		(new TouchAction(driver)).press(PointOption.point(508, 1836))
				.waitAction(WaitOptions.waitOptions(Duration.ofMillis(100))).moveTo(PointOption.point(504, 645))
				.release().perform();
		
	//driver.startActivity(new Activity("",""));

		driver.findElement(checkbox).isDisplayed();
		driver.findElement(checkbox).click();
		driver.findElement(continue_btn).isDisplayed();
		driver.findElement(continue_btn).click();

	}

	public void enter_username_and_password_in_login_screen(String username, String password)
			throws InterruptedException {

		driver.findElement(EmailAddress_txt).click();
		Thread.sleep(100);
		driver.findElement(EmailAddress_txt).sendKeys(username);
		driver.findElement(Password_txt).click();
		Thread.sleep(100);
		driver.findElement(Password_txt).sendKeys(password);
		driver.hideKeyboard();
		driver.findElement(eye_icon).isDisplayed();
		driver.findElement(eye_icon).click();
		driver.findElement(eye_icon).click();

	}

	public void click_on_login_button() {
		
		driver.findElement(Login_btn).isDisplayed();
		driver.findElement(Login_btn).click();
		

	}

}
