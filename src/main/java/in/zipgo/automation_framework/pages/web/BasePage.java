package in.zipgo.automation_framework.pages.web;

import in.zipgo.automation_framework.base.DriverFactory;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.FluentWait;

public class BasePage {

    public WebElement waitForElement(By by) {
        FluentWait<WebDriver> wait = new FluentWait<>(DriverFactory.getDriver());
        wait.withTimeout(30, TimeUnit.SECONDS)
                .pollingEvery(5, TimeUnit.SECONDS)
                .until(new Function<WebDriver, Boolean>() {
                    @Override
                    public Boolean apply(WebDriver driver) {
                        return driver.findElements(by).size() > 0;
                    }
                });
        return DriverFactory.getDriver().findElement(by);
    }
}
