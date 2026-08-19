package taskmanagement.application.account;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import taskmanagement.application.port.out.AccountRepositoryPort;
import taskmanagement.application.port.out.PasswordEncoderPort;
import taskmanagement.infrastructure.security.AccountAlreadyExistsException;


@Service
@RequiredArgsConstructor
public class RegisterAccountUseCase {

    private final AccountRepositoryPort accountRepositoryPort;
    private final PasswordEncoderPort passwordEncoderPort;

    public void execute(RegisterAccountCommand command) {
        String normalizedEmail = command.email().toLowerCase();

        if (accountRepositoryPort.existsByEmail(normalizedEmail)) {
            throw new AccountAlreadyExistsException(normalizedEmail);
        }

        Account account = new Account(
                null,
                normalizedEmail,
                passwordEncoderPort.encode(command.password()));

        accountRepositoryPort.save(account);
    }
}
