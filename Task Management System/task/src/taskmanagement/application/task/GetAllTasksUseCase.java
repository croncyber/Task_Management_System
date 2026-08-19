package taskmanagement.application.task;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import taskmanagement.application.port.out.TaskRepositoryPort;
import taskmanagement.infrastructure.adapter.out.persistence.Status;
import taskmanagement.infrastructure.security.TaskAlreadyExistsException;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GetAllTasksUseCase {

    private final TaskRepositoryPort taskRepositoryPort;

    public List<TaskListItem> execute(String author) {

        if (author == null) {
            return taskRepositoryPort
                    .findAllTasks()
                    .orElse(List.of())
                    .reversed();
        }

        return taskRepositoryPort
                .findAllByAuthor(author)
                .orElse(List.of())
                .reversed();
    }
}
