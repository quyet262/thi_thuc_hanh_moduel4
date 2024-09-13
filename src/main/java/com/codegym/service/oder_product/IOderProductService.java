package com.codegym.service.oder_product;

import com.codegym.model.OderProduct;
import com.codegym.service.IGenerateService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;

public interface IOderProductService extends IGenerateService<OderProduct> {
    Page<OderProduct> findAll(Pageable pageable);
    Page<OderProduct> findOderProductByDate(LocalDate starDate, LocalDate endDate , Pageable pageable);
}
