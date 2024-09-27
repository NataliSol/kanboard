package api.tests;

import api.steps.BaseApiSteps;
import com.codeborne.selenide.Configuration;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static com.codeborne.selenide.WebDriverRunner.closeWebDriver;
import static utils.EnvProperties.BASE_URL;
import static utils.Randomizer.generateRandomNumber;

public class BaseApiTest extends BaseApiSteps {

    protected final String randomValue = generateRandomNumber();
    protected final String TASK_NAME = "TestTask" + randomValue;
    protected final String PROJECT_NAME = "TestProject" + randomValue;
    protected final String IDENTIFIER = "USER" + randomValue;
    protected final String USERNAME = "user" + randomValue;
    protected final String PASSWORD = "TestPassword" + randomValue;

    @BeforeMethod
    public void setUp() {
        Configuration.baseUrl = BASE_URL;
    }

    @AfterMethod(alwaysRun = true)
    public void cleanup() {
        closeWebDriver();
    }

}
