package com.example.client.controller;

import com.example.client.dto.request.UserRequest;
import com.example.client.dto.response.UserResponse;
import com.example.client.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/client/user")
public class UserController {

    @Autowired
    UserService service;

    @PostMapping("/add")
    public ResponseEntity<UserResponse> add(@RequestBody UserRequest request){
            UserResponse response = service.add(request);
            return ResponseEntity.ok(response);
    }
}
