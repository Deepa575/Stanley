package com.vassarlabs.stanley.tests;

import static setups.DriverPool.getDriverInstance;


import com.vassarlabs.stanley.pages.StanleyLogin_Page;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;

public class StanleyLogin_Test {

	StanleyLogin_Page stanleylogin_page = new StanleyLogin_Page(getDriverInstance());

	@Given("Open the Stanley IQ TOOLBOX App")
	public void open_the_stanley_iq_toolbox_app() throws InterruptedException {

		stanleylogin_page.open_the_stanley_iq_toolbox_app();
	}

	@And("Accept the Terms and Conditions")
	public void accept_the_terms_and_conditions() throws InterruptedException {
		stanleylogin_page.accept_the_terms_and_conditions();
	}

	@And("Enter username and password {string} {string} in Login Screen")
	public void enter_username_and_password_in_login_screen(String username, String password)
			throws InterruptedException {
		stanleylogin_page.enter_username_and_password_in_login_screen(username, password);
	}

	@Then("Click on Login button")
	public void click_on_login_button() {
		stanleylogin_page.click_on_login_button();

	}

}
