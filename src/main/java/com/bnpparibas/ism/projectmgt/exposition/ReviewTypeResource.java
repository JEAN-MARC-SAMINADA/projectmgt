package com.bnpparibas.ism.projectmgt.exposition;

import com.bnpparibas.ism.projectmgt.application.ReviewTypeService;
import com.bnpparibas.ism.projectmgt.domain.ReviewType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReviewTypeResource {
    @Autowired
    private ReviewTypeService reviewTypeService;

    //Création d'un type de revue
    @RequestMapping(method = RequestMethod.POST, path = {"/createReviewType/"})
    @ResponseStatus(HttpStatus.CREATED)
    public Long createReviewType(@RequestBody ReviewType reviewType) {
        return this.reviewTypeService.create(reviewType);
    }

    //Liste des types de revue
    @RequestMapping(method = RequestMethod.GET, path = {"/reviewTypesList/"})
    public List<ReviewType> findAll() {
        return reviewTypeService.listAll();
    }

}

