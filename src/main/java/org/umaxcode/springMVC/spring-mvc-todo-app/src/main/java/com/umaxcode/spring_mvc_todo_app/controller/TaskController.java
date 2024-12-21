package com.umaxcode.spring_mvc_todo_app.controller;

import com.umaxcode.spring_mvc_todo_app.domain.dto.TaskCreationRequestDTO;
import com.umaxcode.spring_mvc_todo_app.service.TaskService;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/todos")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public String listAllTodoItems(Model model) {
        model.addAttribute("tasks", taskService.getAllTasks());
        return "todo-list";
    }

    @GetMapping("/add")
    public String addTaskView() {
        return "todo-add";
    }


    @PostMapping("/add")
    public String addNewTodoItem(@Valid @ModelAttribute TaskCreationRequestDTO request) {
        taskService.addTask(request);
        return "redirect:/todos";
    }

    @GetMapping("complete/{id}")
    public String markAsComplete(@PathVariable(value = "id") Long id) {
        taskService.markTaskAsCompleted(id);
        return "redirect:/todos";
    }

}
