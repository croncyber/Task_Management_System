package taskmanagement.infrastructure.adapter.out.persistence.task;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;


import java.util.List;


public interface CommentDataRepository extends JpaRepository<CommentEntity, Long> {
    List<CommentEntity> findByTaskIdOrderByIdDesc(String taskId);

    @Query("SELECT c.taskId AS taskId, COUNT(c) AS count FROM CommentEntity c WHERE c.taskId IN :taskIds GROUP BY c.taskId")
    List<TaskCommentCount> countByTaskIdIn(@Param("taskIds") List<String> taskIds);

    Long countByTaskId(String id);
}
