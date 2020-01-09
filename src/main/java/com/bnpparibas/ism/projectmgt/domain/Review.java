package com.bnpparibas.ism.projectmgt.domain;
import javax.persistence.*;

@Entity(name = "REVIEW")
public class Review {

    //Identifiant généré automatiquement
    @Id
    @GeneratedValue
    @Column(name = "REVIEW_ID")
    private Long id;

    //Nom de review; exemple : Revue Préparation
    @Column(name = "REVIEW_NAME")
    private String name;

    //Une revue ne peut avoir qu'un seul type de revue
    //Un même type de review peut designer plusieurs revues
    @ManyToOne
    @JoinColumn(name = "REVIEWTYPE_ID")
    private ReviewType reviewType;

    //annotation permettant de récupérer la liste des revue liées à un projet sans pouvoir accéder au projet via la revue
    @Transient
    private Project project;


    //Constructeurs

    public Review() {
    }

    public Review(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Review(Long id, String name, ReviewType reviewType) {
        this.id = id;
        this.name = name;
        this.reviewType = reviewType;
    }

    //Getters & Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() { return name; }

    public void setName(String name) {
        this.name = name;
    }

    public ReviewType getReviewType() {
        return reviewType;
    }

    public void setReviewType(ReviewType reviewType) {
        this.reviewType = reviewType;
    }

    public void updateReview(Review reviewWithNewInformations) {
        this.name = reviewWithNewInformations.getName();
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
