package com.bnpparibas.ism.projectmgt.application;

import com.bnpparibas.ism.projectmgt.domain.Document;
import com.bnpparibas.ism.projectmgt.infrastructure.DocumentDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
@Service
public class DocumentService {

    @Autowired
    private DocumentDAO documentDAO;

    //Création d'un document->si Ok restitution de l'Id du document crée
    public Long create(Document newDocument) {
        Document document = this.documentDAO.save(newDocument);
        return document.getId();
    }

    //Liste de documents
    public List<Document> listAll() {
        return this.documentDAO.findAll();
    }

    //Liste des documents d'un projet
    public List<Document> findDocumentsByProjectId (Long id) {return this.documentDAO.documentsByProjectId(id);}

}
