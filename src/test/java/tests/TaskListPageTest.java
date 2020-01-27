package tests;
import base.BaseTest;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.NewTaskPage;
import pages.TaskListPage;
import static org.assertj.core.api.Assertions.assertThat;
import static org.testng.Assert.assertTrue;

public class TaskListPageTest extends BaseTest {

    @Test(priority = 1)
    public void checkACompletedTask() {
        int taskIndex = 0;
        TaskListPage taskListPage = new TaskListPage(driver);
        boolean isChecked = taskListPage.completeTask(taskIndex).isChecked(taskIndex);
        assertTrue(isChecked);
    }

    @Test(priority = 2)
    public void checkActiveTasksTitle() {
        String filter = "Active Tasks";
        TaskListPage taskListPage = new TaskListPage(driver);
        NewTaskPage newTaskPage = new NewTaskPage(driver);
        newTaskPage.tapAddTaskFab().writeTaskTitle().writeTaskDescription().tapSaveTaskFab();
        taskListPage.completeTask(0).openFilters().filterTasks(filter);
        assertThat(taskListPage.isFilterTypeInfoTextTrue(filter)).isTrue();
    }

    @Test(priority = 3)
    public void checkCompletedTasksNumber() {
        String filter = "Completed Tasks";
        TaskListPage taskListPage = new TaskListPage(driver);
        NewTaskPage newTaskPage = new NewTaskPage(driver);
        newTaskPage.tapAddTaskFab().writeTaskTitle().writeTaskDescription().tapSaveTaskFab();
        taskListPage.completeTask(0).openFilters().filterTasks(filter);
        assertThat(taskListPage.getFilteredTaskInfo(filter)).isEqualTo(1);
    }

    @Test(priority = 4)
    public void checkCompletedTasksTitle() {
        String filter = "Completed Tasks";
        TaskListPage taskListPage = new TaskListPage(driver);
        NewTaskPage newTaskPage = new NewTaskPage(driver);
        newTaskPage.tapAddTaskFab().writeTaskTitle().writeTaskDescription().tapSaveTaskFab();
        taskListPage.completeTask(0).openFilters().filterTasks(filter);
        assertThat(taskListPage.isFilterTypeInfoTextTrue(filter)).isTrue();
    }

    @Test(priority = 7)
    public void checkAllTasksNumber() {
        String filter = "All Tasks";
        TaskListPage taskListPage = new TaskListPage(driver);
        taskListPage.completeTask(0).openFilters().filterTasks(filter);
        assertThat(taskListPage.getFilteredTaskInfo(filter)).isEqualTo(2);
    }

    @Test(priority = 6)
    public void checkAllTasksTitle() {
        String filter = "All Tasks";
        TaskListPage taskListPage = new TaskListPage(driver);
        taskListPage.completeTask(0).openFilters().filterTasks(filter);
        assertThat(taskListPage.isFilterTypeInfoTextTrue(filter)).isTrue();
    }

    /* this test is designed to show screenshot.
    * actually, the assertion should be equal to 2. */
    @Test(priority = 5)
    public void checkActiveTasksNumber() {
        String filter = "Active Tasks";
        TaskListPage taskListPage = new TaskListPage(driver);
        NewTaskPage newTaskPage = new NewTaskPage(driver);
        newTaskPage.tapAddTaskFab().writeTaskTitle().writeTaskDescription().tapSaveTaskFab();
        taskListPage.completeTask(0).openFilters().filterTasks(filter);
        assertThat(taskListPage.getFilteredTaskInfo(filter)).isEqualTo(0);
    }
}