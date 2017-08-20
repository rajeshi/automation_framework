package in.zipgo.automation_framework.workflow;

import in.zipgo.automation_framework.pages.web.BasePage;
import in.zipgo.automation_framework.pages.web.LoginPage;
import in.zipgo.automation_framework.pages.web.SignInPage;

public class ZipGoWorkFlowImplementations implements ZipGoWorkflows {

    @Override
    public SignInPage openSignInPage() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public LoginPage navigateToLoginPage() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public <T extends BasePage> T loginToTheDashboardPage(LoginPage loginPage, String username, String password) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
