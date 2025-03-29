package com.amazon.entity;

import com.lld.entity.AbstractEntity;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;

@Getter
@Builder
public abstract class Product extends AbstractEntity<Product> {
    private String name;
    private BigDecimal price;
    private String description;
    private String sellerId;
    private Integer stock;
    private String categoryId;
}
