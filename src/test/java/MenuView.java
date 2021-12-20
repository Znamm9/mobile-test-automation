import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import io.appium.java_client.pagefactory.iOSXCUITFindBy;
import org.openqa.selenium.support.PageFactory;

public class MenuView extends MobileBaseScreen{

    public MenuView(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @iOSXCUITFindBy(iOSNsPredicate = "label == '\uF00C'")
    public MobileElement onShift;

    @iOSXCUITFindBy(iOSNsPredicate = "label == 'Drive'")
    public MobileElement drive;

    @iOSXCUITFindBy(iOSNsPredicate = "label == 'Messages'")
    public MobileElement messages;

    @iOSXCUITFindBy(iOSNsPredicate = "label == 'Shifts'")
    public MobileElement shifts;

    @iOSXCUITFindBy(iOSNsPredicate = "label == 'Earnings'")
    public MobileElement earnings;

    @iOSXCUITFindBy(iOSNsPredicate = "label == 'Performance'")
    public MobileElement performance;

    @iOSXCUITFindBy(iOSNsPredicate = "label == 'Referrals'")
    public MobileElement referrals;

    @iOSXCUITFindBy(iOSNsPredicate = "label == 'Resources'")
    public MobileElement resources;

    @iOSXCUITFindBy(iOSNsPredicate = "label == 'Options'")
    public MobileElement options;

    @iOSXCUITFindBy(iOSNsPredicate = "label == '\uF2F5'")
    public MobileElement logoutImage;

    @iOSXCUITFindBy(iOSNsPredicate = "label == 'Log Out' AND name == 'Log Out' AND type == 'XCUIElementTypeButton'")
    public MobileElement confirmLogout;
}
