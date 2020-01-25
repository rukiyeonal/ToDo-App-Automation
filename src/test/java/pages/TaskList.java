package pages;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class TaskList extends BasePage{

    public TaskList(AndroidDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "com.example.android.architecture.blueprints.master:id/complete_checkbox")
    private List<MobileElement> completeCheckbox;

    /*@AndroidFindBy(id = "")
    private MobileElement toastMessage;*/

    private String taskCompletedMessage = "";

    public TaskList tapCheckbox(int index) {
        tap(completeCheckbox.get(index));
        return this;
    }

    /*public Boolean isTaskCompletedMessageExist() {
        return getText(toastMessage);
    }*/
}
