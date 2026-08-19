package taskmanagement.infrastructure.adapter.out.persistence.account;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AccountDataRepository extends JpaRepository<AccountEntity, Long> {
    boolean existsByEmail(String email);

    Optional<AccountEntity> findByEmail(String email);
}
