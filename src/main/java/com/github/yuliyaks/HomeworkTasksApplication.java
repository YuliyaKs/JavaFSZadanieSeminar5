/*
Фреймворк Spring
Урок 5. Spring Data для работы с базами данных
Базовое задание:
Условие:
Вам предстоит создать приложение для управления списком задач с использованием Spring Boot и Spring Data JPA.
Требуется реализовать следующие функции:

1. Добавление задачи. Подсказка метод в контроллере: @PostMapping public Task addTask(@RequestBody Task task)
2. Просмотр всех задач. Подсказка метод в контроллере: @GetMapping public List<Task> getAllTasks()
3. Просмотр задач по статусу (например, "завершена", "в процессе", "не начата"). Подсказка метод в контроллере:
@GetMapping("/status/{status}") public List<Task> getTasksByStatus(@PathVariable TaskStatus status)
4. Изменение статуса задачи. Подсказка метод в контроллере:
@PutMapping("/{id}") public Task updateTaskStatus(@PathVariable Long id, @RequestBody Task task)
5. Удаление задачи.
Подсказка метод в контроллере:
@DeleteMapping("/{id}")
public void deleteTask(@PathVariable Long id)

Репозитроий подсказка public interface TaskRepository extends JpaRepository<Task, Long>

Структура задачи(класс Task):
- ID (автоинкрементное)(тип Long)
- Описание (не может быть пустым)(тип String)
- Статус (одно из значений: "не начата", "в процессе", "завершена")(Тип TaskStatus )
- Дата создания (автоматически устанавливается при создании задачи)(Тип LocalDateTime)

Подсказка понадобится энумератор:
enum TaskStatus {
NOT_STARTED, IN_PROGRESS, COMPLETED;
}
 */

package com.github.yuliyaks;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class HomeworkTasksApplication {

	public static void main(String[] args) {
		SpringApplication.run(HomeworkTasksApplication.class, args);
	}

}
