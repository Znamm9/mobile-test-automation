package ScreenObjects;

import io.appium.java_client.AppiumDriver;

public class MobileBaseScreen {

    public AppiumDriver driver;

    public MobileBaseScreen(AppiumDriver driver){
        this.driver = driver;
    }
}
