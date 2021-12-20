import ScreenObjects.HomeScreen;
import ScreenObjects.LoginScreen;
import ScreenObjects.MobileBaseScreen;
import io.appium.java_client.AppiumDriver;

public class ScreenManager extends MobileBaseScreen {

    private LoginScreen loginScreen;
    private HomeScreen homeScreen;

    ScreenManager(AppiumDriver driver) {
        super(driver);
    }

    public LoginScreen getLoginScreenView(){
        if (loginScreen == null){
            loginScreen = new LoginScreen(driver);
        }
        return loginScreen;
    }

    public HomeScreen getHomeScreen(){
        if (homeScreen == null){
            homeScreen = new HomeScreen(driver);
        }
        return homeScreen;
    }
}
