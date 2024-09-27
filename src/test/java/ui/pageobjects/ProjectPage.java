package ui.pageobjects;

import com.codeborne.selenide.Condition;
import ui.elements.ProjectElements;


public class ProjectPage extends ProjectElements {
    public void createNewProjectUI(String name) {
        createButton().shouldBe(Condition.visible).click();
        newProjectButton().shouldBe(Condition.visible).click();
        fillOutForm(name);
    }

    public void fillOutForm(String name) {
        form_name().shouldBe(Condition.visible).sendKeys(name);
        submit().shouldBe(Condition.visible).click();
    }

}
