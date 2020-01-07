package com.bnpparibas.ism.projectmgt.application;

import com.bnpparibas.ism.projectmgt.domain.Tag;
import com.bnpparibas.ism.projectmgt.infrastructure.TagDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Transactional
@Service
public class TagService {
    @Autowired
    private TagDAO tagDAO;

    //Création d'un tag ->si Ok restitution de l'Id du tag crée
    public Long create(Tag newtag) {
        Tag tag = this.tagDAO.save(newtag);
        return tag.getId();
    }

    //Liste de tags
    public List<Tag> listAll() {
        return this.tagDAO.findAll();
    }

    //Liste de tags
    public Tag  findTag(long id) {
        return this.tagDAO.findById(id).get();
    }


}

