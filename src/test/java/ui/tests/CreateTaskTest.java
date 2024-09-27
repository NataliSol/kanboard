package ui.tests;

import api.steps.ProjectApiSteps;
import api.steps.TaskApiSteps;
import api.steps.UserApiSteps;
import io.qameta.allure.Step;
import org.testng.annotations.*;
import ui.pageobjects.TaskPage;

import static api.enums.UserRoles.ADMIN;
import static utils.Randomizer.generateRandomNumber;

public class CreateTaskTest extends BaseTest {

    @BeforeMethod
    @Step("Setup test data")
    public void prepareDataForTest() {
        userId = userApiSteps.createUser(USERNAME, PASSWORD);
        userApiSteps.updateUserRole(userId, ADMIN.getRole());
        projectId = projectApiSteps.createNewProjectAPI(PROJECT_NAME, IDENTIFIER);
    }

    @AfterMethod(alwaysRun = true)
    @Step("Cleanup test data")
    public void removeUserAfterTest() {
        projectApiSteps.deleteProject(projectId);
        userApiSteps.deleteUser(userId);
    }

    @Test
    @Step("Verify the creation of a new task")
    public void createNewTaskPositive() {
        new TaskPage()
                .createNewTask(projectId, USERNAME, PASSWORD, TASK_NAME)
                .assertMainSectionIsOpened();
    }

    @Test
    public void createNewTaskPositiveAPI() {
        new TaskPage()
                .createNewTask(projectId, USERNAME, PASSWORD, TASK_NAME)
                .assertMainSectionIsOpened();
    }

    @Test
    public void getTasksAPI() {
        new TaskPage()
                .createNewTask(projectId, USERNAME, PASSWORD, TASK_NAME)
                .assertMainSectionIsOpened();
    }
}
