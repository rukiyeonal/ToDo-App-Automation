package tests;
import org.testng.annotations.Test;
import pages.TaskDetailPage;

public class TaskDetailPageTest extends BaseTest{

    @Test
    public void openAndEditTask() {
        TaskDetailPage taskDetailPage = new TaskDetailPage(driver);
        taskDetailPage.tapTaskTitles(0).tapEditTaskFab().editTaskTitle().editTaskDescription().tapSaveTaskFab();
    }

    @Test
    public void deleteATask() {
        TaskDetailPage taskDetailPage = new TaskDetailPage(driver);
        taskDetailPage.tapTaskTitles(0).tapDeleteTaskButton();
    }
}
