package com.geekbrains.spring.hwlesson2.service;

import com.geekbrains.spring.hwlesson2.persistence.Product;

import java.util.List;

public interface ProductService {

    List<Product>getProductList();

    void    saveOrUpdate(Product product);

    Product getProductById(Long id);

    void removeById(Long id);


}
