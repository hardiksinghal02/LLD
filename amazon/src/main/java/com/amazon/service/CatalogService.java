package com.amazon.service;

import com.amazon.entity.Product;
import com.amazon.request.ProductSearchRequest;

import java.util.List;

public interface CatalogService {

    Product addItem(Product product);

    List<Product> findItems(ProductSearchRequest productSearchRequest);

    Product getProductById(String productId);


}
