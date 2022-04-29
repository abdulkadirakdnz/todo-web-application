package ch.cern.todo.repository;

import ch.cern.todo.entity.TaskEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TaskRespository extends JpaRepository<TaskEntity,Long> {

    List<TaskEntity> findAll();
    Optional<TaskEntity> findByTaskId(Long id);
}
