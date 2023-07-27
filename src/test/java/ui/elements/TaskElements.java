package ui.elements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class TaskElements {

    protected final SelenideElement title() {
        return $("#form-title");
    }

    protected final SelenideElement submitButton() {
        return $("button[type=submit]");
    }

    protected final SelenideElement dropdown() {
        return $("[class='fa fa-cog']");
    }


    protected final SelenideElement saveCommentBtn() {
        return $x("//*[@id='modal-content']/form/div[2]/div/button");
    }

    protected final SelenideElement addTask() {
        return $x("//ul[@class='dropdown-submenu-open']//li[4]");
    }

    protected final SelenideElement confirmButton() {
        return $("#modal-confirm-button");
    }

    protected final SelenideElement closeButton() {
        return $x("//a[text()='Close this task']");
    }

    protected final SelenideElement addCommentElement() {
        return $(byText("Add a comment"));
    }

    public final SelenideElement commentField() {
        return $x("//*[@id=\"modal-content\"]/form/div[1]/div/div[2]/textarea");
    }
}
