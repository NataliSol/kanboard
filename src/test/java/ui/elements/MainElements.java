package ui.elements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class MainElements {
    public SelenideElement mainSection() {
        return $("#main");
    }
}