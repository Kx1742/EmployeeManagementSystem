package ems.example.ems_demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ems.example.ems_demo.model.Project;
import ems.example.ems_demo.repository.ProjectRepository;

@Service
public class ProjectService {
    @Autowired
    private ProjectRepository projectRepository;

    //fetch all projects
    public List<Project> getAllProjects(){
        return projectRepository.findAll();
    }

    //fetch project by id
    public Optional<Project> getProjectById(Long id){
        return projectRepository.findById(id);
    }


    
    //add project
    public Project addProject(Project project){
        return projectRepository.save(project);
    }

    //update project
    public Project updateProject(Project project){
        return projectRepository.save(project);
    }

    //delete project
    public String deleteProject(Long id){
        projectRepository.deleteById(id);
        return "Project removed "+id;
    }

        
}
