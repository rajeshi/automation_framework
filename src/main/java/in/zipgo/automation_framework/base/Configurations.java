package in.zipgo.automation_framework.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Properties;

public class Configurations {

    public static final String URL = getProp().getProperty("zipgo.web.url");//"https://beta.zipgo.in/sign_in";
    public static final String BROWSER = getProp().getProperty("zipgo.browser");//"ANDROID";
    public static final boolean REMOTE = Boolean.parseBoolean(getProp().getProperty("zipgo.remote"));//false;
    public static String TEST_TYPE = getProp().getProperty("zipgo.test_type");//"MOBILE";
    public static String APPIUM_NODE_PATH = getProp().getProperty("zipgo.appium_node_path"); //"C:\\Program Files\\Appium\\node.exe";
    public static String APPIUM_NODE_JS_PATH = getProp().getProperty("zipgo.appium_node_js_path");//"C:\\Users\\Rajesh\\AppData\\Roaming\\npm\\node_modules\\appium\\lib\\main.js";
    public static String APPIUM_HUB_URL = getProp().getProperty("zipgo.appium_hub_url");//"http://127.0.0.1:4723/wd/hub";
    public static String APPIUM_APP = getProp().getProperty("zipgo.appium.appium_app");//"E:\\Projects\\Upwork\\ZipGo\\driver-beta-debug.apk";
    public static boolean CAPTURE_HTTP_TRAFFIC = Boolean.parseBoolean(getProp().getProperty("zipgo.capture.http_traffic"));
    public static long TIME_OUT_SECONDS = Long.parseLong(getProp().getProperty("zipgo.timeout.seconds"));
    public static String CHROME_DRIVER_EXE = getProp().getProperty("zipgo.chrome.driver");
    public static String FIREFOX_DRIVER_EXE = getProp().getProperty("zipgo.gecko.driver");
    public static String IE_DRIVER_EXE = getProp().getProperty("zipgo.ie.driver");

    private static Properties prop;
    private static HashMap<String, String> urlMap;

    private static Properties getProp() {

        if (prop == null) {
            prop = new Properties();
            InputStream input = null;

            try {
                input = new FileInputStream(new File(Res.getResource("system.properties").toURI()));
                prop.load(input);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return prop;
    }
}
