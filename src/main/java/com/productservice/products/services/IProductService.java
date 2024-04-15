package com.productservice.products.services;

import com.productservice.products.dtos.ProductRequestDtoFS;
import com.productservice.products.exceptions.ProductOutOfRangeException;
import com.productservice.products.exceptions.ProductRangeUndefinedException;
import com.productservice.products.models.Category;
import com.productservice.products.models.Product;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface IProductService {
    Product getSingleProduct(Long id) throws ProductOutOfRangeException, ProductRangeUndefinedException;

    List<Product> getAllProducts();

    List<Category> getAllCategories();

    List<Product> getAllProductsInCategory(String category);

    Product addProduct(ProductRequestDtoFS productRequestDtoFS);

    Product updateProduct(Long id, ProductRequestDtoFS productRequestDtoFS);

    boolean deleteProduct(Long id);
}
