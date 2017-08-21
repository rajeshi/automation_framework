package in.zipgo.automation_framework.tests;

import in.zipgo.automation_framework.pages.web.DashboardPage;
import in.zipgo.automation_framework.pages.web.LoginPage;
import in.zipgo.automation_framework.pages.web.SignInPage;
import in.zipgo.automation_framework.workflow.ZipGoWorkFlowImplementations;
import in.zipgo.automation_framework.workflow.ZipGoWorkflows;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class LoginTests extends BaseTests {

    @Test(dataProvider = "testData")
    public void loginTests(String username, String password, boolean isLoginSuccessful) {
        ZipGoWorkflows zgw = new ZipGoWorkFlowImplementations();
        SignInPage signInPage = zgw.openSignInPage();
        LoginPage loginPage = zgw.navigateToLoginPage(signInPage);
        DashboardPage dashboardPage = null;
        if (isLoginSuccessful) {
            dashboardPage = (DashboardPage) zgw.loginToTheSystem(loginPage, username, password, DashboardPage.class);
        } else {
            signInPage = (SignInPage) zgw.loginToTheSystem(loginPage, username, password, SignInPage.class);
            assertTrue(signInPage.getErrorMessage().contains("Username or password did not match"));
        }
    }

    @DataProvider(name = "testData", parallel = true)
    public static Object[][] getTestData() {
        return new Object[][]{{"rajesh23427@gmail.com", "1234", false}, {"rajesh23427@gmail.com", "12345", true}};
    }
}
