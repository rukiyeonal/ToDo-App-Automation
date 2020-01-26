package tests;
import org.testng.annotations.Test;
import pages.NewTaskPage;

public class NewTaskPageTest extends BaseTest{

    @Test
    public void createANewTask() {
        NewTaskPage newTaskPage = new NewTaskPage(driver);
        newTaskPage.tapAddTaskFab().writeTaskTitle().writeTaskDescription().tapSaveTaskFab();
    }
}
