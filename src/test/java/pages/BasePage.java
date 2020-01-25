package pages;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {
    protected WebDriverWait wait;
    protected AndroidDriver<MobileElement> driver;

    public BasePage(AndroidDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 10);
    }

    protected void tap(MobileElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    protected String getText(MobileElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element)).getText();
    }

    //type
    //swipe
}
