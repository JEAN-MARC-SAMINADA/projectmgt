package com.bnpparibas.ism.projectmgt.application;
import com.bnpparibas.ism.projectmgt.domain.Document;
import com.bnpparibas.ism.projectmgt.domain.Project;
import com.bnpparibas.ism.projectmgt.infrastructure.ProjectDAO;
import com.bnpparibas.ism.projectmgt.infrastructure.processmgt.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Transactional
@Service
public class ProjectService {
    @Autowired
    private ProjectDAO projectDAO;

    @Autowired
    private ProcessManagerDAO processManagerDAO;


    //Création d'un projet->si Ok restitution de l'Id du projet crée
    public Long create(Project newProject) {
        Project project = this.projectDAO.save(newProject);
        return project.getId();
    }

    //Liste de projects
    public List<Project> listAll() {
        return this.projectDAO.findAll();
    }

    //Recherche d'un project avec son code
    public Project obtain(String projectCode) {

        return this.projectDAO.findProjectbyCode(projectCode);
    }


    public List<ProcessDTO> callProcess( String name,
                                  String ptype,
                                  String pfollow,
                                         Long projectId) {
        Project project = projectDAO.getOne(projectId);
        List<ProcessDTO> processes = processManagerDAO.listProccessByMappedNameAndProcessTypeFollow(project.getMethod(), ProcessType.ARCHITECTURE.name(),FollowUP.STANDARD.name());
        if (processes!=null) {
            areDone(project,processes);
        }
        return processes;
    }

    private void areDone(Project project, List<ProcessDTO> processes) {
        List<ArtifactDTO> artifacts = processes.stream()
                .map(p-> p.getProcessActivityDTOList())
                .flatMap(list->list.stream())
                .map(pa->pa.getArtifactDTOList())
                .flatMap(list->list.stream())
                .collect(Collectors.toList());
        artifacts.forEach(artifact->{
            artifact.setDone(project.hasArtifact(artifact.getTag()));
        });
    }
}



