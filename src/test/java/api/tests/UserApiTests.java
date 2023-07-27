package api.tests;

import api.steps.UserApiSteps;
import org.testng.annotations.Test;

public class UserApiTests {
    UserApiSteps userApiSteps = new UserApiSteps();
    private String userId;

    @Test
    public void create() {
        userId = userApiSteps.createUser("USERNAME", "PASSWORD");
    }

    @Test
    public void getUserTest() {
        userApiSteps.getUserByName("USERNAME");
    }

    @Test
    public void getUserByIDTest() {
        userApiSteps.getUserInfo("61");
    }

    @Test
    public void getAllUserTest() {
        userApiSteps.getAllUsers();
    }
}
