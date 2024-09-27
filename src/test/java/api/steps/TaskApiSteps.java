package api.steps;

import api.models.Result;
import api.models.args.BodyArgs;
import api.models.args.tasks.CreateTask;
import api.models.args.tasks.TaskId;
import io.restassured.response.Response;


import static api.methods.Tasks.*;
import static utils.EnvProperties.API_TOKEN;
import static utils.EnvProperties.API_USERNAME;

public class TaskApiSteps extends BaseApiSteps {

    public String createTaskByAPI(String title, Integer projectId) {
        CreateTask args = new CreateTask().builder()
                .title(title)
                .project_id(projectId)
                .build();

        BodyArgs bodyArgs = BodyArgs.builder().
                params(args)
                .method(CREATE_TASK)
                .build();

        Response response = postRequest(API_USERNAME, API_TOKEN, bodyArgs);
        response.then().statusCode(200);
        Result result = response.as(Result.class);
        return result.getResult().toString();
    }

    public Boolean deleteTask(Integer task_id) {

        BodyArgs bodyArgs = BodyArgs.builder().
                params(new TaskId(task_id))
                .method(REMOVE_TASK)
                .build();

        Response response = postRequest(API_USERNAME, API_TOKEN, bodyArgs);
        response.then().statusCode(200);
        return (boolean) response.as(Result.class).getResult();
    }
}
