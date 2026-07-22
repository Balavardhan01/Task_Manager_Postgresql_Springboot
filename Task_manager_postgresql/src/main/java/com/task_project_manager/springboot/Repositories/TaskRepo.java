package com.task_project_manager.springboot.Repositories;

import com.task_project_manager.springboot.Entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TaskRepo extends JpaRepository<Task, Integer> {

    @Query("SELECT t FROM Task t WHERE t.project.p_id = :projectId")
    List<Task> findByProjectP_id(@Param("projectId") int projectId);
}