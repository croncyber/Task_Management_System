package taskmanagement.application.task;

public record Comment(
        String id,
        String task_id,
        String text,
        String author
) {
}
