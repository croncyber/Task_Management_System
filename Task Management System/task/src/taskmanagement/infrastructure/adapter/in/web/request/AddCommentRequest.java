package taskmanagement.infrastructure.adapter.in.web.request;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import taskmanagement.application.task.AddCommentCommand;

public record AddCommentRequest(
        @NotBlank
        @NotNull
        String text
) {
    public AddCommentCommand toCommand(String text, String author) {
        return new AddCommentCommand(text, author);
    }
}
