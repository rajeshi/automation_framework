package in.zipgo.automation_framework.base;

import io.appium.java_client.service.local.AppiumDriverLocalService;
import io.appium.java_client.service.local.AppiumServiceBuilder;
import io.appium.java_client.service.local.flags.ServerArgument;
import java.io.File;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class AppiumServer {

    private static AppiumDriverLocalService service;

    public static void startServer(String hubUrl) {

        try {
            if (!isServerRunning(hubUrl)) {
                URL url = null;

                url = new URL(hubUrl);

                service = AppiumDriverLocalService.buildService(new AppiumServiceBuilder()
                        // APPIUM_HOME
                        // .usingDriverExecutable(new File("c:/Program Files
                        // (x86)/Appium/node.exe"))
                        .usingDriverExecutable(new File(Configurations.APPIUM_NODE_PATH))
                        .withAppiumJS(new File(Configurations.APPIUM_NODE_JS_PATH))
                        // new File("C:\\Program Files
                        // (x86)\\Appium\\node_modules\\appium\\lib\\server\\main.js"))
                        .withIPAddress(url.getHost()).usingPort(url.getPort())
                );
                // service.addOutPutStream(System.out);
                service.start();
            } else {
            }
        } catch (MalformedURLException e) {
        } catch (Throwable e) {
            e.printStackTrace();
        }
    }

    public static void stopServer() {
        if (service != null) {
            service.stop();
        }
    }

    public static URL getHubUrl() {
        return service.getUrl();
    }

    private static boolean isServerRunning(String hubUrl) {

        HttpURLConnection openConnection;
        try {
            URL url = new URL(hubUrl + "/status");
            openConnection = (HttpURLConnection) url.openConnection();
            openConnection.connect();
            return openConnection.getResponseMessage().equalsIgnoreCase("ok");
        } catch (java.net.ConnectException ex) {
            return false;
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }
}

class ServerLogLevelArgument implements ServerArgument {

    @Override
    public String getArgument() {
        return "--log-level ";
    }
}
