package ui.tests;

import api.steps.ProjectApiSteps;
import api.steps.TaskApiSteps;
import api.steps.UserApiSteps;
import io.qameta.allure.Step;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ui.pageobjects.TaskPage;

import static api.enums.UserRoles.ADMIN;

public class CloseTaskTest extends BaseTest {

    TaskApiSteps taskApiSteps = new TaskApiSteps();
    TaskPage taskPage = new TaskPage();

    private String taskId;

    @BeforeMethod
    @Step("Setup test data")
    public void prepareDataForTest() {
        userId = userApiSteps.createUser(USERNAME, PASSWORD);
        userApiSteps.updateUserRole(userId, ADMIN.getRole());
        projectId = projectApiSteps.createNewProjectAPI(PROJECT_NAME, IDENTIFIER);
        taskId = taskApiSteps.createTaskByAPI(TASK_NAME, Integer.valueOf(projectId));
    }

    @AfterMethod(alwaysRun = true)
    @Step("Cleanup test data")
    public void removeUserAfterTest() {
        taskApiSteps.deleteTask(Integer.valueOf(taskId));
        projectApiSteps.deleteProject(projectId);
        userApiSteps.deleteUser(userId);
    }

    @Test
    @Step("Check test case to close task")
    public void closeTaskPositiveTest() {
        taskPage.openTaskLink(String.valueOf(taskId)).
                loginByUser(USERNAME, PASSWORD);
        taskPage.closeTask().assertMainSectionIsOpened();
    }
}
