package ui.pageobjects;

import com.codeborne.selenide.Condition;
import ui.elements.MainElements;

public class MainPage extends MainElements {

    public MainPage assertMainSectionIsOpened() {
        mainSection().shouldBe(Condition.visible);
        return this;
    }
}
