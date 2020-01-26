package pages;
import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.pagefactory.AndroidFindBy;
import io.appium.java_client.pagefactory.AppiumFieldDecorator;
import org.openqa.selenium.support.PageFactory;
import java.util.List;

public class TaskListPage extends BasePage {

    public TaskListPage(AndroidDriver driver) {
        super(driver);
        PageFactory.initElements(new AppiumFieldDecorator(driver), this);
    }

    @AndroidFindBy(id = "com.example.android.architecture.blueprints.master:id/complete_checkbox")
    private List<MobileElement> completeCheckboxs;

    @AndroidFindBy(id = "com.example.android.architecture.blueprints.master:id/title_text")
    private List<MobileElement> taskTitles;

    @AndroidFindBy(accessibility = "Filter")
    private MobileElement filterButton;

    @AndroidFindBy(id = "com.example.android.architecture.blueprints.master:id/filtering_text")
    private MobileElement filterTypeInfoText;

    @AndroidFindBy(id = "com.example.android.architecture.blueprints.master:id/title")
    private List<MobileElement> filterTitles;

    public TaskListPage completeTask(int index) {
        tap(completeCheckboxs.get(index));
        return this;
    }

    public TaskListPage openFilters() {
        tap(filterButton);
        return this;
    }

    public TaskListPage filterTasks(String selectedFilter) {

        if (selectedFilter.equals("All Tasks")) {
            tap(filterTitles.get(0));
        } else if (selectedFilter.equals("Active Tasks")) {
            tap(filterTitles.get(1));
        } else if (selectedFilter.equals("Completed Tasks")) {
            tap(filterTitles.get(2));
        }
        return this;
    }

    public boolean isFilterTypeInfoTextTrue(String selectedFilter) {
        if (selectedFilter.equals(readText(filterTypeInfoText))) {
            return true;
        } else
            return false;
    }

    public int getFilteredTaskInfo(String selectedFilter){
        List<MobileElement> checkboxesOfTasks = completeCheckboxs;
        int totalTaskCount = 0;
        int completedTaskCount = 0;
        for (MobileElement checkbox : checkboxesOfTasks){
            totalTaskCount += 1;
            if (checkbox.getAttribute("checked").equals("true")){
                completedTaskCount += 1;
            }
        }
        int activeTaskCount = totalTaskCount-completedTaskCount;
        if(selectedFilter.equals("All Tasks")){
            return totalTaskCount;
        } else if(selectedFilter.equals("Active Tasks")){
            return activeTaskCount;
        } else if (selectedFilter.equals("Completed Tasks")){
            return completedTaskCount;
        }
        return totalTaskCount;
    }
}
