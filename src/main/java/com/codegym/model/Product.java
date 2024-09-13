package com.codegym.model;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Table(name = "products")
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private Double price;
    private String ProductStatus;
    @ManyToOne
    @JoinColumn(name = "product_type_id")
    private ProductType productType;

}
