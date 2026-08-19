package taskmanagement.application.port.out;

import taskmanagement.application.account.Account;

import java.util.Optional;

public interface AccountRepositoryPort {
    boolean existsByEmail(String email);

    Account save(Account account);

    Optional<Account> findByEmail(String email);
}
