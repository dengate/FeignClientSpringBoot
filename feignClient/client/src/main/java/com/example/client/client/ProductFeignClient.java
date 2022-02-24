package com.example.client.client;

import com.example.client.api.ProductFeignCallableApi;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "provider")
public interface ProductFeignClient extends ProductFeignCallableApi {
}
