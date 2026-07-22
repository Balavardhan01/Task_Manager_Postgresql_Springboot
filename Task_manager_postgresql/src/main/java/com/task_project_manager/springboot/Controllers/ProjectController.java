package com.task_project_manager.springboot.Controllers;

import com.task_project_manager.springboot.Entities.Project;
import com.task_project_manager.springboot.Service.ProjectService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/projects")
public class ProjectController {
    private ProjectService service;
    public ProjectController(ProjectService service) {
        this.service = service;
    }


    @PostMapping
    public ResponseEntity<Project> createProject(@RequestBody Project project){
       Project created= service.createProject(project);
       return new ResponseEntity<>(created,HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Project>> getAllProjects(){
        List<Project> projects=service.getAllProjects();
        return ResponseEntity.ok(projects);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Project> getProjectById(@PathVariable int id){
        Project project= service.getProjectById(id);
        return ResponseEntity.ok(project);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProject(@PathVariable int id){
        service.deleteProject(id);
        return ResponseEntity.noContent().build();
    }
}
