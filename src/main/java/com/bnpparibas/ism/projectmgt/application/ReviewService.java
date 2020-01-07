package com.bnpparibas.ism.projectmgt.application;

import com.bnpparibas.ism.projectmgt.domain.Review;
import com.bnpparibas.ism.projectmgt.infrastructure.ReviewDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;


@Transactional
@Service
public class ReviewService {
    @Autowired
    private ReviewDAO reviewDAO;

    //Création d'une revue ->si Ok restitution de l'Id de la revue crée
    public Long create(Review newReview) {
        Review review = this.reviewDAO.save(newReview);
        return review.getId();
    }

    //Liste des revues
    public List<Review> listAll() {
        return this.reviewDAO.findAll();
    }

}


