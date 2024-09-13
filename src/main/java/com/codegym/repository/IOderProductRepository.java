package com.codegym.repository;

import com.codegym.model.OderProduct;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@Repository
public interface IOderProductRepository extends JpaRepository<OderProduct, Long> {
    Page<OderProduct> findAll(Pageable pageable);

    @Query(nativeQuery = true, value = "SELECT * FROM oders o WHERE o.date_oder BETWEEN :startDate AND :endDate")
    Page<OderProduct> findOderProductByDate(@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate, Pageable pageable);
}
