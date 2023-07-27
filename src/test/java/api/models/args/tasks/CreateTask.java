package api.models.args.tasks;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CreateTask {
    private String title;
    private int project_id;
    private String color_id;
    private int column_id;
    private int owner_id;
    private int creator_id;
    private int status_id;
}