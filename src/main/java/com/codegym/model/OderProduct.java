package com.codegym.model;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "oders")
@Data
public class OderProduct {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate dateOder;
    private Long quantity;
    @ManyToOne
    @JoinColumn(name = "product_id")
    private Product product;
}
