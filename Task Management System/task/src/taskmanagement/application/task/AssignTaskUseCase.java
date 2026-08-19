package taskmanagement.application.task;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import taskmanagement.application.port.out.TaskRepositoryPort;


@Service
@RequiredArgsConstructor
public class AssignTaskUseCase {
    private final TaskRepositoryPort taskRepositoryPort;

    public Task execute(String taskId, AssignTaskCommand command){

        Task task = taskRepositoryPort.findTaskById(taskId).get();

        Task updatedTask = new Task(
                task.id(),
                task.title(),
                task.description(),
                task.status(),
                task.author(),
                command.assignee()
        );

        return taskRepositoryPort.update(updatedTask);
    }
}
