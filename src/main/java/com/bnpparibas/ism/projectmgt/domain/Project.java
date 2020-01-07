package com.bnpparibas.ism.projectmgt.domain;
import javax.persistence.*;
import java.util.Set;


@Entity(name = "PROJECT")
public class Project {

    //Identifiant généré automatiquement
    @Id
    @GeneratedValue
    @Column(name = "PROJECT_ID")
    private Long id;

    //Code du projet; exemple : PJxxxxxx
    @Column(name="PROJECT_CODE")
    private String code;

    //Nom du projet; exemple : Entree en relation Grande Compte
    @Column(name="PROJECT_NAME")
    private String name;

    //Nom de la méthode utilisée; exemple : Agile/Traditionnelle
    @Column(name="PROJECT_METHOD")
    private String method;

    //Followup : STANDARD, LIGHT ou ENFORCED
    @Enumerated (EnumType.STRING)
    @Column(name = "PROJECT_FOLLOWUP")
    private Followup followup;


    //Un projet est constitué de plusieurs documents
    //Un document ne peut appartenir qu'un seul projet
    //@OneToMany(mappedBy = "project")
    @OneToMany
    @JoinColumn(name = "PROJECT_ID")
    private Set<Document> documents;

    //Un projet peut faire l'objet de plusieurs revues
    //Une revue ne concerne qu'un seul projet
    //@OneToMany(mappedBy = "project")
    @OneToMany
    @JoinColumn(name = "PROJECT_ID")
    private Set<Review> reviews;

//Constructeurs

    public Project() {}

    public Project(Long id, String code, String name, String method, Followup followup) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.method = method;
        this.followup = followup;
    }

//Getters & Setters

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getCode() { return code; }

    public void setCode(String code) { this.code = code; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMethod() { return method; }

    public void setMethod(String method) { this.method = method; }

    public Followup getFollowup() { return followup; }

    public void setFollowup(Followup followup) { this.followup = followup; }

    public Set<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(Set<Document> documents) {
        this.documents = documents;
    }

    public Set<Review> getReviews() {
        return reviews;
    }

    public void setReviews(Set<Review> reviews) {
        this.reviews = reviews;
    }


}
