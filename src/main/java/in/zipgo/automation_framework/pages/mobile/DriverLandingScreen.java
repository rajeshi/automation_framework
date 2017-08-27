package in.zipgo.automation_framework.pages.mobile;

import in.zipgo.automation_framework.pages.web.BasePage;
import org.openqa.selenium.By;

public class DriverLandingScreen extends BasePage {

    By openDriverApp = By.id("com.zipgo.bus:id/launch");
    
    public DriverLoginScreen clickOpenDriverApp(){
        waitForElement(openDriverApp).click();
        return new DriverLoginScreen();
    }
}
