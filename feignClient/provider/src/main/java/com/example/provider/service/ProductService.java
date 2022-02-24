package com.example.provider.service;

import com.example.provider.dto.request.ProductRequest;
import com.example.provider.dto.response.ProductResponse;
import com.example.provider.model.Product;
import com.example.provider.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    ProductRepository repository;

    public ProductResponse get(ProductRequest request){
            ProductResponse response = new ProductResponse();
            if (request.username.charAt(0) == 'A'){
                response.product = repository.findFirstByProductStartsWith(request.username.charAt(0)).getProduct();
            }
            else{
                response.product = repository.findFirstByProductStartsWith('B').getProduct();
            }

            return response;
    }

    public ProductResponse add(String request){
        Product product = new Product();
        product.setProduct(request);
        return productModelToProductResponse(repository.save(product));
    }

    public ProductResponse productModelToProductResponse(Product product){
        ProductResponse response = new ProductResponse();
        response.product = product.getProduct();
        return response;
    }
}
