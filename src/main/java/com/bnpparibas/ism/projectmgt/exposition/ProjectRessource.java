package com.bnpparibas.ism.projectmgt.exposition;
import com.bnpparibas.ism.projectmgt.domain.Document;

import com.bnpparibas.ism.projectmgt.application.ProjectService;
import com.bnpparibas.ism.projectmgt.domain.Project;
import com.bnpparibas.ism.projectmgt.infrastructure.ProjectDAO;
import com.bnpparibas.ism.projectmgt.infrastructure.processmgt.FollowUP;
import com.bnpparibas.ism.projectmgt.infrastructure.processmgt.ProcessDTO;
import com.bnpparibas.ism.projectmgt.infrastructure.processmgt.ProcessManagerDAO;
import com.bnpparibas.ism.projectmgt.infrastructure.processmgt.ProcessType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
public class ProjectRessource {
    @Autowired
    private ProjectService projectService;

    //Création d'un Project
    @RequestMapping(method = RequestMethod.POST, path = {"/createProject/"})
    @ResponseStatus(HttpStatus.CREATED)
    public Long createProject(@RequestBody Project project) {
        return this.projectService.create(project);
    }

    //Liste des projets
    @RequestMapping(method = RequestMethod.GET, path = {"/projectsList/"})
    public List<Project> findAll() {
        return projectService.listAll();
    }


    //Recherche d'un project avec son code
    @RequestMapping(method = RequestMethod.GET, path = {"/project/{code}"})
    public Project obtain(@PathVariable("code") String code) {
        return this.projectService.obtain(code);
    }

    @RequestMapping(method = RequestMethod.GET, path = {"/project/{projectId}/process/methods/{name}/ptype/{ptype}/pfollow/{pfollow}"})
    public List<ProcessDTO> callProcess(@PathVariable("name") String name,
                                        @PathVariable("ptype") String ptype,
                                        @PathVariable("pfollow") String pfollow,
                                        @PathVariable("projectId") Long projectId) {
        return projectService.callProcess(name,ptype,pfollow,projectId);
    }
}


