package ui.pageobjects;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import ui.elements.TaskElements;

import static utils.EnvProperties.BASE_URL;


public class TaskPage extends TaskElements {

    public LoginPage openProjectBoard(Integer projectId) {
        Selenide.open(BASE_URL + "board/" + projectId);
        return new LoginPage();
    }

    public MainPage openTaskForm(String name) {
        dropdown().shouldBe(Condition.visible).click();
        addTask().shouldBe(Condition.visible).click();
        fillOutTaskForm(name);
        return new MainPage();
    }

    public TaskPage fillOutTaskForm(String name) {
        title().shouldBe(Condition.visible).sendKeys(name);
        submitButton().shouldBe(Condition.visible).click();
        return new TaskPage();
    }

    public MainPage addComment(String commentText) {
        addCommentElement().shouldBe(Condition.visible).click();
        commentField().shouldBe(Condition.visible).sendKeys(commentText);
        saveCommentBtn().shouldBe(Condition.visible).click();
        return new MainPage();
    }

    public LoginPage openTaskLink(String taskId) {
        Selenide.open(BASE_URL + "task/" + taskId);
        return new LoginPage();
    }

    public MainPage closeTask() {
        closeButton().shouldBe(Condition.visible).click();
        confirmButton().shouldBe(Condition.visible).click();
        return new MainPage();
    }

    public MainPage createNewTask(String projectId, String username, String pass, String taskname) {
        openProjectBoard(Integer.valueOf(projectId)).
                loginByUser(username, pass).assertMainSectionIsOpened();
        openTaskForm(taskname);
        return new MainPage();
    }
}
