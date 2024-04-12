package com.productservice.ecommercewebsite.services;

import com.productservice.ecommercewebsite.dtos.ProductResponseDtoFS;
import com.productservice.ecommercewebsite.exceptions.ProductOutofRangeException;
import com.productservice.ecommercewebsite.models.Category;
import com.productservice.ecommercewebsite.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreProductService implements IProductService{
    @Autowired
    RestTemplate restTemplate;
    @Override
    public Product getSingleProduct(Long id) throws ProductOutofRangeException {
        if(id>20 && id<=40){
            throw new ProductOutofRangeException();
        }
        ProductResponseDtoFS responseDtoFS = restTemplate.getForObject("https://fakestoreapi.com/products/"+id,
                ProductResponseDtoFS.class);

        return getProductFromProductResponse(responseDtoFS);
    }

    @Override
    public List<Product> getAllProducts() {
        ProductResponseDtoFS[] responseDtoFS = restTemplate.getForObject("https://fakestoreapi.com/products",
                ProductResponseDtoFS[].class);

        List<Product> productList = new ArrayList<>();

        for (ProductResponseDtoFS productResponseDtoFS : responseDtoFS){
            productList.add(getProductFromProductResponse(productResponseDtoFS));
        }

        return productList;
    }

    @Override
    public List<Product> getProductsByName(String name) {
        return null;
    }

    private Product getProductFromProductResponse(ProductResponseDtoFS responseDtoFS) {
        Product product = new Product();

        product.setId(responseDtoFS.getId());
        product.setName(responseDtoFS.getTitle());
        product.setPrice(responseDtoFS.getPrice());
        product.setDescription(responseDtoFS.getDescription());
        product.setImage(responseDtoFS.getImage());
        product.setCategory(new Category());
        product.getCategory().setName(responseDtoFS.getCategory());

        return product;
    }
}
