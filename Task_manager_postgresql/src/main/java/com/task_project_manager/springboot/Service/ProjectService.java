package com.task_project_manager.springboot.Service;

import com.task_project_manager.springboot.Entities.Project;
import com.task_project_manager.springboot.Repositories.ProjectRepo;
import jakarta.transaction.Transactional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class ProjectService {
    private final ProjectRepo prepo;
    public ProjectService(ProjectRepo prepo){
        this.prepo=prepo;
    }

    public Project createProject(Project project){
        if(prepo.existsByP_name(project.getP_name())){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST,"Project already exists!!");
        }else{
            return prepo.save(project);
        }
    }

    public List<Project> getAllProjects(){
        return prepo.findAll();
    }

    public Project getProjectById(int id){
        return prepo.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND,"Project not found with id: "+id)) ;
    }

    public void deleteProject(int id){
        if(prepo.existsById(id)) {
            prepo.deleteById(id);
        }else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND,"Project Not found");
        }
    }
}
