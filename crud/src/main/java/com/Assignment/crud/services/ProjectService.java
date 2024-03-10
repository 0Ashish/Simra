package com.Assignment.crud.services;

import com.Assignment.crud.models.Project;

import java.util.List;

public interface ProjectService {

    //    Create a project
    Project createProject(Project project);

//    Get specific Project by Id
    Project getProjectById(Long id);

//    Update the project
    Project updateProject(Project project , Long id);

//    delete the project
    void deleteProject(Long id);

    //    Get All Projects
    List<Project> getAllProjects();

}
