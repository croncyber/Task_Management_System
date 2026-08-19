package taskmanagement.infrastructure.adapter.out.persistence.task;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import taskmanagement.application.port.out.TaskRepositoryPort;
import taskmanagement.application.task.Comment;
import taskmanagement.application.task.Task;
import taskmanagement.application.task.TaskListItem;
import taskmanagement.infrastructure.adapter.out.persistence.Status;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

@Component
@RequiredArgsConstructor
public class TaskRepositoryAdapter implements TaskRepositoryPort {
    private final TaskDataRepository repository;
    private final CommentDataRepository commentDataRepository;

    @Override
    public Task save(Task newTask) {
        TaskEntity entity = new TaskEntity(
                null,
                newTask.title(),
                newTask.description(),
                Status.valueOf(newTask.status()),
                newTask.author(),
                newTask.assignee()
        );

        TaskEntity saved = repository.save(entity);

        return new Task(
                saved.getId().toString(),
                saved.getTitle(),
                saved.getDescription(),
                saved.getStatus().name(),
                saved.getAuthor(),
                saved.getAssignee()
        );
    }

    @Override
    public Task update(Task updatedTask) {
        TaskEntity entity = new TaskEntity(
                Long.valueOf(updatedTask.id()),
                updatedTask.title(),
                updatedTask.description(),
                Status.valueOf(updatedTask.status()),
                updatedTask.author(),
                updatedTask.assignee()
        );

        TaskEntity saved = repository.save(entity);

        return new Task(
                saved.getId().toString(),
                saved.getTitle(),
                saved.getDescription(),
                saved.getStatus().name(),
                saved.getAuthor(),
                saved.getAssignee());
    }

    @Override
    public Optional<Task> findTask(String title) {
        return repository.findByTitle(title)
                .map(entity -> new Task(
                        entity.getId().toString(),
                        entity.getTitle(),
                        entity.getDescription(),
                        entity.getStatus().name(),
                        entity.getAuthor(),
                        entity.getAssignee()));
    }

    @Override
    public Optional<List<TaskListItem>> findAllTasks() {
        List<TaskEntity> entities = repository.findAll();
        List<String> taskIds = entities.stream().map(e -> e.getId().toString()).toList();
        Map<String, Long> counts = commentDataRepository.countByTaskIdIn(taskIds).stream()
                .collect(Collectors.toMap(TaskCommentCount::getTaskId, TaskCommentCount::getCount));

        return Optional.of(entities.stream()
                .map(entity -> new TaskListItem(
                        entity.getId().toString(),
                        entity.getTitle(),
                        entity.getDescription(),
                        entity.getStatus().name(),
                        entity.getAuthor(),
                        entity.getAssignee(),
                        counts.getOrDefault(entity.getId().toString(), 0L)
                )).toList());
    }


    @Override
    public Optional<List<TaskListItem>> findAllByAuthor(String author) {
        if (author == null) {
            return Optional.empty();
        }

        return repository.findByAuthor(author).map(entities -> {
            List<String> taskIds = entities.stream().map(e -> e.getId().toString()).toList();
            Map<String, Long> counts = commentDataRepository.countByTaskIdIn(taskIds).stream()
                    .collect(Collectors.toMap(TaskCommentCount::getTaskId, TaskCommentCount::getCount));

            return entities.stream()
                    .map(entity -> new TaskListItem(
                            entity.getId().toString(),
                            entity.getTitle(),
                            entity.getDescription(),
                            entity.getStatus().name(),
                            entity.getAuthor(),
                            entity.getAssignee(),
                            counts.getOrDefault(entity.getId().toString(), 0L)
                    )).toList();
        });
    }

    @Override
    public Optional<Task> findTaskById(String id) {
        return repository.findById(Long.valueOf(id)).map(entity -> new Task(
                entity.getId().toString(),
                entity.getTitle(),
                entity.getDescription(),
                entity.getStatus().name(),
                entity.getAuthor(),
                entity.getAssignee()
        ));
    }


    @Override
    public void addComment(Comment newComment) {
        commentDataRepository.save(new CommentEntity(
                null,
                newComment.task_id(),
                newComment.text(),
                newComment.author()
        ));
    }

    @Override
    public Optional<List<Comment>> findAllCommentsByTaskId(String taskId) {
        Optional<Long> id = parseId(taskId);

        if (id.isEmpty() || !repository.existsById(Long.valueOf(taskId))) {
            return Optional.empty();
        }
        return Optional.of(commentDataRepository.findByTaskIdOrderByIdDesc(taskId).stream()
                .map(commentEntity -> new Comment(
                        commentEntity.getId().toString(),
                        commentEntity.getTaskId(),
                        commentEntity.getText(),
                        commentEntity.getAuthor()
                )).toList());
    }

    private Optional<Long> parseId(String id) {
        try {
            return Optional.of(Long.valueOf(id));
        } catch (NumberFormatException e) {
            return Optional.empty();
        }
    }
}
