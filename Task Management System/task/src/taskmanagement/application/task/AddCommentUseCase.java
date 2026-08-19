package taskmanagement.application.task;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import taskmanagement.application.port.out.TaskRepositoryPort;
import taskmanagement.infrastructure.security.TaskNotFoundException;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AddCommentUseCase {
    private final TaskRepositoryPort taskRepositoryPort;

    public void execute(String taskId, AddCommentCommand command) throws TaskNotFoundException {
        Optional<Task> task = taskRepositoryPort.findTaskById(taskId);
        if (task.isEmpty()) {
            throw new TaskNotFoundException(taskId);
        }

        taskRepositoryPort.addComment(
                new Comment(
                        null,
                        taskId,
                        command.text(),
                        command.author()
                )
        );
    }
}
