package com.task_project_manager.springboot.Repositories;

import com.task_project_manager.springboot.Entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TaskRepo extends JpaRepository<Task,Integer> {
}
