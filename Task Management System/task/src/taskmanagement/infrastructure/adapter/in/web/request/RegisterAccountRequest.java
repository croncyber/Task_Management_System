package taskmanagement.infrastructure.adapter.in.web.request;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import taskmanagement.application.account.RegisterAccountCommand;

public record RegisterAccountRequest(
        @NotBlank
        @Email
        String email,
        @NotBlank
        @Size(min = 6)
        String password
) {

    public RegisterAccountCommand toCommand() {
        return new RegisterAccountCommand(email, password);
    }
}
