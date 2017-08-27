package in.zipgo.automation_framework.workflow;

import in.zipgo.automation_framework.base.Configurations;
import in.zipgo.automation_framework.base.DriverFactory;
import in.zipgo.automation_framework.pages.mobile.DriverLandingScreen;
import in.zipgo.automation_framework.pages.mobile.DriverLoginScreen;
import in.zipgo.automation_framework.pages.web.BasePage;
import in.zipgo.automation_framework.pages.web.LoginPage;
import in.zipgo.automation_framework.pages.web.SignInPage;

public class ZipGoWorkFlowImplementations implements ZipGoWorkflows {

    @Override
    public SignInPage openSignInPage() {
        DriverFactory.getDriver().get(Configurations.URL);
        return new SignInPage();
    }

    @Override
    public LoginPage navigateToLoginPage(SignInPage signInPage) {
        return signInPage.clickCorporateLoginButton();
    }

    @Override
    public <T extends BasePage> T loginToAsAdministrator(LoginPage loginPage, String username, String password, Class<T> clazz) {
        return loginPage.enterUsername(username)
                .enterPassword(password)
                .clickSubmit(clazz);
    }

    @Override
    public DriverLandingScreen openDriverApp() {
        return new DriverLandingScreen();
    }

    @Override
    public DriverLoginScreen navigateToDriverLoginScreen(DriverLandingScreen driverLandingScreen) {
        return driverLandingScreen.clickOpenDriverApp();
    }

    @Override
    public <T extends BasePage> T loginToAsDriver(DriverLoginScreen loginPage, String username, String password, Class<T> clazz) {
        try {
            return (T) loginPage.enterUsername(username)
                    .enterPassword(password)
                    .clickSubmit(clazz);
        } catch (InstantiationException | IllegalAccessException ex) {
            throw new RuntimeException("Having problems instantiating the class" + clazz.getName());
        }
    }

}
