package com.bnpparibas.ism.projectmgt.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bnpparibas.ism.projectmgt.domain.Review;
import org.springframework.data.jpa.repository.Query;

public interface ReviewDAO extends JpaRepository<Review, Long> {
  //  @Query(value = "SELECT * FROM REVIEW WHERE REVIEW_NAME = :name", nativeQuery = true)
  //  Review findReviewbyName(String name);
}

