package api.steps;

import api.models.args.users.*;
import io.restassured.response.Response;
import api.models.Result;
import api.models.args.BodyArgs;

import static api.enums.UserRoles.USER;
import static api.methods.Users.*;
import static utils.EnvProperties.API_TOKEN;
import static utils.EnvProperties.API_USERNAME;

public class UserApiSteps extends BaseApiSteps {
    public String createUser(String username, String pass) {
        CreateUser args = CreateUser.builder()
                .username(username)
                .name(username)
                .password(pass)
                .email(username + "@mail.com")
                .role(USER.getRole())
                .build();

        BodyArgs bodyArgs = BodyArgs.builder().
                params(args)
                .method(CREATE_USER)
                .build();

        Response response = postRequest(API_USERNAME, API_TOKEN, bodyArgs);
        response.then().statusCode(200);
        Result result = response.as(Result.class);
        return result.getResult().toString();
    }

    public void getUserByName(String namea) {

        BodyArgs bodyArgs = BodyArgs.builder()
                .params(new UserName(namea))
                .method(GET_USER_BY_NAME)
                .build();
        Response response = postRequest(API_USERNAME, API_TOKEN, bodyArgs);
        response.then().statusCode(200);
        response.prettyPrint();
    }

    public void getUserInfo(String userId) {
        BodyArgs bodyArgs = BodyArgs.builder()
                .params(new UserId(Integer.valueOf(userId)))
                .method(GET_USER)
                .build();
        Response response = postRequest(API_USERNAME, API_TOKEN, bodyArgs);
        response.then().statusCode(200);
        response.prettyPrint();
    }

    public void getAllUsers() {
        BodyArgs bodyArgs = BodyArgs.builder()
                .method(GET_ALL_USER)
                .build();
        Response response = postRequest(API_USERNAME, API_TOKEN, bodyArgs);
        response.then().statusCode(200);
        response.prettyPrint();
    }

    public boolean deleteUser(String userId) {
Integer userIdInt=Integer.valueOf(userId);
        BodyArgs bodyArgs = BodyArgs.builder().
                params(new UserId(userIdInt))
                .method(DELETE_USER)
                .build();

        Response response = postRequest(API_USERNAME, API_TOKEN, bodyArgs);
        return (boolean) response.as(Result.class).getResult();
    }

    public boolean updateUserRole(String userId, String userRole) {
        UpdateUser args = UpdateUser.builder()
                .id(Integer.valueOf(userId))
                .role(userRole)
                .build();
        return createUserBody(args);
    }

    private boolean createUserBody(UpdateUser args) {
        BodyArgs bodyArgs = BodyArgs.builder()
                .params(args)
                .method(UPDATE_USER)
                .build();
        Response response = postRequest(API_USERNAME, API_TOKEN, bodyArgs);
        return (boolean) response.as(BodyResult.class).getResult();
    }
}
