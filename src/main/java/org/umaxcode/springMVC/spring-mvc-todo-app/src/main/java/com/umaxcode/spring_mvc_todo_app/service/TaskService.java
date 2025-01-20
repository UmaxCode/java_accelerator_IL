package com.umaxcode.spring_mvc_todo_app.service;

import com.umaxcode.spring_mvc_todo_app.domain.dto.TaskCreationRequestDTO;
import com.umaxcode.spring_mvc_todo_app.domain.entity.Task;

import java.util.List;

public interface TaskService {

    List<Task> getAllTasks();

    void addTask(TaskCreationRequestDTO request);

    void markTaskAsCompleted(Long id);
}
