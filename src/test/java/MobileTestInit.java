import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import io.appium.java_client.ios.IOSDriver;
import io.appium.java_client.ios.IOSElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.concurrent.TimeUnit;

public class MobileTestInit {

    public String configJson = getJsonAsString("src/test/resources/browserstack.config.json");

    private static final int IMPLICIT_WAIT = 20;
    //    Apps
    String driversAndroidApp = getJsonValues(configJson, "androidApp");
    String driversIOSApp = getJsonValues(configJson, "iOSApp");
    String BROWSERSTACK_USERNAME = getJsonValues(configJson, "BROWSERSTACK_USERNAME");
    String BROWSERSTACK_ACCESS_KEY = getJsonValues(configJson, "BROWSERSTACK_ACCESS_KEY");


    public String getJsonAsString(String location){
        String jsonAsString = null;
        try {
            jsonAsString = new String(Files.readAllBytes(Paths.get(location)));
        } catch (IOException e) {
            e.printStackTrace();
        }
        return jsonAsString;
    }

    public String getJsonValues(String stringifyJson, String key){
        if (System.getenv(key) != null){
            return System.getenv("BROWSERSTACK_ACCESS_KEY");
        }

        ObjectMapper objectMapper = new ObjectMapper();
        JsonNode jsonNode = null;
        try {
            jsonNode = objectMapper.readTree(stringifyJson);
        } catch (JsonProcessingException e) {
            System.out.println("bad JSON for parsing");
            e.printStackTrace();
        }
        return jsonNode.get(key).asText();
    }

    public AppiumDriver driver;
    ScreenManager screenManager;

    @AfterMethod
    public void tearDown(){
        driver.quit();
    }

    @BeforeMethod
    public void setUp() {
        if (isIOSRun() && isBrowserStackRun()){
            setupBrowserstackForIOS();
        }else if (isAndroidRun() && isBrowserStackRun()){
            setupBrowserstackForAndroid();
        }else if (isIOSRun() && !isBrowserStackRun()){
            setupLocalIOSRun();
        }else if (isAndroidRun() && !isBrowserStackRun()){
            setupLocalAndroidRun();
        }else {
            new Error("no mobile platform specified!!! please indicate platform as your system variable");
        }
        screenManager = new ScreenManager(driver);
    }

    private void setupLocalAndroidRun() {

    }

    private void setupLocalIOSRun() {

    }

    public boolean isBrowserStackRun(){
        return System.getenv("browserstack") != null ? System.getenv("browserstack").contains("true") : false;
    }

    public void setupBrowserstackForAndroid() {

        DesiredCapabilities caps = new DesiredCapabilities();

        // Set your access credentials
        caps.setCapability("browserstack.user", BROWSERSTACK_USERNAME);
        caps.setCapability("browserstack.key", BROWSERSTACK_ACCESS_KEY);

        // Set URL of the application under test
        caps.setCapability("app", driversAndroidApp);

        // Specify device and os_version for testing
        caps.setCapability("device", "Google Pixel 3");
        caps.setCapability("os_version", "9.0");

        // Set other BrowserStack capabilities
        caps.setCapability("project", "First Java Project");
        caps.setCapability("build", "Java Android");
        caps.setCapability("name", "first_test");


        // Initialise the remote Webdriver using BrowserStack remote URL
        // and desired capabilities defined above
        try {
            driver = new AndroidDriver<AndroidElement>(
                    new URL("http://hub.browserstack.com/wd/hub"), caps);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public void setupBrowserstackForIOS() {
        DesiredCapabilities caps = new DesiredCapabilities();

        // Set your access credentials
        caps.setCapability("browserstack.user", BROWSERSTACK_USERNAME);
        caps.setCapability("browserstack.key", BROWSERSTACK_ACCESS_KEY);

        // Set URL of the application under test
        caps.setCapability("app", driversIOSApp);

        // Specify device and os_version for testing
        caps.setCapability("device", "iPhone XS");
        caps.setCapability("os_version", "12");

        // Set other BrowserStack capabilities
        caps.setCapability("autoDismissAlerts", true);
        caps.setCapability("autoAcceptAlerts", true);
        caps.setCapability("project", "First Java Project");
        caps.setCapability("build", "Java iOS");
        caps.setCapability("name", "first_test");


        // Initialise the remote Webdriver using BrowserStack remote URL
        // and desired capabilities defined above
        try {
            driver = new IOSDriver<IOSElement>(
                    new URL("http://hub-cloud.browserstack.com/wd/hub"), caps);
            driver.manage().timeouts().implicitlyWait(IMPLICIT_WAIT, TimeUnit.SECONDS);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }

    public boolean isAndroidRun() {
        if (System.getenv("platform") != null){
            return System.getenv("platform").toLowerCase().contains("android");
        }else {
            return false;
        }
    }

    public boolean isIOSRun() {
        if (System.getenv("platform") != null){
            return System.getenv("platform").toLowerCase().contains("ios");
        }else {
            return false;
        }
    }

    public void login(String username, String pass){
        screenManager.getLoginScreenView().loginField.sendKeys(username);
        screenManager.getLoginScreenView().passwordField.sendKeys(pass);
        screenManager.getLoginScreenView().loginButton.click();
    }
}
