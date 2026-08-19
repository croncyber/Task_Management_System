package taskmanagement.infrastructure.adapter.in.web.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import taskmanagement.infrastructure.security.AccountAlreadyExistsException;
import taskmanagement.infrastructure.security.TaskAlreadyExistsException;
import taskmanagement.infrastructure.security.TaskNotFoundException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(AccountAlreadyExistsException.class)
    public ResponseEntity<Void> handleAccountAlreadyExists() {
        return ResponseEntity.status(HttpStatus.CONFLICT).build();
    }


    @ExceptionHandler(TaskAlreadyExistsException.class)
    public ResponseEntity<Void> handleTaskAlreadyExists() {
        return ResponseEntity.status(HttpStatus.CONFLICT).build();
    }

    @ExceptionHandler(TaskNotFoundException.class)
    public ResponseEntity<Void> handleTaskNotFound() {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
    }
}
