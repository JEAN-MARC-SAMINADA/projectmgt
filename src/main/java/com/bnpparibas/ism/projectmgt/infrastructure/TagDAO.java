package com.bnpparibas.ism.projectmgt.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bnpparibas.ism.projectmgt.domain.Tag;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface TagDAO extends JpaRepository<Tag, Long> {
   // @Query(value = "SELECT * FROM TAG WHERE TAG_NAME = :name", nativeQuery = true)
   // Tag findTagbyName(String name);
}

