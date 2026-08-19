package taskmanagement.infrastructure.security;

public class TaskAlreadyExistsException extends Throwable {
    public TaskAlreadyExistsException(String title) {
        super("Task already exists with title: " + title);
    }
}
