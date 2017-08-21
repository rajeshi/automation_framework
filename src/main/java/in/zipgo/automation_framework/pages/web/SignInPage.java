package in.zipgo.automation_framework.pages.web;

import org.openqa.selenium.By;

public class SignInPage extends BasePage {

    private final By corporateLoginButton = By.xpath("//button[@data-provider='corporate-login']");
    private final By errorMessage = By.className("alert-danger");

    public LoginPage clickCorporateLoginButton() {
        waitForElement(corporateLoginButton).click();
        return new LoginPage();
    }
    
    public String getErrorMessage(){
        return waitForElement(errorMessage).getText();
    }
}
