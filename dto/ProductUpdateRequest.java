package com.advora2.sapirshop.dto;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotNull;

public record ProductUpdateRequest(
    @NotNull Long id,
    @Nullable String name,
    @Nullable String description,
    @Nullable Double price,
    @Nullable Integer stockQuantity
) {}
