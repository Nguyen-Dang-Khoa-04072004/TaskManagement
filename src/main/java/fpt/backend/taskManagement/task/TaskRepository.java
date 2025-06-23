package fpt.backend.taskManagement.task;

import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task,Long> , JpaSpecificationExecutor<Task> {
    List<Task> findAll(Specification<Task> filter);
}
