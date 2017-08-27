package in.zipgo.automation_framework.pages.mobile;

import in.zipgo.automation_framework.pages.web.BasePage;
import org.openqa.selenium.By;

public class DriverLoginScreen extends BasePage {

    By loginUsername = By.id("com.zipgo.bus:id/username");
    By loginPassword = By.id("com.zipgo.bus:id/password");
    By submitButton = By.id("com.zipgo.bus:id/login");

    public DriverLoginScreen enterUsername(String username) {
        waitForElement(loginUsername).sendKeys(username);
        return this;
    }

    public DriverLoginScreen enterPassword(String password) {
        waitForElement(loginPassword).sendKeys(password);
        return this;
    }

    public <T extends BasePage> T clickSubmit(Class<T> clazz) throws InstantiationException, IllegalAccessException {
        waitForElement(submitButton).click();
        return (T) clazz.newInstance();
    }
}
