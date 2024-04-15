package com.productservice.products.services;

import com.productservice.products.dtos.ProductRequestDtoFS;
import com.productservice.products.dtos.ProductResponseDtoFS;
import com.productservice.products.exceptions.ProductOutOfRangeException;
import com.productservice.products.exceptions.ProductRangeUndefinedException;
import com.productservice.products.models.Category;
import com.productservice.products.models.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Service
public class FakeStoreProductService implements IProductService {

    @Autowired
    RestTemplate restTemplate;

    @Override
    public Product getSingleProduct(Long id) throws ProductOutOfRangeException, ProductRangeUndefinedException {
        if(id>20 && id<=40){
            throw new ProductOutOfRangeException();
        } else if (id>40) {
            throw new ProductRangeUndefinedException();
        }
        ProductResponseDtoFS productResponseDtoFS = restTemplate.getForObject("https://fakestoreapi.com/products/" + id,
                ProductResponseDtoFS.class);

        return getProductFromProductResponse(productResponseDtoFS);
    }

    @Override
    public List<Product> getAllProducts() {
        ProductResponseDtoFS[] productResponses = restTemplate.getForObject("https://fakestoreapi.com/products",
                ProductResponseDtoFS[].class);

        List<Product> productsList = new ArrayList<>();

        for (ProductResponseDtoFS productResponse : productResponses) {
            productsList.add(getProductFromProductResponse(productResponse));
        }

        return productsList;
    }

    @Override
    public List<Category> getAllCategories() {
        String[] categories = restTemplate.getForObject("https://fakestoreapi.com/products/categories",
                String[].class);

        List<Category> categoryList = new ArrayList<>();
        for (String category : categories) {
            categoryList.add(new Category());
            categoryList.get(categoryList.size() - 1).setName(category);
        }

        return categoryList;
    }

    @Override
    public List<Product> getAllProductsInCategory(String category) {
        ProductResponseDtoFS[] productResponses = restTemplate.getForObject("https://fakestoreapi.com/products/category/" + category,
                ProductResponseDtoFS[].class);

        List<Product> productList = new ArrayList<>();

        for (ProductResponseDtoFS productResponse : productResponses) {
            productList.add(getProductFromProductResponse(productResponse));
        }

        return productList;
    }

    @Override
    public Product addProduct(ProductRequestDtoFS productRequestDtoFS) {
        ProductResponseDtoFS productResponseDtoFS = restTemplate.postForObject("https://fakestoreapi.com/products",
                productRequestDtoFS,
                ProductResponseDtoFS.class);

        return getProductFromProductResponse(productResponseDtoFS);
    }

    @Override
    public Product updateProduct(Long id, ProductRequestDtoFS productRequestDtoFS) {
        ProductResponseDtoFS productResponseDtoFS = restTemplate.patchForObject("https://fakestoreapi.com/products/1",
                productRequestDtoFS,
                ProductResponseDtoFS.class);

        return getProductFromProductResponse(productResponseDtoFS);
    }

    @Override
    public boolean deleteProduct(Long id) {
        restTemplate.delete("https://fakestoreapi.com/products/"+id);
        return true;
    }

    private Product getProductFromProductResponse(ProductResponseDtoFS productResponseDtoFS) {

        Product product = new Product();

        product.setId(productResponseDtoFS.getId());
        product.setName(productResponseDtoFS.getTitle());
        product.setDescription(productResponseDtoFS.getDescription());
        product.setImage(productResponseDtoFS.getImage());
        product.setPrice(productResponseDtoFS.getPrice());
        product.setCategory(new Category());
        product.getCategory().setName(productResponseDtoFS.getCategory());

        return product;
    }
}
