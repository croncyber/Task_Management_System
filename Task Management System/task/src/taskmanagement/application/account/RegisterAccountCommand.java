package taskmanagement.application.account;

public record RegisterAccountCommand(
        String email,
        String password
) {
}
