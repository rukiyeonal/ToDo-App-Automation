package tests;
import base.BaseTest;
import org.testng.annotations.Test;
import pages.NewTaskPage;
import pages.TaskListPage;
import static org.testng.Assert.assertTrue;

public class NewTaskPageTest extends BaseTest {

    @Test
    public void createANewTask() {
        NewTaskPage newTaskPage = new NewTaskPage(driver);
        TaskListPage taskListPage = new TaskListPage(driver);
        int defaultSize = taskListPage.getTitleListSize();
        newTaskPage.tapAddTaskFab().writeTaskTitle().writeTaskDescription().tapSaveTaskFab();
        int newSize = taskListPage.getTitleListSize();
        assertTrue(defaultSize<newSize);
    }
}
