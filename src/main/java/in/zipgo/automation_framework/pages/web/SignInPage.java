package in.zipgo.automation_framework.pages.web;

import org.openqa.selenium.By;

public class SignInPage extends BasePage {

    private final By corporateLoginButton = By.xpath("//button[@data-provider='corporate-login']");

    public LoginPage clickCorporateLoginButton() {
        waitForElement(corporateLoginButton).click();
        return new LoginPage();
    }
}
