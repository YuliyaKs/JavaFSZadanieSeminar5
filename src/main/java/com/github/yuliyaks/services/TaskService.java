package com.github.yuliyaks.services;

import com.github.yuliyaks.models.TaskStatus;
import com.github.yuliyaks.repositoryes.TaskRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import com.github.yuliyaks.models.Task;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class TaskService {

    private final TaskRepository repository;

    // Метод для получения списка всех задач
    public List<Task> getAllTasks() {
        return repository.findAll();
    }

    // Метод для сохранения задачи в репозитории
    private Task saveTask(Task task) {
        return repository.save(task);
    }

    // Метод для создания задачи
    public Task createTask(String description) {
        Task newTask = new Task();
        newTask.setDescription(description);
        newTask.setStatus(TaskStatus.NOT_STARTED);
        newTask.setDateCreate(LocalDateTime.now());
        return saveTask(newTask);
    }

    // Метод для изменения статуса задачи
    public Task updateTaskStatus(Long id) {
        Optional<Task> optionalTask = repository.findById(id);
        if (optionalTask.isPresent()) {
            Task task = optionalTask.get();
            if (task.getStatus().equals(TaskStatus.NOT_STARTED)) {
                task.setStatus(TaskStatus.IN_PROGRESS);
            } else if (task.getStatus().equals(TaskStatus.IN_PROGRESS)) {
                task.setStatus(TaskStatus.COMPLETED);
            }
            return repository.save(task);
        } else {
            throw new IllegalArgumentException("Task not found with id: " + id);
        }
    }

     // Метод для вывода списка задач по статусу
     public List<Task> findTaskByStatus(TaskStatus status) {
        return repository.findTasksByStatus(status);
    }

    // Метод для удаления задача
    public void deleteTask(Long id) {
        repository.deleteById(id);
    }

}
