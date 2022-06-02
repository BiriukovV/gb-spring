package com.geekbrains.spring.hwlesson2.service;

import com.geekbrains.spring.hwlesson2.persistence.Cart;
import com.geekbrains.spring.hwlesson2.persistence.Product;

import java.math.BigDecimal;

public interface CartService {

    Cart getNewCart();

    void addProduct(Cart cart, Product product, Integer quantity);
    void addProduct(Cart cart, Long prodId, Integer quantity);

    void removeProduct(Cart cart, Product product, Integer quantity);

    BigDecimal getSum(Cart cart);

    void printCart(Cart cart);

    int getProductQuantity(Cart cart, Product product);
    int getProductQuantity(Cart cart, Long prodId);

}
