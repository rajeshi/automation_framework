package in.zipgo.automation_framework.base;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.Platform;
import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.UnreachableBrowserException;

public class DriverFactory {

    private static Map<String, WebDriver> drivers = new HashMap<String, WebDriver>();

    public static void createWebDriverInstance() {
        String browserName = Configurations.BROWSER;
        String testType = Configurations.TEST_TYPE;

        createWebDriverInstance(browserName, testType);
    }

    public static void createWebDriverInstance(String browserName, String testType) {
        String thread = Thread.currentThread().getName();
        WebDriver driver = null;
        DesiredCapabilities capabilities = new DesiredCapabilities();
        ChromeOptions options = null;
        if (testType.equalsIgnoreCase("WEB")) {
            switch (browserName.toUpperCase()) {
                case "CHROME":
                    System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
                    capabilities = DesiredCapabilities.chrome();
                    options = new ChromeOptions();
                    options.addArguments("test-type", "start-maximized", "no-default-browser-check", "--disable-extensions");
                    capabilities.setCapability(ChromeOptions.CAPABILITY, options);
                    capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
                    capabilities.setPlatform(Platform.ANY);
                    if (Configurations.REMOTE) {
                        driver = new RemoteWebDriver(capabilities);
                    } else {
                        driver = new ChromeDriver(capabilities);
                    }
                    drivers.put(thread, driver);
                    break;
                case "FIREFOX":
                    System.setProperty("webdriver.gecko.driver", "D:\\geckodriver.exe");
                    capabilities = DesiredCapabilities.firefox();
                    capabilities.setCapability("marionette", true);

                    if (Configurations.REMOTE) {
                        driver = new RemoteWebDriver(capabilities);
                    } else {
                        driver = new FirefoxDriver();
                    }
                    driver = new FirefoxDriver();
                    drivers.put(thread, driver);
                    break;
                case "IE":
                    System.setProperty("webdriver.ie.driver", "D:\\MicrosoftWebDriver.exe");
                    driver = new InternetExplorerDriver();
                    drivers.put(thread, driver);
                    break;
                default:
                    System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
                    capabilities = DesiredCapabilities.chrome();
                    options = new ChromeOptions();
                    options.addArguments("test-type", "start-maximized", "no-default-browser-check", "--disable-extensions");
                    capabilities.setCapability(ChromeOptions.CAPABILITY, options);
                    capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
                    capabilities.setPlatform(Platform.ANY);
                    if (Configurations.REMOTE) {
                        driver = new RemoteWebDriver(capabilities);
                    } else {
                        driver = new ChromeDriver(capabilities);
                    }
                    break;
            }
        } else {
            switch (browserName.toUpperCase()) {
                case "ANDROID":
                    capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID");
                    capabilities.setCapability(MobileCapabilityType.APP, "E:\\Projects\\Upwork\\ZipGo\\customer-beta-debug.apk");
                    capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "ZY2232CH28");
                    try {
                        AppiumServer.startServer(getAppiumUrl().toString());
                        driver = new AndroidDriver<WebElement>(getAppiumUrl(), capabilities);
                    } catch (SessionNotCreatedException | UnreachableBrowserException e) {
                        e.printStackTrace();
                        throw e;
                    }
                    break;

                case "ANDROID_WEB":
                    capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID");
                    try {
                        AppiumServer.startServer(getAppiumUrl().toString());
                        driver = new AndroidDriver<WebElement>(getAppiumUrl(), capabilities);
                    } catch (SessionNotCreatedException | UnreachableBrowserException e) {
                        e.printStackTrace();
                        throw e;
                    }
                    break;
                case "IOS":

                    capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "IOS");
                    try {
                        AppiumServer.startServer(getAppiumUrl().toString());
                        driver = new IOSDriver<WebElement>(getAppiumUrl(), capabilities);
                    } catch (SessionNotCreatedException | UnreachableBrowserException e) {
                        e.printStackTrace();
                        throw e;
                    }
                    break;
                case "IOS_WEB":
                    try {
                        AppiumServer.startServer(getAppiumUrl().toString());
                        driver = new IOSDriver<WebElement>(getAppiumUrl(), capabilities);
                    } catch (SessionNotCreatedException | UnreachableBrowserException e) {
                        e.printStackTrace();
                        throw e;
                    }
                    break;
            }
        }
        drivers.put(thread, driver);
    }

    private static URL getAppiumUrl() {
        String appiumhubUrl = Configurations.APPIUM_HUB_URL;
        try {
            return new URL(appiumhubUrl);
        } catch (MalformedURLException e) {
        }
        return null;
    }

    public static WebDriver getDriver() {
        return drivers.get(Thread.currentThread().getName());
    }
}