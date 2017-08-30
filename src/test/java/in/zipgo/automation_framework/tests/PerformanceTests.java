package in.zipgo.automation_framework.tests;

import in.zipgo.automation_framework.base.DriverFactory;
import in.zipgo.automation_framework.pages.web.DashboardPage;
import in.zipgo.automation_framework.pages.web.LoginPage;
import in.zipgo.automation_framework.pages.web.SignInPage;
import in.zipgo.automation_framework.workflow.ZipGoWorkFlowImplementations;
import in.zipgo.automation_framework.workflow.ZipGoWorkflows;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import org.testng.Assert;
import static org.testng.Assert.assertTrue;
import org.testng.annotations.Test;

public class PerformanceTests extends Assert {

    @Test
    public void samplePerformanceTests() throws InterruptedException, IOException {
        DriverFactory.createWebDriverInstance("PERFORMANCE", "WEB");
        DriverFactory.getDriver()
                .manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        ZipGoWorkflows zgw = new ZipGoWorkFlowImplementations();
        SignInPage signInPage = zgw.openSignInPage();
        Thread.sleep(10000);
        LoginPage loginPage = zgw.navigateToLoginPage(signInPage);
        Thread.sleep(10000);
        DashboardPage dashboardPage = null;
        dashboardPage = (DashboardPage) zgw.loginToAsAdministrator(loginPage, "rajesh23427@gmail.com", "12345", DashboardPage.class);
        Thread.sleep(10000);
        DriverFactory.getHttpTraffic();
        DriverFactory.getDriver().quit();
    }
}
