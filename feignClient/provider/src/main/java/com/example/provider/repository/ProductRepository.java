package com.example.provider.repository;

import com.example.provider.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
    public Product findFirstByProductStartsWith(char firstChar);
}
