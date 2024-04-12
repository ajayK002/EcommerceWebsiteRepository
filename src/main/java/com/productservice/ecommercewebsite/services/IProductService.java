package com.productservice.ecommercewebsite.services;

import com.productservice.ecommercewebsite.exceptions.ProductNotFoundException;
import com.productservice.ecommercewebsite.exceptions.ProductOutofRangeException;
import com.productservice.ecommercewebsite.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IProductService {
    Product getSingleProduct(Long id) throws ProductOutofRangeException;

    List<Product> getAllProducts();

    List<Product> getProductsByName(String name) throws ProductNotFoundException;
}
