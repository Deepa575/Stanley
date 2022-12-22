package setups;

import org.openqa.selenium.remote.DesiredCapabilities;

public class Capabilities {

    public DesiredCapabilities localAndroid(){
        DesiredCapabilities capabilities = new DesiredCapabilities();

        capabilities.setCapability("platformName", "Android");
        capabilities.setCapability("platformVersion", "10");
        capabilities.setCapability("deviceName", "YX4DEEDMIZPNVCE6");
      //  capabilities.setCapability("uiautomator2ServerInstallTimeout", "80000");
        capabilities.setCapability("ignoreHiddenApiPolicyError", "true");
       // capabilities.setCapability("app", "C:\\Users\\vassar\\Downloads\\Nudj Release Apk 11 Oct 2022.apk");
        capabilities.setCapability("appPackage", "com.stanleyaccesstechnologies.iqtoolbox");
        capabilities.setCapability("appActivity", "com.stanleyaccesstechnologies.iqtoolbox.ui.activity.SplashActivity");
       // capabilities.setCapability("clearSystemFiles", "true");
        capabilities.setCapability("autoGrantPermissions","true");
       // capabilities.setCapability("noReset", "true");
       // capabilities.setCapability("unicodeKeyboard", true);
        

        return capabilities;
    }
}