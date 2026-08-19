package taskmanagement.application.task;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import taskmanagement.application.port.out.TaskRepositoryPort;
import taskmanagement.infrastructure.security.TaskNotFoundException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetCommentsUseCase {
    private final TaskRepositoryPort taskRepositoryPort;

    public List<Comment> execute(String taskId) throws TaskNotFoundException {
        return taskRepositoryPort
                .findAllCommentsByTaskId(taskId)
                .orElseThrow(() -> new TaskNotFoundException(taskId));

    }

}
