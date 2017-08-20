package in.zipgo.automation_framework.workflow;

import in.zipgo.automation_framework.pages.web.BasePage;
import in.zipgo.automation_framework.pages.web.LoginPage;
import in.zipgo.automation_framework.pages.web.SignInPage;

public interface ZipGoWorkflows {

    public SignInPage openSignInPage();

    public LoginPage navigateToLoginPage();

    public <T extends BasePage> T loginToTheDashboardPage(LoginPage loginPage, String username, String password);
}
