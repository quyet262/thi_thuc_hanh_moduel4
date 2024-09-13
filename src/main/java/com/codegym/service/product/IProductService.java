package com.codegym.service.product;

import com.codegym.model.Product;
import com.codegym.service.IGenerateService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IProductService extends IGenerateService<Product> {
    Page<Product> findAll(Pageable pageable);

}
