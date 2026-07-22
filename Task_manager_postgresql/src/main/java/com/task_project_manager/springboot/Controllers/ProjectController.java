package com.task_project_manager.springboot.Controllers;

import com.task_project_manager.springboot.Entities.Project;
import com.task_project_manager.springboot.Service.ProjectService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {
    private ProjectService service;
    @PostMapping
    public ResponseEntity<Project> createProject(Project project){
       Project created= service.createProject(project);
       return ResponseEntity.status(HttpStatus.CREATED).body(created);
    }

    @GetMapping
    public ResponseEntity<List<Project>> getAllProjects(){
        return service.getAllProjects();
    }
}
