package in.zipgo.automation_framework.tests;

import in.zipgo.automation_framework.base.DriverFactory;
import java.util.concurrent.TimeUnit;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTests extends Assert {

    @BeforeMethod
    public void setupTest() {
        DriverFactory.createWebDriverInstance();
        DriverFactory.getDriver().manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        
    }

    @AfterMethod
    public void tearDownTest() {
        DriverFactory.getDriver().close();
    }
}
