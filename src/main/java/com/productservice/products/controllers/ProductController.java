package com.productservice.products.controllers;

import com.productservice.products.dtos.ProductRequestDtoFS;
import com.productservice.products.exceptions.ProductOutOfRangeException;
import com.productservice.products.exceptions.ProductRangeUndefinedException;
import com.productservice.products.models.Category;
import com.productservice.products.models.Product;
import com.productservice.products.repositories.ProductRepository;
import com.productservice.products.services.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProductController {

    @Autowired
    @Qualifier("FakeStoreProductService")
    IProductService iProductService;

    @Autowired
    ProductRepository productRepository;

    @GetMapping("/products")
    public List<Product> getAllProducts() {
        return iProductService.getAllProducts();
    }

    @GetMapping("/product/{id}")
    public Product getSingleProduct(@PathVariable Long id) throws ProductOutOfRangeException, ProductRangeUndefinedException {
        return iProductService.getSingleProduct(id);
    }

    @GetMapping("/product/search")
    public List<Product> getSingleProductByName(@RequestParam("name") String name){
        return productRepository.findByName(name);
    }

    @GetMapping("/products/{price}")
    public List<Product> getAllProductsGreaterThanPrice(@PathVariable Float price){
        return productRepository.findByPriceGreaterThanEqual(price);
    }

    @GetMapping("/products/description/{description}")
    public List<Product> getAllProductsByDescription(@PathVariable String description){
        return productRepository.findByDescription(description);
    }

    @GetMapping("/products/categories")
    public List<Category> getAllCategories() {
        return iProductService.getAllCategories();
    }

    @GetMapping("/products/category/{category}")
    public List<Product> getAllProductsInCategory(@PathVariable String category) {
        return iProductService.getAllProductsInCategory(category);
    }

    @PostMapping("/products")
    public Product addProduct(@RequestBody ProductRequestDtoFS productRequestDtoFS) {
        return iProductService.addProduct(productRequestDtoFS);
    }

    @PatchMapping("/products/{id}")
    public Product updateProduct(@PathVariable Long id, @RequestBody ProductRequestDtoFS productRequestDtoFS) {
        return iProductService.updateProduct(id, productRequestDtoFS);
    }

    @DeleteMapping("products/{id}")
    public boolean deleteProduct(@PathVariable Long id) {
        return iProductService.deleteProduct(id);
    }

 }
