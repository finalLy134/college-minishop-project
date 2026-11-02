package com.advora2.sapirshop.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.advora2.sapirshop.entity.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {
}