package taskmanagement.infrastructure.adapter.out.persistence.task;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TaskDataRepository extends JpaRepository<TaskEntity, Long> {
    Optional<TaskEntity> findByTitle(String title);

    Optional<List<TaskEntity>> findByAuthor(String author);

    List<TaskEntity> findAll();
}
