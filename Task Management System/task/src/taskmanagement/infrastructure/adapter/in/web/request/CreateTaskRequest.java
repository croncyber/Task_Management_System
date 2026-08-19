package taskmanagement.infrastructure.adapter.in.web.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import taskmanagement.application.task.CreateTaskCommand;

public record CreateTaskRequest(
        @NotBlank
        @NotNull
        String title,
        @NotBlank
        @NotNull
        String description
) {

    public CreateTaskCommand toCommand() {
        return new CreateTaskCommand(title, description);
    }
}
