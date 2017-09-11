# Test Automation Framework
This document talks about how to use the Test Automation Framework for testing the ZipGo Web, Mobile and API application.

## Introduction
The Test Automation Framework allows you to create the tests for:
* Web Applications which can be run on following browsers:
  * Chrome
  * Firefox
  * Edge Driver
  * Internet Explorer 11
* Mobile Apps including:
  * Native Android
  * Android Web
  * Native iOS (Need to be tested)
  * iOS Web
* RESTFul APIs

## Framework Block Diagram
![Framework Block Diagram](/images/Framework_Design.PNG)

## Pre-requisite Tools and Technologies
* Java JDK 1.8 Above
* Java IDE like Eclipse, Netbeans or IntelliJ IDEA
* Maven Environment (Should be present in Netbeans and IntelliJ IDEA out of the box. For Eclipse, plugin might be required to be installed)
* GIT SCM for pull and pushing the code

## Technology Stack
* Java JDK 1.8 above
* Maven 3.5 above
* TestNG 6.11
* Rest-Assured 3.0.3
* Appium 4.1.2
* Mongo Driver 2.14.3
* Selenium WebDriver 3.4

## Setup Info
* Clone the project from the following repository: https://github.com/zipgo/autoscripts.git
* Download the Web Drivers for Chrome, Firefox and IE in the following path:
 * Chrome:	https://sites.google.com/a/chromium.org/chromedriver/downloads
 * Edge:	https://developer.microsoft.com/en-us/microsoft-edge/tools/webdriver/
 * Firefox:	https://github.com/mozilla/geckodriver/releases
* Place the respective distributions in the folder of your choice. After this, follow the following steps:
	* Navigate to your .m2 folder.
		* For Windows, this should be under C:\Users\<Your_Account_Name>\\.m2
		* For Linux, this should be under ~/.m2 folder.
	* Create a file settings.xml
	* Next the following script inside your code:
	```
	<settings xmlns="http://maven.apache.org/SETTINGS/1.1.0" xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
          xsi:schemaLocation="http://maven.apache.org/SETTINGS/1.1.0 http://maven.apache.org/xsd/settings-1.1.0.xsd">
		<profiles>
			<profile>
				<id>local-properties</id>
				<activation>
					<activeByDefault>true</activeByDefault>
				</activation>
				<properties>
					<zipgo.chrome.driver>PATH_TO_THE_EXECUTABLE</zipgo.chrome.driver>
					<zipgo.gecko.driver>PATH_TO_THE_EXECUTABLE</zipgo.gecko.driver>
					<zipgo.ie.driver>PATH_TO_THE_EXECUTABLE</zipgo.ie.driver>
				</properties>
			</profile>
		</profiles> 
		<activeProfiles>
			<activeProfile>local-properties</activeProfile>
		</activeProfiles>
	</settings>
	```
* Run the command:
```
mvn clean install
```
* This should generate run the test and create a har file and create a test.har file in E:(If you do not have a E Drive, then the test will fail) (Will be fixed in my next release)

## Folder Structure

![Folder Structure](/images/folder_structure.PNG)

## Creating the Page Objects
The test automation framework is designed with an objective to reduce timeout failures and at the same time provide you with functions that can be easy to use. For this we have developed the BasePage class which provides you all the functions that you might want to easily complete your test automation scripts. All the Page Objects will be based on this BasePage Class.

To create a new Page, here are the steps:
* Create a class with the following naming convention <PageName>Page.java example: LoginPage.java
* Next, extend the class to BasePage
* After that create the WebElements on the Page using the By of that page.
* After creating the WebElements, the next step is to create the functions for each of the By element.
* Ensure that, 
 * if the action performed on the WebElement results the same page, then return the same page for that method
 * if the action performed on the WebElement results in the navigation to another Page, then return that page for that method
 * if the action performed on the WebElements is decided based on the inputs like invalid login entries or valid login entries which can have different resultant page, then the based on the Class parameter, the method should return that particular page.
 * if the action peerformed on the WebElement results in fetching of a value or status, then it should return any of the primitive datatypes like String, boolean, integers or any number formats.
 
   Here is an example of a page with the above mentioned guidelines:
   ```java
   public class LoginPage extends BasePage {

    final By loginUserName = By.id("loginUsername");

    final By loginPassword = By.id("loginPassword");

    final By signInButton = By.xpath("//input[@value='Sign in']");

    final By errorMsg = By.className("alert-danger");

    public LoginPage enterUsername(String username) {
        waitForElement(loginUserName).sendKeys(username);
        return this;
    }

    public LoginPage enterPassword(String password) {
        waitForElement(loginPassword).sendKeys(password);
        return this;
    }

    public <T extends BasePage> T clickSubmit(Class<T> clazz) {
        try {
            waitForElement(signInButton).click();
            return (T) clazz.newInstance();
        } catch (InstantiationException | IllegalAccessException ex) {
            throw new RuntimeException("Unable to create an instance of the page");
        }
    }
   ```
   Here is another example:
   ```java
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
   ```
## Defining the the different workflows
Now that we have defined the pages, we have established the framework to interact with the Application Under Test, the next step is to define the various workflows for your application. Here are some of the basic workflows that have been defined as an interface:

```java
public interface ZipGoWorkflows {

    public SignInPage openSignInPage();

    public LoginPage navigateToLoginPage(SignInPage signInPage);

    public DriverLandingScreen openDriverApp();

    public DriverLoginScreen navigateToDriverLoginScreen(DriverLandingScreen driverLandingScreen);

    public <T extends BasePage> T loginToAsAdministrator(LoginPage loginPage, String username, String password, Class<T> clazz);

    public <T extends BasePage> T loginToAsDriver(DriverLoginScreen loginPage, String username, String password, Class<T> clazz);
}
```
And here are it's implementations:
```java
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
```

If you notice the way <i>loginToAsDriver()</i> method is written, it allows you to combine multiple steps into one without having to call <i>loginPage</i> instance multiple times. This allows:
1. Reduction of StaleElementException
1. Better Readability of the code.

## Writing your Web & Mobile tests
Now that we have differentiated the Interaction Layer from the Business Layer, the next step is to combine the different workflows from the Business Layers into a test with various data and behavioral configurations. This will allow:
1. Writing tests assuming the business workflows as an abstract which would reduce your maintenance efforts in case of additional workflows which might come up as a change in the feature. The test might not need any update in case of minor changes.
1. Any failures in the page elements need to be dealt in the Interaction Layer thus reducing the maintainability drastically
1. You can define and decide the flow of tests and your test becomes easy to read as if you are reading the functionality as a plain language. But it will be in Java.

Here is an example of how to write your tests with a datadriven approach:
```java
@Test(dataProvider = "testData", groups = {TestGroups.SMOKE})
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

    @DataProvider(name = "testData", parallel = false)
    public static Object[][] getTestData() {
        ExcelContext context = new ExcelContext();
        context.setExcelFile("testData/Web.xlsx");
        context.setSheetName("login");
        Excel excelObj = new Excel(context);
        String[][] testData = excelObj.getData("username", "password", "isLoggedIn");
        return testData;
    }
```

## Writing an API Test
The REST API tests can be tested using this framework. It is supported using rest-assured api which allows you to:
* Define your own Serialization/Deserialization logic
* Define your own Authentication Scheme
	* Supports:
		* Basic Authentication
		* Digest Authentication
		* Preemptive Authentication
		* oAuth
In order to write the tests, you need to firstly do the following
* Create the Data Structures for each of your endpoints (This could be a manual task based on the examples. Or we can create data structures using the either the swagger file or the json schema that is created)
* Create the Test Data using the Enums which will implement the interface Supplier
* Finally write your test as follows:
```
@Test
    public void sampleApiTests() {
        Authentication auth = new DefaultAuthentication(new AuthContext());
        RestManager manager = new RestManager(BasicMediaTypes.JSON, auth, null);

        Session session = SessionEnums.VALID_SESSION_INFO.getData();
        
        Response response = manager.post("https://beta.zipgo.in", "/sessions/connect", session);
        assertEquals(response.statusCode(), 200, "Something went wrong with the request");
        MemberResponse memResp = response.as(MemberResponse.class);
        String ssoToken = memResp.getSsoToken();

        List<Header> headerArr = new ArrayList<>();
        Header authHeader = new Header("Authorization", ssoToken);
        headerArr.add(authHeader);
        Headers headers = new Headers(headerArr);
        manager = new RestManager(BasicMediaTypes.JSON, auth, headers);
        response = manager.get("https://beta.zipgo.in", "/route_trips");
        assertEquals(response.statusCode(), 200, "Something went wrong with the request");
        List<Route> routes = response.as(List.class);
        assertTrue(routes.size() > 10, "Not enough routes created");
    }
```
