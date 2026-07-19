package com.task_project_manager.springboot.Repositories;

import com.task_project_manager.springboot.Entities.Project;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProjectRepo extends JpaRepository<Project,Integer> {
}
