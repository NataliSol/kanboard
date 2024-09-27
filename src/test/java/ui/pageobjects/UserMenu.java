package ui.pageobjects;

import com.codeborne.selenide.Condition;

public class UserMenu extends LoginPage {

    public MainPage logOut() {
        avatar_letter.shouldBe(Condition.visible).click();
        logoutButton.shouldBe(Condition.visible).click();
        return new MainPage();
    }
}
