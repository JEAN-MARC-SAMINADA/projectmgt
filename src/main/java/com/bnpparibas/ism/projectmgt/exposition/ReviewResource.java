package com.bnpparibas.ism.projectmgt.exposition;

import com.bnpparibas.ism.projectmgt.application.ReviewService;
import com.bnpparibas.ism.projectmgt.domain.Review;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ReviewResource {
    @Autowired
    private ReviewService reviewService;

    //Création d'une revevue
    @RequestMapping(method = RequestMethod.POST, path = {"/createReview/"})
    @ResponseStatus(HttpStatus.CREATED)
    public Long createReview(@RequestBody Review review) {
        return this.reviewService.create(review);
    }

    //Liste des revues
    @RequestMapping(method = RequestMethod.GET, path = {"/reviewList/"})
    public List<Review> findAll() {
        return reviewService.listAll();
    }

}