package ScreenObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.PageFactory;

public class HomeScreen extends MobileBaseScreen {

    public HomeScreen(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @iOSXCUITFindBy(iOSNsPredicate = "label == 'Warning'")
    public MobileElement warning;

    @iOSXCUITFindBy(iOSNsPredicate = "label == 'I Agree'")
    public MobileElement iAgreeButton;

    @iOSXCUITFindBy(iOSNsPredicate = "label == 'OFF SHIFT'")
    public MobileElement offShift;

    @iOSXCUITFindBy(iOSNsPredicate = "label == 'ON SHIFT'")
    public MobileElement onShift;

    @iOSXCUITFindBy(iOSNsPredicate = "label == 'menu'")
    public MobileElement burgerMenu;

    @iOSXCUITFindBy(iOSNsPredicate = "label == '\uF291 Pickups'")
    public MobileElement pickups;

    @iOSXCUITFindBy(iOSNsPredicate = "label == '\uF1B9 Dropoffs'")
    public MobileElement dropoffs;

    @iOSXCUITFindBy(iOSNsPredicate = "label == 'No pickups! Pull down to reload.'")
    public MobileElement noPickups;

    @iOSXCUITFindBy(iOSNsPredicate = "label == 'Start Shift'")
    public MobileElement startShiftButton;

    public boolean isOnShiftOrOffShiftDisplayed() {
        try {
            return offShift.isDisplayed();
        }catch (Exception e){
            return onShift.isDisplayed();
        }
    }
}
