package com.bnpparibas.ism.projectmgt.domain;
import javax.persistence.*;
import java.util.Set;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(generator = ObjectIdGenerators.UUIDGenerator.class, property="@UUID")
@Entity(name = "REVIEWTYPE")
public class ReviewType {

    //Identifiant généré automatiquement
    @Id
    @GeneratedValue
    @Column(name = "REVIEWTYPE_ID")
    private Long id;

    //Nom du type de revue; exemple : rev_prepa (pour Revue Préparation)
    @Column(name = "REVIEWTYPE_NAME")
    private String name;

    //Annotation permettant de récupérer le type de la revue sans pouvoir accéder à la revue via son type
    @Transient
    private Set<Review> reviews;

    //Constructeurs
    public ReviewType() {
    }

    public ReviewType(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    //Getters & Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Review> getReview() {
        return reviews;
    }

    public void setReviews(Set<Review> reviews) {
        this.reviews = reviews;
    }

}

