package ui.tests;

import api.steps.ProjectApiSteps;
import api.steps.UserApiSteps;
import io.qameta.allure.Step;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ui.pageobjects.LoginPage;
import ui.pageobjects.ProjectPage;
import com.codeborne.selenide.WebDriverRunner;
import org.testng.annotations.Test;

import java.time.Duration;

public class ProjectTest extends BaseTest {
    Duration timeoutDuration = Duration.ofSeconds(10);

    public static String extractValueFromURL(String url) {
        String prefix = "http://localhost/project/";
        if (url.startsWith(prefix)) {
            return url.substring(prefix.length());
        } else {
            throw new IllegalArgumentException("URL does not start with the expected prefix.");
        }
    }


    @BeforeMethod
    @Step("Setup data for test")
    public void prepareDataForTest() {
        userId = userApiSteps.createUser(USERNAME, PASSWORD);
    }

    @AfterMethod(alwaysRun = true)
    @Step("Cleanup test data")
    public void removeUserAfterTest() {
        projectApiSteps.deleteProject(projectId);
        userApiSteps.deleteUser(userId);
    }

    @Test
    @Step("Verify the creation a new project and redirect to project page")
    public void createNewProjectPositive() {
        new LoginPage()
                .openLoginPage()
                .loginByUser(USERNAME, PASSWORD);
        new ProjectPage().createNewProjectUI(PROJECT_NAME);

        WebDriverWait wait = new WebDriverWait(WebDriverRunner.getWebDriver(), timeoutDuration);
        wait.until(ExpectedConditions.urlContains("http://localhost/project"));

        String currentURL = WebDriverRunner.getWebDriver().getCurrentUrl();
        projectId = extractValueFromURL(currentURL);

        Assert.assertTrue(currentURL.contains("http://localhost/project"),"The URL link is wrong");
    }
}
