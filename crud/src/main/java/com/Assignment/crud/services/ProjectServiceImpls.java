package com.Assignment.crud.services;

import com.Assignment.crud.models.Project;
import com.Assignment.crud.repositories.ProjectRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;


@Service
public class ProjectServiceImpls implements ProjectService {

    @Autowired
    private ProjectRepo projectRepo;

    @Override
    public Project getProjectById(Long id) {
        return projectRepo.findById(id).orElse(null);
    }

    @Override
    public Project createProject(Project project) {
        System.out.println("project services ");
        return projectRepo.save(project);
    }

    @Override
    public Project updateProject(Project project, Long id) {
        if(projectRepo.existsById(id)){
            project.setId(id);
            return projectRepo.save(project);
        }
        return null;
    }

    @Override
    public void deleteProject(Long id) {
          if(projectRepo.existsById(id)){
              projectRepo.deleteById(id);
          }
    }
    @Override
    public List<Project> getAllProjects() {
        return projectRepo.findAll();
    }
}
