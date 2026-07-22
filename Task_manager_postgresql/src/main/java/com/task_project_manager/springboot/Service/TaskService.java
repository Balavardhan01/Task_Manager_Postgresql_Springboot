package com.task_project_manager.springboot.Service;

import com.task_project_manager.springboot.Entities.Project;
import com.task_project_manager.springboot.Entities.Task;
import com.task_project_manager.springboot.Repositories.ProjectRepo;
import com.task_project_manager.springboot.Repositories.TaskRepo;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class TaskService {

    private final TaskRepo trepo;
    private final ProjectRepo prepo;

    public TaskService(TaskRepo trepo, ProjectRepo prepo) {
        this.trepo = trepo;
        this.prepo = prepo;
    }

    // 1. Create a task linked to a project
    public Task createTask(int projectId, Task task) {
        Project project = prepo.findById(projectId)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Project not found with id: " + projectId));

        task.setProject(project);
        return trepo.save(task);
    }


    // 2. Fetch all tasks for a specific project
    public Optional<Task> getTasksByProjectId(int projectId) {
        if (!prepo.existsById(projectId)) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Project not found with id: " + projectId);
        }
        return trepo.findById(projectId);
    }

    // 3. Update task status (true/false)
    public Task updateTaskStatus(int taskId, boolean status) {
        Task task = trepo.findById(taskId)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Task not found with id: " + taskId));

        task.setT_status(status);
        return trepo.save(task);
    }

    // 4. Delete a task by ID
    public void deleteTask(int taskId) {
        if (!trepo.existsById(taskId)) {
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND, "Task not found with id: " + taskId);
        }
        trepo.deleteById(taskId);
    }
}