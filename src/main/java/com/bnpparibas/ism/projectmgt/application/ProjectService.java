package com.bnpparibas.ism.projectmgt.application;
import com.bnpparibas.ism.projectmgt.domain.Project;
import com.bnpparibas.ism.projectmgt.infrastructure.ProjectDAO;
import com.bnpparibas.ism.projectmgt.infrastructure.processmgt.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

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

    //Liste tous les projects
    public List<Project> listAll() {
        return this.projectDAO.findAll();
    }

    //Recherche d'un project avec son code
    public Project obtain(String projectCode) {
        return this.projectDAO.findProjectbyCode(projectCode);
    }

    /* Appel au service de l'application "PROCESS MANAGEMENT" pour avoir la liste des activités et des artifacts pour un projet en fonction des parametres suivants :
        - le nom de la méthode : "MéthodeMapping (comme déclaré dans l'outil CLARITY")
        - le type de "process (ACHTITECTURE ou QUALITY)
        - le type de suivi (STANDARD, ALLEGE ou RENFORCEE)
        - l'identifiant du projet concerné (pour de mettre à jour l'indicateur sur les artifacts (fait/nonFait)*/
    public List<ProcessDTO> callProcess(String name,
                                        String ptype,
                                        String pfollow,
                                        Long projectId) {
        Project project = projectDAO.getOne(projectId);
        List<ProcessDTO> processes = processManagerDAO.listProccessByMappedNameAndProcessTypeFollow(project.getMethod(), ProcessType.ARCHITECTURE.name(),FollowUP.STANDARD.name());
        if (processes!=null){
            areDone(project,processes); // mise à jour l'indicateur sur les artifacts (fait/nonFait) du projet
        }
            return processes;
    }

    // métode de mise mise à jour l'indicateur sur les artifacts avec en parametre un projet et la liste des processes de validation du projet)
    private void areDone(Project project, List<ProcessDTO> processes) {
        List<ArtifactDTO> artifacts = processes.stream()
                .map(p-> p.getProcessActivityDTOList())
                .flatMap(list->list.stream())
                .map(pa->pa.getArtifactDTOList())
                .flatMap(list->list.stream())
                .collect(Collectors.toList());
        artifacts.forEach(artifact->{
            artifact.setDone(project.hasArtifact(artifact.getTag()));   //mise à jour de l'indicateur lorsque l'artifact est présent
        });
    }
}



