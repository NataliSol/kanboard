package api.models.args.users;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BodyResult<T> {
    private String jsonrpc;
    private int id;
    private String error;
    private T result;
}