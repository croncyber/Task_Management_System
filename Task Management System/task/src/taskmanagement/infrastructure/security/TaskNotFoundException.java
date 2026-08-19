package taskmanagement.infrastructure.security;

public class TaskNotFoundException extends Throwable {
    public TaskNotFoundException(String taskId) {
        super("Task not found with task id: " + taskId);
    }

}
