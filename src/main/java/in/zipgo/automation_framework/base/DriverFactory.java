package in.zipgo.automation_framework.base;

import in.zipgo.automation_framework.converters.Har2JmxConverter;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.Connection;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import net.lightbody.bmp.BrowserMobProxy;
import net.lightbody.bmp.BrowserMobProxyServer;
import net.lightbody.bmp.client.ClientUtil;
import net.lightbody.bmp.core.har.Har;
import net.lightbody.bmp.proxy.CaptureType;
import org.openqa.selenium.Platform;
import org.openqa.selenium.Proxy;
import org.openqa.selenium.SessionNotCreatedException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.remote.UnreachableBrowserException;

public class DriverFactory {

    private static Map<String, WebDriver> drivers = new HashMap<String, WebDriver>();

    private static BrowserMobProxy proxy;

    public static void createWebDriverInstance() throws MalformedURLException {
        String browserName = Configurations.BROWSER;
        String testType = Configurations.TEST_TYPE;
        createWebDriverInstance(browserName, testType);
    }

    public static void createWebDriverInstance(String browserName, String testType) throws MalformedURLException {
        String thread = Thread.currentThread().getName();
        WebDriver driver = null;
        DesiredCapabilities capabilities = new DesiredCapabilities();
        ChromeOptions options = null;

        if (testType.equalsIgnoreCase("WEB")) {
            switch (browserName.toUpperCase()) {
                case "CHROME":
                    System.out.println(Configurations.CHROME_DRIVER_EXE);
                    System.setProperty("webdriver.chrome.driver", Configurations.CHROME_DRIVER_EXE);
                    capabilities = DesiredCapabilities.chrome();
                    options = new ChromeOptions();
                    options.addArguments("test-type", "start-maximized", "no-default-browser-check", "--disable-extensions");
                    capabilities.setCapability(ChromeOptions.CAPABILITY, options);
                    capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
                    capabilities.setPlatform(Platform.ANY);
                    if (Configurations.REMOTE) {
                        driver = new RemoteWebDriver(new URL(Configurations.SELENIUM_GRID_URL + "&threadCount=10&browser=chrome"), capabilities);
                    } else {
                        driver = new ChromeDriver(capabilities);
                    }
                    drivers.put(thread, driver);
                    break;
                case "FIREFOX":
                    System.setProperty("webdriver.gecko.driver", Configurations.FIREFOX_DRIVER_EXE);
                    capabilities = DesiredCapabilities.firefox();
                    capabilities.setCapability("marionette", true);

                    if (Configurations.REMOTE) {
                        driver = new RemoteWebDriver(new URL(Configurations.SELENIUM_GRID_URL + "&threadCount=10&browser=firefox"), capabilities);
                    } else {
                        driver = new FirefoxDriver();
                    }
                    driver = new FirefoxDriver();
                    drivers.put(thread, driver);
                    break;
                case "IE":
                    System.setProperty("webdriver.ie.driver", Configurations.IE_DRIVER_EXE);
                    driver = new InternetExplorerDriver();

                    drivers.put(thread, driver);
                    break;
                case "PERFORMANCE":
                    proxy = new BrowserMobProxyServer();
                    proxy.start(0);
                    Proxy seleniumProxy = ClientUtil.createSeleniumProxy(proxy);

                    capabilities = new DesiredCapabilities();
                    capabilities.setCapability(CapabilityType.PROXY, seleniumProxy);
                    proxy.enableHarCaptureTypes(CaptureType.REQUEST_CONTENT, CaptureType.RESPONSE_CONTENT);
                    proxy.newHar("zipgo.har");

                    System.setProperty("webdriver.chrome.driver", Configurations.CHROME_DRIVER_EXE);
                    capabilities = DesiredCapabilities.chrome();
                    options = new ChromeOptions();
                    options.addArguments("test-type", "start-maximized", "no-default-browser-check", "--disable-extensions");
                    capabilities.setCapability(ChromeOptions.CAPABILITY, options);
                    capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
                    capabilities.setPlatform(Platform.ANY);

                    if (Configurations.REMOTE) {
                        driver = new RemoteWebDriver(new URL(Configurations.SELENIUM_GRID_URL + "&threadCount=10&browser=chrome"), capabilities);
                    } else {
                        driver = new ChromeDriver(capabilities);
                    }
                    drivers.put(thread, driver);
                    break;
                default:
                    System.setProperty("webdriver.chrome.driver", Configurations.CHROME_DRIVER_EXE);
                    capabilities = DesiredCapabilities.chrome();
                    options = new ChromeOptions();
                    options.addArguments("test-type", "start-maximized", "no-default-browser-check", "--disable-extensions");
                    capabilities.setCapability(ChromeOptions.CAPABILITY, options);
                    capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
                    capabilities.setPlatform(Platform.ANY);
                    if (Configurations.REMOTE) {
                        driver = new RemoteWebDriver(new URL(Configurations.SELENIUM_GRID_URL + "&threadCount=10&browser=chrome"), capabilities);
                    } else {
                        driver = new ChromeDriver(capabilities);
                    }
            }
        } else {
            switch (browserName.toUpperCase()) {
                case "ANDROID":
                    capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID");
                    capabilities.setCapability(MobileCapabilityType.APP, Configurations.APPIUM_APP);
                    capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "ZY2232CH28");

                    try {
                        AppiumServer.startServer(getAppiumUrl().toString());
                        driver = new AndroidDriver<>(getAppiumUrl(), capabilities);
                    } catch (SessionNotCreatedException | UnreachableBrowserException e) {
                        e.printStackTrace();
                        throw e;
                    }
                    drivers.put(thread, driver);
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
                    drivers.put(thread, driver);
                    break;
                case "ANDROID_NO_CONNECTION":
                    capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "ANDROID");
                    capabilities.setCapability(MobileCapabilityType.APP, Configurations.APPIUM_APP);
                    capabilities.setCapability(MobileCapabilityType.DEVICE_NAME, "ZY2232CH28");

                    try {
                        AppiumServer.startServer(getAppiumUrl().toString());
                        driver = new AndroidDriver<>(getAppiumUrl(), capabilities);
                        ((AndroidDriver<WebElement>) driver).setConnection(Connection.NONE);
                    } catch (SessionNotCreatedException | UnreachableBrowserException e) {
                        e.printStackTrace();
                        throw e;
                    }
                    drivers.put(thread, driver);
                    break;
                case "IOS":
                    capabilities.setCapability(MobileCapabilityType.PLATFORM_NAME, "IOS");
                    try {
                        AppiumServer.startServer(getAppiumUrl().toString());
                        driver = new IOSDriver<>(getAppiumUrl(), capabilities);
                    } catch (SessionNotCreatedException | UnreachableBrowserException e) {
                        e.printStackTrace();
                        throw e;
                    }
                    drivers.put(thread, driver);
                    break;
                case "IOS_WEB":
                    try {
                        AppiumServer.startServer(getAppiumUrl().toString());
                        driver = new IOSDriver<WebElement>(getAppiumUrl(), capabilities);
                    } catch (SessionNotCreatedException | UnreachableBrowserException e) {
                        e.printStackTrace();
                        throw e;
                    }
                    drivers.put(thread, driver);
                    break;
            }
        }
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

    public static void getHttpTraffic() throws IOException {
        if (Configurations.BROWSER.equals("PERFORMANCE")) {
            Har har = proxy.getHar();
            proxy.stop();
            Har2JmxConverter converter = new Har2JmxConverter();
            converter.generateJmxFile(har);
        }
    }
}
