package api.models.args.projects;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

public class CreateProject {
    private String name;
    private String description;
    private Integer owner_id;
}
