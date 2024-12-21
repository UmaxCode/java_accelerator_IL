package com.umaxcode.spring_mvc_todo_app.service;

import com.umaxcode.spring_mvc_todo_app.domain.dto.TaskCreationRequestDTO;
import com.umaxcode.spring_mvc_todo_app.domain.entity.Task;
import com.umaxcode.spring_mvc_todo_app.repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {

    private final TaskRepository taskRepository;

    public TaskServiceImpl(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @Override
    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    @Override
    public void addTask(TaskCreationRequestDTO request) {

        Task task = new Task(request.title(), request.description());

        taskRepository.save(task);
    }

    @Override
    public void markTaskAsCompleted(Long id) {
        taskRepository.findById(id).ifPresent(task -> {
            task.setCompleted(true);
            taskRepository.save(task);
        });
    }

}
