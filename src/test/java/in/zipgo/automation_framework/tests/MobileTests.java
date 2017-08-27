package in.zipgo.automation_framework.tests;

import in.zipgo.automation_framework.pages.mobile.DriverLandingScreen;
import in.zipgo.automation_framework.pages.mobile.DriverLoginScreen;
import in.zipgo.automation_framework.pages.mobile.DriverMessageBox;
import in.zipgo.automation_framework.utils.Excel;
import in.zipgo.automation_framework.utils.ExcelContext;
import in.zipgo.automation_framework.workflow.ZipGoWorkFlowImplementations;
import in.zipgo.automation_framework.workflow.ZipGoWorkflows;
import static org.testng.Assert.assertEquals;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MobileTests extends BaseTests {

    @Test(dataProvider = "mobileTestData")
    public void sampleMobileTest(String username, String password) {
        ZipGoWorkflows zgw = new ZipGoWorkFlowImplementations();
        DriverLandingScreen landingScreen = zgw.openDriverApp();
        DriverLoginScreen loginScreen = zgw.navigateToDriverLoginScreen(landingScreen);
        DriverMessageBox messageBox = zgw.loginToAsDriver(loginScreen, username, password, DriverMessageBox.class);
        assertEquals(messageBox.getPrimaryMessage(), "302", "The Primary Message does not match");
        assertEquals(messageBox.getSecondaryMessage(), "Trips not uploaded yet. Login after some time.", "The Secondary Message does not match");
    }

    @DataProvider(name = "mobileTestData", parallel = false)
    public static Object[][] getMobileTestData() {
        ExcelContext context = new ExcelContext();
        context.setExcelFile("testData/Mobile.xlsx");
        context.setSheetName("driver_login");
        Excel excelObj = new Excel(context);
        String[][] testData = excelObj.getData("username", "password");
        return testData;
    }
}
