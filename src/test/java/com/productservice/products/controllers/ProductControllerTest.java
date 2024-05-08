package com.productservice.products.controllers;

import com.productservice.products.models.Product;
import com.productservice.products.repositories.ProductRepository;
import com.productservice.products.services.IProductService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.when;

@SpringBootTest
class ProductControllerTest {

    @Autowired
    ProductController productController;

    @MockBean
    IProductService productService;

    @Test
    void getAllProducts() {
        Product p1 = new Product();
        p1.setName("Oppo1");
        Product p2 = new Product();
        p2.setName("Oppo2");
        Product p3 = new Product();
        p3.setName("Iphone");

        List<Product> expectedProductList = List.of(p1,p2,p3);

        Mockito
                .when(productService.getAllProducts())
                .thenReturn(expectedProductList);

        List<Product> actualProductList = productController.getAllProducts();

        Assertions.assertTrue(actualProductList.size()==expectedProductList.size());
    }
}