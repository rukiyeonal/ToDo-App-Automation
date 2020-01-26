package pages;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import java.util.concurrent.TimeUnit;

public class BasePage {

    protected WebDriverWait wait;
    protected AndroidDriver<MobileElement> driver;

    public BasePage(AndroidDriver driver) {
        this.driver = driver;
        wait = new WebDriverWait(driver, 5);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    protected void tap(MobileElement element) {
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
    }

    protected String readText(MobileElement element) {
        return wait.until(ExpectedConditions.visibilityOf(element)).getText();
    }

    protected void type(MobileElement element, String s){
        wait.until(ExpectedConditions.elementToBeClickable(element)).click();
        element.setValue(s);
    }
}
