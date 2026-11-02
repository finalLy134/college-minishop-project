package com.advora2.sapirshop.service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.advora2.sapirshop.dto.ProductCreationRequest;
import com.advora2.sapirshop.dto.ProductDTO;
import com.advora2.sapirshop.dto.ProductUpdateRequest;
import com.advora2.sapirshop.entity.Product;
import com.advora2.sapirshop.repository.ProductRepository;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;

@Service 
public class ProductService {
    
    @Autowired 
    private ProductRepository productRepository;

    public List<ProductDTO> getAllProducts() {
        return productRepository.findAll().stream()
                    .map(ProductDTO::toDTO)
                    .collect(Collectors.toList());
    }

    public Optional<ProductDTO> getProductById(Long id) {
        return productRepository.findById(id)
                    .map(ProductDTO::toDTO);
    }

    public ProductDTO createProduct(ProductCreationRequest request) {
        Product product = new Product(request);
        return productRepository.save(product).toDTO();
    }

    @Transactional 
    public ProductDTO updateProduct(ProductUpdateRequest request) {
        Product product = productRepository.findById(request.id())
            .orElseThrow(() -> new EntityNotFoundException("Product not found"));
        product.update(request);
        return product.toDTO();
    }

    public void deleteProduct(Long id) {
        Product product = productRepository.findById(id)
            .orElseThrow(() -> new EntityNotFoundException("Product not found"));
        productRepository.delete(product);
    }

}
