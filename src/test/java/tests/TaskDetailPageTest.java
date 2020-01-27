package tests;
import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.TaskDetailPage;
import pages.TaskListPage;
import static org.testng.Assert.assertTrue;

public class TaskDetailPageTest extends BaseTest {

    @Test
    public void editTask() {
        TaskDetailPage taskDetailPage = new TaskDetailPage(driver);
        TaskListPage taskListPage = new TaskListPage(driver);
        String title = "This is a edited title.";
        taskDetailPage.tapTaskTitles(0).tapEditTaskFab().editTaskTitle().editTaskDescription().tapSaveTaskFab();
        assertTrue(taskListPage.getTitle(0).equals(title));
    }

    @Test
    public void deleteTask() {
        TaskDetailPage taskDetailPage = new TaskDetailPage(driver);
        TaskListPage taskListPage = new TaskListPage(driver);
        String title = taskListPage.getTitle(0);
        taskDetailPage.tapTaskTitles(0).tapDeleteTaskButton();
        assertTrue(!taskListPage.getTitle(0).equals(title));
    }
}
