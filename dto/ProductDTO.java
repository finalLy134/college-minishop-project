package com.advora2.sapirshop.dto;

import com.advora2.sapirshop.entity.Product;

public record ProductDTO(Long id, String name, String description, Double price, Integer stockQuantity) {
    public static ProductDTO toDTO(Product product) {
        return new ProductDTO(
            product.getId(),
            product.getName(),
            product.getDescription(),
            product.getPrice(),
            product.getStockQuantity()
        );
    }
}