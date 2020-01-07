package com.bnpparibas.ism.projectmgt.infrastructure;

import org.springframework.data.jpa.repository.JpaRepository;
import com.bnpparibas.ism.projectmgt.domain.ReviewType;
import org.springframework.data.jpa.repository.Query;

public interface ReviewTypeDAO extends JpaRepository<ReviewType, Long> {
//    @Query(value = "SELECT * FROM REVIEWTYPE WHERE REVIEWTYPE_NAME = :name", nativeQuery = true)
//    ReviewType findReviewTypebyName(String name);
}

