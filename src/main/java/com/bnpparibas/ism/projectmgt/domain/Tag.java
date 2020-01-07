package com.bnpparibas.ism.projectmgt.domain;
import javax.persistence.*;
import java.util.Set;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;


@JsonIdentityInfo(generator = ObjectIdGenerators.UUIDGenerator.class, property="@UUID")
@Entity(name = "TAG")
public class Tag {

    //Identifiant généré automatiquement
    @Id
    @GeneratedValue
    @Column(name = "TAG_ID")
    private Long id;

    //Nom du tag du document; exemple : doss_arch (pour Dossier d'architecture)
    @Column(name = "TAG_NAME")
    private String name;


    //Un même Tag peut designer plusieurs documents
    //Un document ne peut avoir qu'un seul Tag
//    @OneToMany(mappedBy = "tag")
    @Transient
    private Set<Document> documents;


    //Constructeurs
    public Tag() {}

    public Tag(Long id, String name) {
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

    public Set<Document> getDocuments() {
        return documents;
    }

    public void setDocuments(Set<Document> documents) {
        this.documents = documents;
    }
}
