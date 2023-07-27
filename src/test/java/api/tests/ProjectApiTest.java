package api.tests;

import api.steps.ProjectApiSteps;
import api.steps.UserApiSteps;
import io.qameta.allure.Step;
import org.testng.annotations.*;
import ui.pageobjects.LoginPage;


public class ProjectApiTest extends BaseApiTest {
    UserApiSteps userApiSteps = new UserApiSteps();
    ProjectApiSteps projectApiSteps = new ProjectApiSteps();

    private String userId;
    private String projectId;


    @BeforeMethod
    @Step("Setup test data")
    public void prepareDataForTest() {
        userId = userApiSteps.createUser(USERNAME, PASSWORD);
        new LoginPage()
                .openLoginPage()
                .loginByUser(USERNAME, PASSWORD);
    }

    @Test
    @Step("Perform positive API test for project creation")
    public void apiTestForProjectCreation() {
        projectId = projectApiSteps.createNewProjectAPI(PROJECT_NAME,
               IDENTIFIER);
    }

    @AfterMethod(alwaysRun = true)
    @Step("Cleanup test data")
    public void removeDataAfterTest() {
        projectApiSteps.deleteProject(projectId);
        userApiSteps.deleteUser(userId);
    }
}
