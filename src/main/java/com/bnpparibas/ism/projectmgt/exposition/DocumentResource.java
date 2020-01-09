package com.bnpparibas.ism.projectmgt.exposition;

import com.bnpparibas.ism.projectmgt.application.DocumentService;
import com.bnpparibas.ism.projectmgt.domain.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DocumentResource {
    @Autowired
    private DocumentService documentService;

    //Création d'un document
    @RequestMapping(method = RequestMethod.POST, path = {"/createDocument/"})
    @ResponseStatus(HttpStatus.CREATED)
    public Long createDocument(@RequestBody Document document) {
        return this.documentService.create(document);
    }

    //Liste des documents
    @RequestMapping(method = RequestMethod.GET, path = {"/documentsList/"})
    public List<Document> findAll() {
        return documentService.listAll();
    }

}



