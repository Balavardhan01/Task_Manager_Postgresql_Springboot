package com.task_project_manager.springboot.Repositories;

import com.task_project_manager.springboot.Entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

import java.util.Optional;

public interface TaskRepo extends JpaRepository<Task,Integer> {
    List<Task> findByProjectP_id(int projectId);
}
