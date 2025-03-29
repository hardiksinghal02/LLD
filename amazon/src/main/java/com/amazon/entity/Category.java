package com.amazon.entity;

import com.lld.entity.AbstractEntity;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class Category extends AbstractEntity<Category> {
    private final String name;
    private final Integer level;
    private Category parentCategory;

    @Override
    public Category clone() {
        return this;
    }
}
