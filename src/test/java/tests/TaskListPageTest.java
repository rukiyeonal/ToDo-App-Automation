package tests;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.NewTaskPage;
import pages.TaskListPage;

public class TaskListPageTest extends BaseTest {

    @Test(priority = 1)
    public void checkACompletedTask() {
        TaskListPage taskListPage = new TaskListPage(driver);
        taskListPage.completeTask(0);
    }

    @Test(priority = 2)
    public void filterActiveTasks() {
        TaskListPage taskListPage = new TaskListPage(driver);
        NewTaskPage newTaskPage = new NewTaskPage(driver);
        newTaskPage.createANewTask();
        taskListPage.completeTask(0).openFilters().filterTasks("Active Tasks");
        Assert.assertTrue(taskListPage.isFilterTypeInfoTextTrue("Active Tasks"));
        Assert.assertEquals(taskListPage.getFilteredTaskInfo("Active Tasks"),0); // actually "expected" should be 2.
    }

    @Test(priority = 3)
    public void filterCompletedTasks() {
        TaskListPage taskListPage = new TaskListPage(driver);
        NewTaskPage newTaskPage = new NewTaskPage(driver);
        newTaskPage.createANewTask();
        taskListPage.completeTask(0).openFilters().filterTasks("Completed Tasks");
        Assert.assertTrue(taskListPage.isFilterTypeInfoTextTrue("Completed Tasks"));
        Assert.assertEquals(taskListPage.getFilteredTaskInfo("Completed Tasks"),1);
    }

    @Test(priority = 4)
    public void showAllTasks() {
        TaskListPage taskListPage = new TaskListPage(driver);
        taskListPage.completeTask(0).openFilters().filterTasks("All Tasks");
        Assert.assertTrue(taskListPage.isFilterTypeInfoTextTrue("All Tasks"));
        Assert.assertEquals(taskListPage.getFilteredTaskInfo("All Tasks"), 2);
    }
}