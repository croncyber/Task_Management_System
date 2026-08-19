package taskmanagement.domain.account;

public record Account(
        Long id,
        String email,
        String password
) {
}
