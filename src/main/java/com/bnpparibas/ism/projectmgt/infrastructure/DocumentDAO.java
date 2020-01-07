package com.bnpparibas.ism.projectmgt.infrastructure;

import com.bnpparibas.ism.projectmgt.domain.Document;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DocumentDAO extends JpaRepository<Document, Long> {
  //  @Query(value = "SELECT * FROM DOCUMENT WHERE DOCUMENT_NAME = :name", nativeQuery = true)
  //  Document findDocumentbyName(String name);

    @Query(value = "SELECT * FROM DOCUMENT WHERE PROJECT_ID = :id", nativeQuery = true)
      List<Document> documentsByProjectId(Long id);

}
