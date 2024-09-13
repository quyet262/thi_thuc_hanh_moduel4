package com.codegym.model;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "product_type")
@Data
public class ProductType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
}
