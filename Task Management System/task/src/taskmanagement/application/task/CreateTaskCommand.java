package taskmanagement.application.task;

public record CreateTaskCommand(
        String title,
        String description
) {
}
