package ScreenObjects;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginScreen extends MobileBaseScreen {

    public LoginScreen(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @iOSXCUITFindBy(iOSNsPredicate = "value == 'Your email address'")
    @AndroidFindBy(xpath = "//android.view.View[1]/android.view.View[1]/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText")
    public MobileElement loginField;

    @iOSXCUITFindBy(iOSNsPredicate = "value == 'Your password'")
    @AndroidFindBy(xpath = "//android.view.View[1]/android.view.View[1]/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText")
    public MobileElement passwordField;

    @iOSXCUITFindBy(iOSNsPredicate = "label == 'Login'")
    @AndroidFindBy(xpath = "//android.view.View[1]/android.view.View[1]/android.view.View/android.view.View/android.view.View/android.view.View/android.widget.EditText")
    public MobileElement loginButton;
}
