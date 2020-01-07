package com.bnpparibas.ism.projectmgt.exposition;

import com.bnpparibas.ism.projectmgt.application.TagService;
import com.bnpparibas.ism.projectmgt.domain.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class TagResource {
    @Autowired
    private TagService tagService;

    //Création d'un tag
    @RequestMapping(method = RequestMethod.POST, path = {"/createTag/"})
    @ResponseStatus(HttpStatus.CREATED)
    public Long createTag(@RequestBody Tag tag) {
        return this.tagService.create(tag);
    }

    //Liste des tags
    @RequestMapping(method = RequestMethod.GET, path = {"/tagsList/"})
    public List<Tag> findAll() {
        return tagService.listAll();
    }

    //Recherche d'un tag avec l'id
    @RequestMapping(method = RequestMethod.GET, path = {"/tag/{id}"})
    public Tag findTag(@PathVariable("id") Long id) {
        return this.tagService.findTag(id);
    }

}