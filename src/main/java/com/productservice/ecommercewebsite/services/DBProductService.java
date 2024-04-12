package com.productservice.ecommercewebsite.services;

import com.productservice.ecommercewebsite.exceptions.ProductNotFoundException;
import com.productservice.ecommercewebsite.exceptions.ProductOutofRangeException;
import com.productservice.ecommercewebsite.models.Product;
import com.productservice.ecommercewebsite.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DBProductService implements IProductService{

    @Autowired
    ProductRepository productRepository;
    @Override
    public Product getSingleProduct(Long id) throws ProductOutofRangeException {
        Product product = productRepository.getProductById(id);
        if(product==null){
            throw new ProductOutofRangeException();
        }
        return product;
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> getProductsByName(String name) throws ProductNotFoundException {
        List<Product> productList = productRepository.findByName(name);

        if (productList.isEmpty()){
            throw new ProductNotFoundException();
        }

        return productList;
    }


}
