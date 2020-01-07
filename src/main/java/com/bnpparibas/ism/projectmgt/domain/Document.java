package com.bnpparibas.ism.projectmgt.domain;
import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@JsonIdentityInfo(generator = ObjectIdGenerators.UUIDGenerator.class, property="@UUID")
@Entity(name = "DOCUMENT")
public class Document {

    //Identifiant généré automatiquement
    @Id
    @GeneratedValue
    @Column(name = "DOCUMENT_ID")
    private Long id;

    //Nom de document; exemple : Dossier d'architecture
    @Column(name = "DOCUMENT_NAME")
    private String name;


    //Un document ne peut avoir qu'un seul Tag
    //Un même Tag peut designer plusieurs documents
    @ManyToOne
    @JoinColumn(name = "TAG_ID")
//    @Transient
    private Tag tag;


    //Un projet est constitué de plusieurs documents
    //Un document ne peut appartenir qu'un seul projet
//    @ManyToOne
//    @JoinColumn(name = "PROJECT_ID")
    @Transient
    private Project project;


    //Constructeurs

    public Document() {}

    public Document(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Document(Long id, String name, Tag tag) {
        this.id = id;
        this.name = name;
        this.tag = tag;
    }

    public Document(Long id, String name, Tag tag, Project project) {
        this.id = id;
        this.name = name;
        this.tag = tag;
        this.project = project;
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

    public Tag getTag() {
        return tag;
    }

    public void setTag(Tag tag) {
        this.tag = tag;
    }

    public Project getProject() {
        return project;
    }

    public void setProject(Project project) {
        this.project = project;
    }
}
