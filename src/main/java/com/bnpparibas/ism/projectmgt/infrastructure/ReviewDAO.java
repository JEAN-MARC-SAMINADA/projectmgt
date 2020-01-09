package com.bnpparibas.ism.projectmgt.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bnpparibas.ism.projectmgt.domain.Review;

public interface ReviewDAO extends JpaRepository<Review, Long> {}

