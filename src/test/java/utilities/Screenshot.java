package utilities;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.testng.ITestResult;
import java.io.File;
import java.io.IOException;

public class Screenshot {

    public static void invokeScreenshotMethod(ITestResult result, AndroidDriver<MobileElement> driver) throws IOException {
        if (ITestResult.FAILURE == result.getStatus()) {
            File srcFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
            File targetFile = new File("_screenshot_" + result.getName() + ".jpg");
            FileUtils.copyFile(srcFile, targetFile);
        }
    }
}