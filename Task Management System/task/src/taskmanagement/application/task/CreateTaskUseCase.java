package taskmanagement.application.task;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import taskmanagement.application.port.out.TaskRepositoryPort;
import taskmanagement.infrastructure.security.TaskAlreadyExistsException;
import taskmanagement.infrastructure.adapter.out.persistence.Status;


@Service
@RequiredArgsConstructor
public class CreateTaskUseCase {

    private final TaskRepositoryPort taskRepositoryPort;

    public Task execute(CreateTaskCommand command, String username) throws TaskAlreadyExistsException {

        if (taskRepositoryPort.findTask(command.title()).isPresent()) {
            throw new TaskAlreadyExistsException(command.title());
        }

        Task task = new Task(
                null,
                command.title(),
                command.description(),
                Status.CREATED.name(),
                username,
                "none"
        );

        return taskRepositoryPort.save(task);
    }
}
