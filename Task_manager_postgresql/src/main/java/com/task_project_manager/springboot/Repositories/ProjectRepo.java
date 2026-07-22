package com.task_project_manager.springboot.Repositories;

import com.task_project_manager.springboot.Entities.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ProjectRepo extends JpaRepository<Project, Integer> {

    @Query("SELECT COUNT(p) > 0 FROM Project p WHERE p.p_name = :p_name")
    boolean existsByP_name(@Param("p_name") String p_name);
}