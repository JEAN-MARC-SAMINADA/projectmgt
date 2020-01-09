package com.bnpparibas.ism.projectmgt.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bnpparibas.ism.projectmgt.domain.ReviewType;

public interface ReviewTypeDAO extends JpaRepository<ReviewType, Long> {}

