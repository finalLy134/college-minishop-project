package com.advora2.sapirshop.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.advora2.sapirshop.dto.ProductCreationRequest;
import com.advora2.sapirshop.dto.ProductDTO;
import com.advora2.sapirshop.dto.ProductUpdateRequest;
import com.advora2.sapirshop.service.ProductService;

@RestController 
@RequestMapping("/api/products")
public class ProductsController {

    private final ProductService productService;

    public ProductsController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<List<ProductDTO>> getAllProducts() {
        return new ResponseEntity<>(this.productService.getAllProducts(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<ProductDTO> getProductById(@PathVariable Long id) {
        return this.productService.getProductById(id)
                    .map(ResponseEntity::ok)
                    .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<ProductDTO> createProduct(@RequestBody ProductCreationRequest request) {
        ProductDTO newProductDTO = this.productService.createProduct(request);
        return new ResponseEntity<>(newProductDTO, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductDTO> updateProduct(@RequestBody ProductUpdateRequest request) {
        ProductDTO updatedProductDTO = this.productService.updateProduct(request);
        return new ResponseEntity<>(updatedProductDTO, HttpStatus.OK);
    }

}
