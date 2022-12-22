package com.vassarlabs.stanley.pages;

import java.awt.event.KeyEvent;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.support.PageFactory;

import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.nativekey.AndroidKey;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.touch.WaitOptions;
import io.appium.java_client.touch.offset.PointOption;
import setups.Util;

public class CIUConfigure_Page {
	private AndroidDriver driver;

	@AndroidFindBy(id = "com.stanleyaccesstechnologies.iqtoolbox:id/button_menu")
	private MobileElement Menu;

	@AndroidFindBy(id = "com.stanleyaccesstechnologies.iqtoolbox:id/imageViewIcon")
	private MobileElement support_tools_dropdown;

	@AndroidFindBy(xpath = "//android.widget.TextView[@text='iQ Connect']")
	private MobileElement IQConnect;

	@AndroidFindBy(id = "com.stanleyaccesstechnologies.iqtoolbox:id/btn_ciu_configure")
	private MobileElement CIU_Configure_btn;

	@AndroidFindBy(id = "com.stanleyaccesstechnologies.iqtoolbox:id/iv_customer_name_drop_down")
	private MobileElement customer_name_drop_down;
	
	@AndroidFindBy(id = "com.stanleyaccesstechnologies.iqtoolbox:id/iv_store_id_drop_down")
	private MobileElement store_id_drop_down;
	
	@AndroidFindBy(id = "com.stanleyaccesstechnologies.iqtoolbox:id/iv_door_id_drop_down")
	private MobileElement door_id_drop_down;
	
	@AndroidFindBy(id = "com.stanleyaccesstechnologies.iqtoolbox:id/iv_door_type_drop_down")
	private MobileElement door_type_drop_down;
	
	@AndroidFindBy(id = "com.stanleyaccesstechnologies.iqtoolbox:id/iv_door_location_drop_down")
	private MobileElement door_location_drop_down;
	
	@AndroidFindBy(id = "com.stanleyaccesstechnologies.iqtoolbox:id/iv_dcu_model_drop_down")
	private MobileElement dcu_model_drop_down;
	
	@AndroidFindBy(id = "com.stanleyaccesstechnologies.iqtoolbox:id/et_dcu_serial_num")
	private MobileElement dcu_serial_num;
	
	@AndroidFindBy(id = "com.stanleyaccesstechnologies.iqtoolbox:id/et_ciu_serial_num")
	private MobileElement ciu_serial_num;

	@AndroidFindBy(id = "com.stanleyaccesstechnologies.iqtoolbox:id/iv_door_profile_drop_down")
	private MobileElement door_profile_drop_down;

	@AndroidFindBy(id = "com.stanleyaccesstechnologies.iqtoolbox:id/iv_wifi_type")
	private MobileElement wifi_type;


	public CIUConfigure_Page(AndroidDriver driver) {
		this.driver = driver;
		PageFactory.initElements(new AppiumFieldDecorator(driver), this);
	}

	public void application_has_to_open() {

	}

	public void click_on_the_menu_and_select_iq_connect() throws InterruptedException {

		Thread.sleep(2000);
		Menu.click();
		support_tools_dropdown.click();
		IQConnect.click();

	}

	public void click_on_ciu_configure_button() {

		CIU_Configure_btn.click();

	}


	public void enter_wifi_configure_screen(String customername, String storeid, String doorid, String doortype,
			String doorlocation, String DCUmodel, String DCUserialno, String CIUserialno, String doorprofile,
			String WIFISSID) throws InterruptedException {

		Thread.sleep(5000);

		//driver.findElement(MobileBy.xpath("//android.widget.EditText[@text='Select customer name']")).click();
		//driver.findElement(MobileBy.xpath("//android.widget.EditText[@text='Select customer name']")).sendKeys(customername);
		
		customer_name_drop_down.click();
		Thread.sleep(100);
        TouchAction touchAction = new TouchAction(driver);
        touchAction.tap(PointOption.point(504, 771))
        .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
        .perform();
        
        Thread.sleep(3000);
		
        store_id_drop_down.click();
		
        Thread.sleep(1000);
        new TouchAction(driver);
        touchAction.tap(PointOption.point(508, 1191))
        .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
        .perform();
		
        Thread.sleep(3000);
        door_id_drop_down.click();
        new TouchAction(driver);
        touchAction.tap(PointOption.point(515, 1380))
        .waitAction(WaitOptions.waitOptions(Duration.ofSeconds(1)))
        .perform();
        Thread.sleep(1000);
		
        //doortype
        
        door_type_drop_down.click();
        
        Thread.sleep(1000);
        
        List<MobileElement> listItems1 = driver.findElementsByClassName("android.widget.TextView");
		 {
			for (int i = 0; i < listItems1.size(); i++) {
				String el = listItems1.get(i).getText();
				System.out.println("" + el);
                Thread.sleep(100);
				if (el.equals(doortype)) {
					listItems1.get(i).click();
					
				}
			}
		
	/*	
		
		Thread.sleep(500);
		
		//selecting door Location
		
		door_location_drop_down.click();
		Thread.sleep(1000);
		List<MobileElement> listItems2 = driver.findElementsByClassName("android.widget.TextView");
		 {
			for (int i = 0; i < listItems2.size(); i++) {

				System.out.println("" + e2);

				if (e2.equals(doorlocation)) {
					listItems2.get(i).click();
					
				}
			}
		
		Thread.sleep(100);
		
		Util.scrollDown();
		
		//selecting DCU model
		
		dcu_model_drop_down.click();
		Thread.sleep(1000);
		List<MobileElement> listItems3 = driver.findElementsByClassName("android.widget.TextView");
				for (int i = 0; i < listItems3.size(); i++) {
				String e3 = listItems3.get(i).getText();
				System.out.println("" + e3);

				if (e3.equals(DCUmodel)) {
					listItems3.get(i).click();
					
				}
			}
	
		Thread.sleep(100);
		
		//Entering DCU Serial Number
		
		dcu_serial_num.click();
		dcu_serial_num.sendKeys(DCUserialno);
		driver.hideKeyboard();
		Thread.sleep(100);
		
		Util.scrollDown();
		
		//Entering CIU Serial Number
		
		ciu_serial_num.click();
		ciu_serial_num.sendKeys(CIUserialno);
		driver.hideKeyboard();
		Thread.sleep(100);
		
		// selecting doorprofile
		
		door_profile_drop_down.click();
		Thread.sleep(1000);
		List<MobileElement> listItems4 = driver.findElementsByClassName("android.widget.TextView");
		
			for (int i = 0; i < listItems4.size(); i++) {
				String e4 = listItems4.get(i).getText();
				System.out.println("" + e4);

				if (e4.equals(doorprofile)) {
					listItems4.get(i).click();
					
				}
			}
		
		Thread.sleep(100);
		
		//selecting wifitype
		
		wifi_type.click();
		Thread.sleep(1000);
		List<MobileElement> listItems5 = driver.findElementsByClassName("android.widget.TextView");
		
		for (int i = 0; i < listItems5.size(); i++) {
			String e5 = listItems5.get(i).getText();
			System.out.println("" + e5);

			if (e5.equals(WIFISSID)) {
				listItems5.get(i).click();
				
			}
		}
	
		Thread.sleep(100);
		
		 }

	*/
	}
	
	
}



}
