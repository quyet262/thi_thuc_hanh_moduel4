package com.codegym.service.oder_product;

import com.codegym.model.OderProduct;
import com.codegym.repository.IOderProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class OderProductService implements IOderProductService{
    private final IOderProductRepository oderProductRepository;
    public OderProductService(IOderProductRepository oderProductRepository) {
        this.oderProductRepository = oderProductRepository;
    }

    @Override
    public Iterable<OderProduct> findAll() {
        return oderProductRepository.findAll();
    }

    @Override
    public void save(OderProduct oderProduct) {
    oderProductRepository.save(oderProduct);
    }

    @Override
    public Optional<OderProduct> findById(Long id) {
        return oderProductRepository.findById(id);
    }

    @Override
    public void remove(Long id) {
    oderProductRepository.deleteById(id);
    }

    @Override
    public Page<OderProduct> findAll(Pageable pageable) {
        return oderProductRepository.findAll(pageable);
    }

    @Override
    public Page<OderProduct> findOderProductByDate(LocalDate starDate, LocalDate endDate, Pageable pageable) {
        return oderProductRepository.findOderProductByDate(starDate, endDate, pageable);
    }
}
