package api.tests;

import api.steps.ProjectApiSteps;
import api.steps.TaskApiSteps;
import api.steps.UserApiSteps;
import io.qameta.allure.Step;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ui.pageobjects.LoginPage;
import ui.pageobjects.TaskPage;


public class TaskApiTests extends BaseApiTest {
    UserApiSteps userApiSteps = new UserApiSteps();
    ProjectApiSteps projectApiSteps = new ProjectApiSteps();
    TaskApiSteps taskApiSteps = new TaskApiSteps();
    TaskPage taskPage = new TaskPage();

    private String userId;
    private String projectId;
    private String taskId;


    @BeforeMethod
    @Step("Setup test data")
    public void prepareDataForTest() {
        userId = userApiSteps.createUser(USERNAME, PASSWORD);
        new LoginPage()
                .openLoginPage()
                .loginByUser(USERNAME, PASSWORD);
        projectId = projectApiSteps.createNewProjectAPI(PROJECT_NAME,
               IDENTIFIER);
    }

    @Test
    @Step("Perform positive API test for task creation")
    public void apiTestForTaskCreation() {

        taskId = taskApiSteps.createTaskByAPI(TASK_NAME, Integer.valueOf(projectId));
    }

    @AfterMethod(alwaysRun = true)
    @Step("Cleanup test data")
    public void removeDataAfterTest() {
        taskApiSteps.deleteTask(Integer.valueOf(taskId));
        projectApiSteps.deleteProject(projectId);
        userApiSteps.deleteUser(userId);
    }
}
