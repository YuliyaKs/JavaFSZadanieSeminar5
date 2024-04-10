package com.github.yuliyaks.controllers;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import com.github.yuliyaks.models.Task;
import com.github.yuliyaks.models.TaskStatus;
import com.github.yuliyaks.services.TaskService;

import java.util.List;

@RestController
@RequestMapping("/tasks")
@AllArgsConstructor
public class TaskController {
    private final TaskService taskService;

    // Метод для вывода всех задач
    //localhost:8080/tasks
    @GetMapping()
    public List<Task> getAllTask() {
        return taskService.getAllTasks();
    }

    // Метод для создания задачи
    //localhost:8080/tasks?description="buyProducts"
    @PostMapping()
    @ResponseBody
    public Task addTaskFromParam(@RequestParam("description") String description) {
        return taskService.createTask(description);
    }

    // Метод для вывода задач с определенным статусом
    //localhost:8080/tasks/status/NOT_STARTED
    @GetMapping("/status/{status}")
    public List<Task> getTasksByStatus(@PathVariable TaskStatus status) {
        return taskService.findTaskByStatus(status);
    }

    // Метод для изменения статуса задачи
    //localhost:8080/tasks/1
    @PutMapping("/{id}")
    public Task updateTaskStatus(@PathVariable Long id) {
        return taskService.updateTaskStatus(id);
    }

    // Метод для удаления задачи по ID
    //localhost:8080/tasks/1
    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
    }

}
