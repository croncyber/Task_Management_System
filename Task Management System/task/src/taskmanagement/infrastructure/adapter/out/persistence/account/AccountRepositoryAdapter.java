package taskmanagement.infrastructure.adapter.out.persistence.account;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import taskmanagement.application.account.Account;
import taskmanagement.application.port.out.AccountRepositoryPort;

import java.util.Optional;

@Component
@RequiredArgsConstructor
public class AccountRepositoryAdapter implements AccountRepositoryPort {

    private final AccountDataRepository repository;


    @Override
    public boolean existsByEmail(String email) {
        return repository.existsByEmail(email);
    }

    @Override
    public Account save(Account account) {
        AccountEntity entity = new AccountEntity(
                account.id(),
                account.email(),
                account.password());

        AccountEntity saved = repository.save(entity);
        
        return new Account(
                saved.getId(),
                saved.getEmail(),
                saved.getPassword()
        );
    }

    @Override
    public Optional<Account> findByEmail(String email) {
        return repository.findByEmail(email)
                .map(entity -> new Account(
                        entity.getId(),
                        entity.getEmail(),
                        entity.getPassword()
                ));
    }
}
