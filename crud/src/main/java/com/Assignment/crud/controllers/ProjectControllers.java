package com.Assignment.crud.controllers;


import com.Assignment.crud.exceptionHandling.ProjectNotFoundException;
import com.Assignment.crud.models.Project;
import com.Assignment.crud.services.ProjectService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import jakarta.validation.Valid;
import jakarta.validation.Validator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/projects")
@Validated
public class ProjectControllers {

    @Autowired
    private ProjectService projectService;
    @Autowired
    private Validator validator;

    public ProjectControllers(ProjectService projectService,Validator validator){
        this.projectService=projectService;
        this.validator=validator;
    }


//    Get All Projects
    @GetMapping
    public ResponseEntity<List<Project>> getAllProjects(){
        List<Project> projects = projectService.getAllProjects();
        if(projects.size()!=0) {
            return new ResponseEntity<>(projects,HttpStatus.OK);
        }else{
            throw new ProjectNotFoundException(500,"empty database");
        }
    }

//   Create a new Project

    @PostMapping
    public ResponseEntity<Project> createProject(@Valid @RequestBody Project project) {
        Project newProject = projectService.createProject(project);
        return new ResponseEntity<>(newProject,HttpStatus.OK);

    }

//    Get project by id
    @GetMapping("/{id}")
    public ResponseEntity<Project> getProjectById(@PathVariable Long id){
        Project project = projectService.getProjectById(id);
        if(project!=null) {
            return new ResponseEntity<>(project,HttpStatus.OK);
        }else{
            throw new ProjectNotFoundException(500,"no Id found");

        }

        }

//        Update the project
@PutMapping("/{id}")
public ResponseEntity<Project> updateProject(@Valid @RequestBody Project project,@PathVariable Long id){

    Project updatedProject = projectService.updateProject(project, id);

    if (updatedProject != null) {
        return ResponseEntity.ok(updatedProject);
    } else {
        return ResponseEntity.notFound().build();
    }
}

//    deleting project
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){
        projectService.deleteProject(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
