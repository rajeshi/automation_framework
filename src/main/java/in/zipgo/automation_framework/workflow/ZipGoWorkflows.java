package in.zipgo.automation_framework.workflow;

import in.zipgo.automation_framework.pages.mobile.DriverLandingScreen;
import in.zipgo.automation_framework.pages.mobile.DriverLoginScreen;
import in.zipgo.automation_framework.pages.web.BasePage;
import in.zipgo.automation_framework.pages.web.LoginPage;
import in.zipgo.automation_framework.pages.web.SignInPage;

public interface ZipGoWorkflows {

    public SignInPage openSignInPage();

    public LoginPage navigateToLoginPage(SignInPage signInPage);

    public DriverLandingScreen openDriverApp();

    public DriverLoginScreen navigateToDriverLoginScreen(DriverLandingScreen driverLandingScreen);

    public <T extends BasePage> T loginToAsAdministrator(LoginPage loginPage, String username, String password, Class<T> clazz);

    public <T extends BasePage> T loginToAsDriver(DriverLoginScreen loginPage, String username, String password, Class<T> clazz);
}
