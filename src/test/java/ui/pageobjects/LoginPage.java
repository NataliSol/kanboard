package ui.pageobjects;

import com.codeborne.selenide.Condition;
import ui.elements.LoginElements;

import static com.codeborne.selenide.Selenide.open;
import static utils.EnvProperties.BASE_URL;
;

public class LoginPage extends LoginElements {


    public LoginPage openLoginPage() {
        open(BASE_URL + "login");
        return new LoginPage();
    }

    public MainPage loginByUser(String username, String password) {
        openLoginPage();
        usernameField().shouldBe(Condition.visible).sendKeys(username);
        passwordField().shouldBe(Condition.visible).sendKeys(password);
        submitButton().shouldBe(Condition.visible).click();
        return new MainPage();
    }

    public String returnInfoText() {
        return alertInfo().shouldBe(Condition.visible).getText();
    }
}