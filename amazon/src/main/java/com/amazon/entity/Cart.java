package com.amazon.entity;

import com.lld.entity.AbstractEntity;

import java.util.Map;

public class Cart extends AbstractEntity<Cart> {

    private String userId;
    private Map<String, Integer> productIdQuantityMap;

    @Override
    public Cart clone() {
        // TODO
        return null;
    }
}
