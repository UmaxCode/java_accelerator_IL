package com.umaxcode.spring_mvc_todo_app.repository;

import com.umaxcode.spring_mvc_todo_app.domain.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepository extends JpaRepository<Task, Long> {
}
