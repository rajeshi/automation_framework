package in.zipgo.automation_framework.base;

import java.util.HashMap;
import java.util.Map;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverFactory {

    private static Map<String, WebDriver> drivers = new HashMap<String, WebDriver>();

    public static void createWebDriverInstance() {
        String thread = Thread.currentThread().getName();
        System.out.println("Creating WebDriver instance: " + thread);
        System.setProperty("webdriver.chrome.driver", "D:\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        drivers.put(thread, driver);
    }

    public static WebDriver getDriver() {
        System.out.println("Getting Thread Instance: " + Thread.currentThread().getName());
        return drivers.get(Thread.currentThread().getName());
    }
}
