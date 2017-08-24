package utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.AndroidMobileCapabilityType;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.io.File;
import java.io.FileInputStream;
import java.net.URL;
import java.util.Properties;

public class Utils {

    public static String readProperty(String property) {
        Properties prop;
        String value = null;
        try {
            prop = new Properties();
            prop.load(new FileInputStream(new File("config.properties")));

            value = prop.getProperty(property);

            if (value == null || value.isEmpty()) {
                throw new Exception("Value not set or empty");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return value;
    }


    public static AppiumDriver<?> returnDriver(String udid, String version) throws Exception {
        AppiumDriver<?> driver;
        DesiredCapabilities capabilities = new DesiredCapabilities();

        if (Boolean.parseBoolean(Utils.readProperty("run.hybrid"))) {
            capabilities.setCapability(MobileCapabilityType.AUTO_WEBVIEW, true);
        }


        String completeURL = "http://" + Utils.readProperty("run.ip") + ":" + Utils.readProperty("run.port") + "/wd/hub";

        if (Boolean.parseBoolean(Utils.readProperty("run.preinstalled"))) {
            capabilities.setCapability(AndroidMobileCapabilityType.APP_PACKAGE, Utils.readProperty("android.appPackage"));
            capabilities.setCapability(AndroidMobileCapabilityType.APP_ACTIVITY, Utils.readProperty("android.appActivity"));
        } else {
            capabilities.setCapability(MobileCapabilityType.APP, new File(Utils.readProperty("app.android.path")).getAbsolutePath());
        }

        capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, Utils.readProperty("device.android.name"));
        capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
        capabilities.setCapability(MobileCapabilityType.PLATFORM, MobilePlatform.ANDROID);
        capabilities.setCapability(MobileCapabilityType.PLATFORM_VERSION, version);
        capabilities.setCapability(MobileCapabilityType.UDID, udid);

        capabilities.setCapability(AndroidMobileCapabilityType.AUTO_GRANT_PERMISSIONS, true);

        driver = new AndroidDriver<>(new URL(completeURL), capabilities);

        return driver;
    }
}
