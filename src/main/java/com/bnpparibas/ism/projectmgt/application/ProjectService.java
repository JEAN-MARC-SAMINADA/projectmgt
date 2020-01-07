package com.bnpparibas.ism.projectmgt.application;
import com.bnpparibas.ism.projectmgt.domain.Document;
import com.bnpparibas.ism.projectmgt.domain.Project;
import com.bnpparibas.ism.projectmgt.infrastructure.ProjectDAO;
import com.bnpparibas.ism.projectmgt.infrastructure.processmgt.FollowUP;
import com.bnpparibas.ism.projectmgt.infrastructure.processmgt.ProcessDTO;
import com.bnpparibas.ism.projectmgt.infrastructure.processmgt.ProcessManagerDAO;
import com.bnpparibas.ism.projectmgt.infrastructure.processmgt.ProcessType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Set;

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


    public List<ProcessDTO>  callProcessMgt(){
    List<ProcessDTO> processes = processManagerDAO.listProccessByMappedNameAndProcessTypeFollow("WaterFall", ProcessType.ARCHITECTURE.name(),FollowUP.STANDARD.name());
        return processes;

    }
}



