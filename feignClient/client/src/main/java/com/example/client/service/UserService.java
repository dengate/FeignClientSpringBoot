package com.example.client.service;

import com.example.client.api.ProductFeignCallableApi;
import com.example.client.dto.request.ProductRequest;
import com.example.client.dto.request.UserRequest;
import com.example.client.dto.response.UserResponse;
import com.example.client.model.User;
import com.example.client.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {

    @Autowired
    UserRepository repository;
    @Autowired
    ProductFeignCallableApi feignCallableApi;

    public UserResponse add(UserRequest request){
            User user = new User();
            user.setUsername(request.username);
            ProductRequest productRequest = new ProductRequest();
            productRequest.username = request.username;
            user.setProduct(feignCallableApi.get(productRequest).product);
            return userModelToUserResponseDto(repository.save(user));
    }

    public UserResponse userModelToUserResponseDto(User user){
        UserResponse response = new UserResponse();
        response.username = user.getUsername();
        response.product = user.getProduct();
        return response;
    }
}
