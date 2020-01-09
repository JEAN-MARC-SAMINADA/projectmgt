package com.bnpparibas.ism.projectmgt.infrastructure;
import com.bnpparibas.ism.projectmgt.domain.Document;
import org.springframework.data.jpa.repository.JpaRepository;


public interface DocumentDAO extends JpaRepository<Document, Long> {}
