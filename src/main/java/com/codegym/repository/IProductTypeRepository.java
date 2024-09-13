package com.codegym.repository;

import com.codegym.model.ProductType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductTypeRepository extends JpaRepository<ProductType, Long> {
}
