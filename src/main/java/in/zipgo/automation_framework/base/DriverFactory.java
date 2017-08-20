package in.zipgo.automation_framework.base;

import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {

    private static Map<Long, WebDriver> drivers = new HashMap<Long, WebDriver>();

    public static void createWebDriverInstance() {
        Long l = Thread.currentThread().getId();

        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        drivers.put(l, driver);
    }

    public static WebDriver getDriver() {
        return drivers.get(Thread.currentThread().getId());
    }
}
