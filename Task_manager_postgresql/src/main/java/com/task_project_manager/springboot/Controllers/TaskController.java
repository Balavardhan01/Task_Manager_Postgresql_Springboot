package com.task_project_manager.springboot.Controllers;

import com.task_project_manager.springboot.Entities.Task;
import com.task_project_manager.springboot.Service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TaskController {

    private final TaskService service;

    // 1. Added Constructor Injection to fix NullPointerException
    public TaskController(TaskService service) {
        this.service = service;
    }

    // 2. {projectId} matches int projectId
    @PostMapping("/api/projects/{projectId}/tasks")
    public ResponseEntity<Task> createTask(@PathVariable int projectId, @RequestBody Task task) {
        Task createdtask = service.createTask(projectId, task);
        return new ResponseEntity<>(createdtask, HttpStatus.CREATED);
    }

    // 3. Changed 'pid' to 'projectId' to match {projectId}
    @GetMapping("/api/projects/{projectId}/tasks")
    public ResponseEntity<List<Task>> getTasksByProjectId(@PathVariable int projectId) {
        List<Task> tasks = service.getTasksByProjectId(projectId);
        return new ResponseEntity<>(tasks, HttpStatus.OK);
    }

    // 4. Changed 'tid' to 'taskId' to match {taskId}, added @RequestParam for status
    @PatchMapping("/api/tasks/{taskId}/status")
    public ResponseEntity<Task> updateTaskStatus(@PathVariable int taskId, @RequestParam boolean status) {
        Task updated = service.updateTaskStatus(taskId, status);
        return new ResponseEntity<>(updated, HttpStatus.OK);
    }

    // 5. Changed 'id' to 'taskId' to match {taskId}
    @DeleteMapping("/api/tasks/{taskId}")
    public ResponseEntity<Void> deleteTask(@PathVariable int taskId) {
        service.deleteTask(taskId);
        return ResponseEntity.noContent().build();
    }
}