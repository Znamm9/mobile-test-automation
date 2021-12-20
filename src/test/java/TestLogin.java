import org.testng.Assert;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class TestLogin extends MobileTestInit{

    @Parameters({"login"})
    @Test
    public void login(){
        login("driver@zoomer.io", "password");

        Assert.assertTrue(screenManager.getHomeScreen().burgerMenu.isDisplayed());
        Assert.assertTrue(screenManager.getHomeScreen().dropoffs.isDisplayed());
        Assert.assertTrue(screenManager.getHomeScreen().pickups.isDisplayed());
        Assert.assertTrue(screenManager.getHomeScreen().noPickups.isDisplayed());
    }
}
