package ui.tests;

import api.steps.UserApiSteps;
import io.qameta.allure.Step;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import ui.pageobjects.LoginPage;
import ui.pageobjects.UserMenu;
import com.codeborne.selenide.WebDriverRunner;
import org.testng.Assert;
import org.testng.annotations.Test;

import static utils.EnvProperties.BASE_URL;


public class LoginTest extends BaseTest {

    @BeforeMethod
    @Step("Setup test data")
    public void prepareDataForTest() {
        userId = userApiSteps.createUser(USERNAME, PASSWORD);
    }

    @AfterMethod(alwaysRun = true)
    @Step("Cleanup test data")
    public void removeUserAfterTest() {
        userApiSteps.deleteUser(userId);
    }

    @Test
    @Step("Positive login")
    public void loginByNewUser() {
        new LoginPage()
                .openLoginPage()
                .loginByUser(USERNAME, PASSWORD)
                .assertMainSectionIsOpened();
    }

    @Test
    @Step("Positive login and redirection to the correct link")
    public void testLoginByNewUserAndCheckUrl() {
        new LoginPage()
                .openLoginPage()
                .loginByUser(USERNAME, PASSWORD);

        Assert.assertEquals(WebDriverRunner.getWebDriver().getCurrentUrl(), BASE_URL + "dashboard",
                "The login wasn't successful");
    }

    @Test
    @Step("Logout action and redirect to login page")
    public void testLogOutPositive() {
        new LoginPage()
                .openLoginPage()
                .loginByUser(USERNAME, PASSWORD);
        new UserMenu().logOut();
        Assert.assertEquals(WebDriverRunner.getWebDriver().getCurrentUrl(), BASE_URL + "login",
                "The login wasn't successful");
    }

    @Test
    @Step("Unsuccessful login attempt does not redirect to the correct url")
    public void testLoginByNewUserNegative() {
        new LoginPage()
                .openLoginPage()
                .loginByUser(USERNAME + ",", PASSWORD + ",");

        Assert.assertNotEquals(WebDriverRunner.getWebDriver().getCurrentUrl(),
                BASE_URL + "dashboard", "the url is wrong");
    }

    @Test
    @Step("Unsuccessful login attempt return alert text")
    public void testAlertTextVisible() {
        new LoginPage()
                .openLoginPage()
                .loginByUser(USERNAME, "wrong");
        String textActual = new LoginPage().returnInfoText();
        String textExpected = "Bad username or password";
        Assert.assertEquals(textActual, textExpected, "Text is wrong");
    }
}