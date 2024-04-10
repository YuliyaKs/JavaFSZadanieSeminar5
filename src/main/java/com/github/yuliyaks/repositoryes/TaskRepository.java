package com.github.yuliyaks.repositoryes;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.github.yuliyaks.models.Task;
import com.github.yuliyaks.models.TaskStatus;

import java.util.List;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

    // Метод для поиска задач по статусу
    List<Task> findTasksByStatus(TaskStatus status);

}
