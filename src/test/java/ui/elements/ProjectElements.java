package ui.elements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class ProjectElements {

    protected final SelenideElement form_name() {
        return $("#form-name");
    }

    protected final SelenideElement submit() {
        return $(".btn-blue");
    }

    protected final SelenideElement createButton() {
        return $("[class=\"fa fa-plus fa-fw\"]");
    }

    protected final SelenideElement newProjectButton() {
        return $("#dropdown > ul > li:nth-child(1) > a");
    }
}
