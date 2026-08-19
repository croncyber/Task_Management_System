package taskmanagement.application.port.out;
import taskmanagement.application.task.Comment;
import taskmanagement.application.task.Task;
import taskmanagement.application.task.TaskListItem;

import java.util.List;
import java.util.Optional;

public interface TaskRepositoryPort {
    Task save(Task newTask);
    Task update(Task updatedTask);
    Optional<Task> findTask(String author);
    Optional<List<TaskListItem>> findAllTasks();
    Optional<List<TaskListItem>> findAllByAuthor(String author);
    Optional<Task> findTaskById(String id);
    Optional<List<Comment>> findAllCommentsByTaskId(String taskId);
    void addComment(Comment newComment);
}
