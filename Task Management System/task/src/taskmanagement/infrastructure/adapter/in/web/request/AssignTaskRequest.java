package taskmanagement.infrastructure.adapter.in.web.request;

import jakarta.validation.constraints.NotNull;
import taskmanagement.application.task.AssignTaskCommand;

public record AssignTaskRequest(
        @NotNull
        String assignee) {

    public AssignTaskCommand toCommand() {
        return new AssignTaskCommand(assignee);
    }
}
