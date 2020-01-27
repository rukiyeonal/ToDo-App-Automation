package pages;
import base.BasePage;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class TaskDetailPage extends BasePage {

    public TaskDetailPage(AndroidDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "com.example.android.architecture.blueprints.master:id/title_text")
    private List<MobileElement> taskTitles;

    @AndroidFindBy(id = "com.example.android.architecture.blueprints.master:id/add_task_title_edit_text")
    private MobileElement taskTitle;

    @AndroidFindBy(id = "com.example.android.architecture.blueprints.master:id/add_task_description_edit_text")
    private MobileElement taskDescription;

    @AndroidFindBy(id = "com.example.android.architecture.blueprints.master:id/edit_task_fab")
    private MobileElement editTaskFab;

    @AndroidFindBy(id = "com.example.android.architecture.blueprints.master:id/save_task_fab")
    private MobileElement saveTaskFab;

    @AndroidFindBy(accessibility = "Delete task")
    private MobileElement deleteTaskButton;

    @AndroidFindBy(id = "com.example.android.architecture.blueprints.master:id/task_detail_complete_checkbox")
    private MobileElement taskDetailCheckbox;

    public TaskDetailPage tapEditTaskFab() {
        tap(editTaskFab);
        return this;
    }

    public TaskDetailPage tapTaskTitles(int index) {
        tap(taskTitles.get(index));
        return this;
    }

    public TaskDetailPage editTaskTitle() {
        tap(taskTitle);
        type(taskTitle, "This is a edited title.");
        return this;
    }

    public TaskDetailPage editTaskDescription() {
        tap(taskDescription);
        type(taskDescription, "This is a edited description.");
        return this;
    }

    public TaskDetailPage tapSaveTaskFab() {
        tap(saveTaskFab);
        return this;
    }

    public TaskDetailPage tapDeleteTaskButton() {
        tap(deleteTaskButton);
        return this;
    }
}
