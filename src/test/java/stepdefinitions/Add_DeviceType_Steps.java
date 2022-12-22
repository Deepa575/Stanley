package stepdefinitions;

import com.driver.WebdriverIntializer;
import com.pages.Add_DeviceType_Page;
import com.pages.Login_Page;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;


public class Add_DeviceType_Steps {
    private Add_DeviceType_Page addDevice = new Add_DeviceType_Page(WebdriverIntializer.getDriver());
    private Login_Page lgn = new Login_Page(WebdriverIntializer.getDriver());
    @Given("Go To Add DeviceType Page")
    public void Go_To_Add_DeviceType_Page(){
        lgn.enterUsername("superadmin");
        lgn.enterPassword("stanley@123");
        lgn.clickOnSignin();
        addDevice.clickOnAdministration();
        addDevice.clickOnDeviceType();
        addDevice.clickOnAddDeviceType();
    }

    @When("Enter Details Into Devicetype and Description {string} {string}")
    public void enter_Details_Into_Devicetype_and_Description(String deviceType , String description){
        addDevice.enterDeviceTypeDetails(deviceType,description);
    }

    @When("Click On Submit")
    public void click_On_Submit(){
        addDevice.clickOnSubmit();
    }
    @Then("Verify Toaster Message {string}")
    public void verify_Toaster_Message(String expectedMessage) throws InterruptedException {
        addDevice.verifyToasterMessage(expectedMessage);
    }


}
