package com.bnpparibas.ism.projectmgt.exposition;
import com.bnpparibas.ism.projectmgt.application.ProjectService;
import com.bnpparibas.ism.projectmgt.domain.Project;
import com.bnpparibas.ism.projectmgt.infrastructure.processmgt.ProcessDTO;
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


    /* Appel au service de l'application "PROCESS MANAGEMENT" pour avoir la liste des activités et des artifacts pour un projet en fonction des parametres suivants :
        - le nom de la méthode : "MéthodeMapping (comme déclaré dans l'outil CLARITY")
        - le type de "process (ACHTITECTURE ou QUALITY)
        - le type de suivi (STANDARD, ALLEGE ou RENFORCEE)
        - l'identifiant du projet concerné (pour de mettre à jour l'indicateur sur les artifacts (fait/nonFait)*/

    @RequestMapping(method = RequestMethod.GET, path = {"/project/{projectId}/process/methods/{name}/ptype/{ptype}/pfollow/{pfollow}"})
    public List<ProcessDTO> callProcess(@PathVariable("name") String name,
                                        @PathVariable("ptype") String ptype,
                                        @PathVariable("pfollow") String pfollow,
                                        @PathVariable("projectId") Long projectId) {
        return projectService.callProcess(name,ptype,pfollow,projectId);
    }
}


