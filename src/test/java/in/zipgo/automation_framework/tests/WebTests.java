package in.zipgo.automation_framework.tests;

import in.zipgo.automation_framework.pages.web.DashboardPage;
import in.zipgo.automation_framework.pages.web.LoginPage;
import in.zipgo.automation_framework.pages.web.SignInPage;
import in.zipgo.automation_framework.utils.Excel;
import in.zipgo.automation_framework.utils.ExcelContext;
import in.zipgo.automation_framework.workflow.ZipGoWorkFlowImplementations;
import in.zipgo.automation_framework.workflow.ZipGoWorkflows;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class WebTests extends BaseTests {

    @Test(dataProvider = "testData")
    public void loginTests(String username, String password, String isLoggedIn) {
        ZipGoWorkflows zgw = new ZipGoWorkFlowImplementations();
        SignInPage signInPage = zgw.openSignInPage();
        LoginPage loginPage = zgw.navigateToLoginPage(signInPage);
        DashboardPage dashboardPage = null;
        boolean isLoginSuccessful = Boolean.valueOf(isLoggedIn);
        if (isLoginSuccessful) {
            dashboardPage = (DashboardPage) zgw.loginToAsAdministrator(loginPage, username, password, DashboardPage.class);
        } else {
            signInPage = (SignInPage) zgw.loginToAsAdministrator(loginPage, username, password, SignInPage.class);
            assertTrue(signInPage.getErrorMessage().contains("Username or password did not match"));
        }
    }

    @DataProvider(name = "testData", parallel = true)
    public static Object[][] getTestData() {
        ExcelContext context = new ExcelContext();
        context.setExcelFile("testData/Web.xlsx");
        context.setSheetName("login");
        Excel excelObj = new Excel(context);
        String[][] testData = excelObj.getData("username", "password", "isLoggedIn");
        return testData;
    }
}
