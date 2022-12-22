package setups;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.openqa.selenium.WebElement;

public class DriverPool {

    private static AndroidDriver driverInstance;

    public static AndroidDriver getDriverInstance() {

        return DriverPool.driverInstance;
    }

    public void setDriverInstance(AndroidDriver instance) {

        DriverPool.driverInstance = instance;
    }
}