package tests;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utilities.Screenshot;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class BaseTest{

    public AndroidDriver<MobileElement> driver;
    public WebDriverWait wait;

    @BeforeMethod
    public void setup() throws MalformedURLException {
        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setCapability("deviceName", "Pixel 3 XL API 29");
        caps.setCapability("udid", "emulator-5554"); //DeviceId from "adb devices" command
        caps.setCapability("platformName", "Android");
        caps.setCapability("platformVersion", "10.0");
        caps.setCapability("skipUnlock", "true");
        caps.setCapability("appPackage", "com.example.android.architecture.blueprints.master");
        caps.setCapability("appActivity", "com.example.android.architecture.blueprints.todoapp.tasks.TasksActivity");
        caps.setCapability("noReset", "false");
        driver = new AndroidDriver<MobileElement>(new URL("http://127.0.0.1:4723/wd/hub"), caps);
        wait = new WebDriverWait(driver, 999999);
    }

    @AfterMethod
    public void teardown(ITestResult result) throws IOException {
        Screenshot.invokeScreenshotMethod(result, driver);
        driver.quit();
    }
}
