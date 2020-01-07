package com.bnpparibas.ism.projectmgt.application;
import com.bnpparibas.ism.projectmgt.domain.Document;
import com.bnpparibas.ism.projectmgt.domain.Project;
import com.bnpparibas.ism.projectmgt.infrastructure.ProjectDAO;
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
}



