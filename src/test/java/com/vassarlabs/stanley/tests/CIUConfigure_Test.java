package com.vassarlabs.stanley.tests;

import static setups.DriverPool.getDriverInstance;

import com.vassarlabs.stanley.pages.CIUConfigure_Page;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import setups.Util;

public class CIUConfigure_Test 
{
	CIUConfigure_Page ciuconfigure_page = new CIUConfigure_Page(getDriverInstance());
	Util util = new Util(getDriverInstance());
	
	@Given("Application Has to open")
	public void application_has_to_open() {
		ciuconfigure_page.application_has_to_open();
	   
	}

	@And("Click on the menu and select IQ Connect")
	public void click_on_the_menu_and_select_iq_connect() throws InterruptedException {
		
		ciuconfigure_page.click_on_the_menu_and_select_iq_connect();
	   
	}

	@When("Click on CIU Configure button")
	public void click_on_ciu_configure_button() {
		ciuconfigure_page.click_on_ciu_configure_button();
	}

	@And("Enter Wifi Configure Screen {string} {string} {string} {string} {string} {string} {string} {string} {string} {string}")
	public void enter_wifi_configure_screen(String customername, String storeid, String doorid, String doortype, String doorlocation, String DCUmodel, String DCUserialno, String CIUserialno, String doorprofile, String WIFISSID) throws InterruptedException {
		
		ciuconfigure_page.enter_wifi_configure_screen(customername, storeid, doorid, doortype, doorlocation, DCUmodel, DCUserialno, CIUserialno, doorprofile, WIFISSID);
		
		
	}
	
}
