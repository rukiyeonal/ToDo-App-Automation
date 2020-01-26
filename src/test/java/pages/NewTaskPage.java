package pages;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;

public class NewTaskPage extends BasePage{

    public NewTaskPage(AndroidDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "com.example.android.architecture.blueprints.master:id/add_task_fab")
    private MobileElement addTaskFab;

    @AndroidFindBy(id = "com.example.android.architecture.blueprints.master:id/add_task_title_edit_text")
    private MobileElement taskTitle;

    @AndroidFindBy(id = "com.example.android.architecture.blueprints.master:id/add_task_description_edit_text")
    private MobileElement taskDescription;

    @AndroidFindBy(id = "com.example.android.architecture.blueprints.master:id/save_task_fab")
    private MobileElement saveTaskFab;

    public NewTaskPage tapAddTaskFab() {
        tap(addTaskFab);
        return this;
    }

    public NewTaskPage writeTaskTitle() {
        tap(taskTitle);
        type(taskTitle, "This is a title.");
        return this;
    }

    public NewTaskPage writeTaskDescription() {
        tap(taskDescription);
        type(taskDescription, "This is a description.");
        return this;
    }

    public NewTaskPage tapSaveTaskFab() {
        tap(saveTaskFab);
        return this;
    }

    public void createANewTask() {
        NewTaskPage newTaskPage = new NewTaskPage(driver);
        newTaskPage.tapAddTaskFab().writeTaskTitle().writeTaskDescription().tapSaveTaskFab();
    }
}
