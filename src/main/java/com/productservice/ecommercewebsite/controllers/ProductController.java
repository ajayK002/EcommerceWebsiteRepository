package com.productservice.ecommercewebsite.controllers;

import com.productservice.ecommercewebsite.exceptions.ProductNotFoundException;
import com.productservice.ecommercewebsite.exceptions.ProductOutofRangeException;
import com.productservice.ecommercewebsite.models.Product;
import com.productservice.ecommercewebsite.repositories.ProductRepository;
import com.productservice.ecommercewebsite.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {
    @Autowired
    IProductService iProductService;

    @GetMapping("/product/{id}")
    public Product getSingleProduct(@PathVariable Long id) throws ProductOutofRangeException{
        return iProductService.getSingleProduct(id);
    }

    @GetMapping("/products/search")
    public List<Product> getProductsByName(@RequestParam("name") String name) throws ProductNotFoundException {
        return iProductService.getProductsByName(name);
    }

    @GetMapping("/products")
    public List<Product> getAllProducts(){
        return iProductService.getAllProducts();
    }
}
