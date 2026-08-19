package taskmanagement.application.task;

public record AddCommentCommand(
        String text,
        String author
) {
}
