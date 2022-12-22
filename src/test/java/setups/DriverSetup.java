package setups;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.service.local.AppiumDriverLocalService;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;

public class DriverSetup extends DriverPool {
	
	public static AndroidDriver<MobileElement> driver;

    public AppiumDriverLocalService service;

    public void prepareAutomation() throws MalformedURLException {
        Capabilities capabilities = new Capabilities();
        capabilities.localAndroid();

        AndroidDriver driver = new AndroidDriver(new URL("http://0.0.0.0:4723/wd/hub"), capabilities.localAndroid());
        setDriverInstance(driver);
        System.out.println("Driver: " + driver);
    }

    public void startAppium() {
        service = AppiumDriverLocalService.buildDefaultService();
        service.start();
        String service_url = service.getUrl().toString();
        System.out.println("URL: " + service_url);
    }

    public void stopAppium() {
        service.stop();
    }
   
}