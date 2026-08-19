package taskmanagement.application.task;

public record Task(
        String id,
        String title,
        String description,
        String status,
        String author,
        String assignee) {
}