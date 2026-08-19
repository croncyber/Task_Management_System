package taskmanagement.infrastructure.adapter.in.web;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import taskmanagement.application.task.AssignTaskUseCase;
import taskmanagement.application.task.Comment;
import taskmanagement.application.task.AddCommentUseCase;
import taskmanagement.application.task.CreateTaskUseCase;
import taskmanagement.application.task.GetAllTasksUseCase;
import taskmanagement.application.task.GetCommentsUseCase;
import taskmanagement.application.task.Task;
import taskmanagement.application.task.TaskListItem;
import taskmanagement.infrastructure.adapter.in.web.request.AssignTaskRequest;
import taskmanagement.infrastructure.adapter.in.web.request.AddCommentRequest;
import taskmanagement.infrastructure.adapter.in.web.request.CreateTaskRequest;
import taskmanagement.infrastructure.security.TaskAlreadyExistsException;
import taskmanagement.infrastructure.security.TaskNotFoundException;

import java.util.List;

@RestController
@RequestMapping("/api/tasks")
@RequiredArgsConstructor
public class TaskController {

    private final CreateTaskUseCase createTaskUseCase;
    private final GetAllTasksUseCase getAllTasksUseCase;
    private final AssignTaskUseCase assignTaskUseCase;
    private final AddCommentUseCase addCommentUseCase;
    private final GetCommentsUseCase getCommentsUseCase;

    @GetMapping
    public ResponseEntity<List<TaskListItem>> getTasks(@RequestParam(required = false) String author) {
        return ResponseEntity.ok(getAllTasksUseCase
                .execute(author));
    }

    @PostMapping
    public ResponseEntity<Task> createTask(@Valid @RequestBody CreateTaskRequest request, Authentication authentication) throws TaskAlreadyExistsException {
        return ResponseEntity.ok(createTaskUseCase
                .execute(request.toCommand(), authentication.getName()));
    }

    @PutMapping(path = "/{taskId}/assign")
    public ResponseEntity<Task> assignTask(@PathVariable String taskId,
                                           @Valid @RequestBody AssignTaskRequest request,
                                           Authentication authentication
    ) {
        return ResponseEntity.ok(assignTaskUseCase
                .execute(taskId, request.toCommand()));
    }

    @PostMapping(path = "/{taskId}/comments")
    public ResponseEntity<String> addComment(@PathVariable String taskId,
                                             @Valid @RequestBody AddCommentRequest request,
                                             Authentication authentication
    ) throws TaskNotFoundException {
        addCommentUseCase.execute(taskId, request.toCommand(request.text(), authentication.getName()));
        return ResponseEntity.ok().build();
    }

    @GetMapping(path = "/{taskId}/comments")
    public ResponseEntity<List<Comment>> getComments(@PathVariable @Valid @NotBlank @NotNull String taskId) throws TaskNotFoundException {
        return ResponseEntity.ok(getCommentsUseCase
                .execute(taskId));
    }
}
