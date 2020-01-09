package com.bnpparibas.ism.projectmgt.application;

import com.bnpparibas.ism.projectmgt.domain.ReviewType;
import com.bnpparibas.ism.projectmgt.infrastructure.ReviewTypeDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;

@Transactional
@Service
public class ReviewTypeService {
    @Autowired
    private ReviewTypeDAO reviewTypeDAO;

    //Création d'un type de revue ->si Ok restitution de l'Id du type de revue crée
    public Long create(ReviewType newReviewType) {
        ReviewType reviewType = this.reviewTypeDAO.save(newReviewType);
        return reviewType.getId();
    }

    //Liste des types de revue
    public List<ReviewType> listAll() {
        return this.reviewTypeDAO.findAll();
    }

}

