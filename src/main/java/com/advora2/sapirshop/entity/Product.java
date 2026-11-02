package com.advora2.sapirshop.entity;

import com.advora2.sapirshop.dto.ProductCreationRequest;
import com.advora2.sapirshop.dto.ProductDTO;
import com.advora2.sapirshop.dto.ProductUpdateRequest;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity 
@Table(name = "products")
@Getter 
@Setter 
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Product {
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank 
    @Column(nullable = false)
    private String name;

    private String description;

    @Min(value = 0, message = "The minimum allowed price is 0.0")
    @Column(nullable = false)
    private Double price;

    @Min(value = 0, message = "The minimum allowed quantity is 0")
    private Integer stockQuantity;

    public Product(ProductCreationRequest request) {
        this.name = request.name();
        this.description = request.description();
        this.price = request.price();
        this.stockQuantity = request.stockQuantity();
    }

    public Product(ProductUpdateRequest request) {
        this.name = request.name();
        this.description = request.description();
        this.price = request.price();
        this.stockQuantity = request.stockQuantity();
    }

    public void update(ProductUpdateRequest request) {
        if (request.name() != null) this.name = request.name();
        if (request.description() != null) this.description = request.description();
        if (request.price() != null) this.price = request.price();
        if (request.stockQuantity() != null) this.stockQuantity = request.stockQuantity();
    }

    public ProductDTO toDTO() {
        return ProductDTO.toDTO(this);
    }
}
