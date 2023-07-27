package ui.tests;

import api.steps.ProjectApiSteps;
import api.steps.UserApiSteps;
import com.codeborne.selenide.Configuration;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;
import static utils.EnvProperties.BASE_URL;
import static utils.Randomizer.generateRandomNumber;

public class BaseTest {
    protected UserApiSteps userApiSteps = new UserApiSteps();
    protected ProjectApiSteps projectApiSteps = new ProjectApiSteps();

    protected String userId;
    protected String projectId;
    protected final String randomValue = generateRandomNumber();
    protected final String TASK_NAME = "TestTask" + randomValue;
    protected final String PROJECT_NAME = "TestProject" + randomValue;
    protected final String IDENTIFIER = "identifier" + randomValue;
    protected final String USERNAME = "user" + randomValue;
    protected final String PASSWORD = "TestPassword" + randomValue;
    protected String comment = "Comment" + randomValue;

    @BeforeMethod
    public void setUp() {
        Configuration.baseUrl = BASE_URL;
    }

    @AfterMethod(alwaysRun = true)
    public void cleanup() {
        closeWebDriver();
    }

}