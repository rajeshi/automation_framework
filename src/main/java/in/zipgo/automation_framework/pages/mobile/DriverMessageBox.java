package in.zipgo.automation_framework.pages.mobile;

import in.zipgo.automation_framework.pages.web.BasePage;
import org.openqa.selenium.By;

public class DriverMessageBox extends BasePage {

    By primaryMessage = By.id("com.zipgo.bus:id/primary_message");
    By secondaryMessage = By.id("com.zipgo.bus:id/secondary_message");
    By logoutButton = By.id("com.zipgo.bus:id/negative");

    public String getPrimaryMessage() {
        return waitForElement(primaryMessage).getText();
    }

    public String getSecondaryMessage() {
        return waitForElement(secondaryMessage).getText();
    }

    public DriverLoginScreen clickLogout() {
        waitForElement(logoutButton).click();
        return new DriverLoginScreen();
    }
}
