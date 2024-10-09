package com.untitled.rrss.service;

import com.untitled.rrss.entity.Product;
import com.untitled.rrss.entity.User;

import java.util.List;

public interface ProductService {
    List<Product> findAll();

    Product findById(int theId);

    Product save(Product theProduct);

    void deleteById(int theId);
}
