# ToDoApp - Test Automation with Appium using Maven Framework  
  
### Dependency Info
Checked the versions of these Maven dependencies from [this](https://mvnrepository.com/) link.
- appium 
- selenium  
- testng  
- assertj  
  
<p>E.g. Added this dependency to pom.xml</p>
<pre>
&lt;dependency</span>&gt;  
    &lt;<span class="pl-ent">groupId</span>&gt;io.appium&lt;/<span class="pl-ent">groupId</span>&gt;  
    &lt;<span class="pl-ent">artifactId</span>&gt;java-client&lt;/<span class="pl-ent">artifactId</span>&gt;  
    &lt;<span class="pl-ent">version</span>&gt;latest commit ID from master branch&lt;/<span class="pl-ent">version</span>&gt;  
&lt;/<span class="pl-ent">dependency</span>&gt;
</pre>  
  
---  
### Pages  
ToDo app has some screens for listing tasks, seeing details of tasks and creating a new task.   
- **BasePage:** has it's own <code>tap</code>, <code>read</code> and <code>type</code> functions.  
- **NewTaskPage:** <code>tapAddTaskFab</code>, <code>writeTaskTitle</code>, <code>writeTaskDescription</code>, <code>tapSaveTaskFab</code> and <code>createANewTask</code> functions are here.  
- **TaskDetailPage:** This page's functions are <code>tapEditTaskFab</code>, <code>tapTaskTitles</code>, <code>editTaskTitle</code>, <code>editTaskDescription</code>, <code>tapSaveTaskFab</code>, <code>tapDeleteTaskButton</code>.  
- **TaskListPage:** <code>completeTask</code>, <code>openFilters</code>, <code>filterTasks</code>, <code>isFilterTypeInfoTextTrue</code>, <code>getFilteredTaskInfo</code>  
---  
### Tests
- **BaseTest:** This test class has <code>setup</code> and <code>tearDown</code> methods. In setup, *desiredCapabilities* and *driver* initialized. In tearDown, you will have a <code>screenshot</code> if a test fails.  
- **NewTaskPageTest:** Opens a new task.   
- **TaskDetailPageTest:** Edits and deletes tasks.  
- **TaskListPageTest:** Filters all, active and completed tasks. Check/uncheck their checkboxes.  
---  
### Run  
 1. Checkout the *master* branch  
 2. Convert project as *Maven* project  
 3. Run command mvn clean install (may not necessary)  
 4. Change device capabilities as the connected android device in BaseTest.java  
 5. Run Appium in the background  
 6. Run the Tests in *tests* folder
