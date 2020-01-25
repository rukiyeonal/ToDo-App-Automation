package tests;
import org.testng.annotations.Test;
import pages.TaskList;

public class TaskListTest extends BaseTest{

    @Test
    public void checkCompleteTasksToastMessage() {
        TaskList taskList = new TaskList(driver);
        taskList.tapCheckbox(0);
    }
}
