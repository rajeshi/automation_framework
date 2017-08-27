package in.zipgo.automation_framework.tests;

import in.zipgo.automation_framework.base.Configurations;
import org.testng.annotations.Test;

public class ConfigurationsTest {

    @Test
    public void testAllConfigurations() {
        System.out.println(Configurations.APPIUM_APP);
        System.out.println(Configurations.APPIUM_HUB_URL);
        System.out.println(Configurations.APPIUM_NODE_JS_PATH);
        System.out.println(Configurations.BROWSER);
        System.out.println(Configurations.REMOTE);
        System.out.println(Configurations.TEST_TYPE);
        System.out.println(Configurations.URL);
    }
}
