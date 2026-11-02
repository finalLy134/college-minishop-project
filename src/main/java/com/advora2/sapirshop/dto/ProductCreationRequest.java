package com.advora2.sapirshop.dto;

public record ProductCreationRequest(String name, String description, Double price, Integer stockQuantity) {
}