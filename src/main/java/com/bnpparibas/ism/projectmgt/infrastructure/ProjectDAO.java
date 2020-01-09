package com.bnpparibas.ism.projectmgt.infrastructure;

import com.bnpparibas.ism.projectmgt.domain.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface ProjectDAO extends JpaRepository<Project, Long> {
    @Query(value = "SELECT * FROM PROJECT WHERE PROJECT_CODE = :code", nativeQuery = true)
    Project findProjectbyCode(String code);
}

