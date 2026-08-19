package taskmanagement.application.task;

public record TaskListItem(String id,
                           String title,
                           String description,
                           String status,
                           String author,
                           String assignee,
                           Long total_comments) {
}
