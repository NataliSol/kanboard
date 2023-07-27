package ui.elements;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;

public class LoginElements {
    protected final SelenideElement usernameField() {
        return $("#form-username");
    }

    protected final SelenideElement passwordField() {
        return $("#form-password");
    }

    protected final SelenideElement submitButton() {
        return $(".btn-blue");
    }

    protected final SelenideElement alertInfo() {
        return $(".alert-error");
    }

    protected final SelenideElement avatar_letter = $(".avatar-letter");
    protected final SelenideElement logoutButton = $("div#dropdown a[href='/logout']");

}
