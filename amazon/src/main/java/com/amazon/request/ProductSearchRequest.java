package com.amazon.request;

import com.amazon.entity.Category;
import lombok.Getter;

@Getter
public class ProductSearchRequest {
    private String query;
    private Category category;
}
