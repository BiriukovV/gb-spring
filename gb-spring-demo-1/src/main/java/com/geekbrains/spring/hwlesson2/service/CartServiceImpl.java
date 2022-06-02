package com.geekbrains.spring.hwlesson2.service;

import com.geekbrains.spring.demo6.ProductService;
import com.geekbrains.spring.hwlesson2.persistence.Cart;
import com.geekbrains.spring.hwlesson2.persistence.Product;
import com.geekbrains.spring.hwlesson2.persistence.ProductRepository;

import java.math.BigDecimal;
import java.util.Map;

public class CartServiceImpl implements CartService {

    private final ProductRepository productRepository;


    public CartServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public Cart getNewCart() {
        return null;
    }

    @Override
    public void addProduct(Cart cart, Product product, Integer quantity) {
        cart.addProduct(product, quantity);
    }

    @Override
    public void addProduct(Cart cart, Long prodId, Integer quantity) {
        Product product = productRepository.findById(prodId);
        this.addProduct(cart, product, quantity);
    }

    @Override
    public void removeProduct(Cart cart, Product product, Integer quantity) {
        cart.removeProduct(product, quantity);
    }

    @Override
    public BigDecimal getSum(Cart cart) {
        return cart.getSum();
    }

    @Override
    public void printCart(Cart cart) {
        BigDecimal sum = BigDecimal.valueOf(0);
        for (Map.Entry<Product, Integer> entryMap : cart.getCartMap().entrySet()) {
            Product product = entryMap.getKey();
            BigDecimal prodSum = product.getPrice().multiply(BigDecimal.valueOf(entryMap.getValue()));
            System.out.printf("Product id = %-2s | name = %-15s | price = %-8s | quantity = %-3s | sum = %-12s \n",
                    product.getId(), product.getName(), product.getPrice(), entryMap.getValue(),prodSum);
            sum = sum.add(prodSum);
        }
        System.out.println("Общая стоимость продуктов в корзине: " + sum);
    }

    @Override
    public int getProductQuantity(Cart cart, Product product) {
        if(cart.getCartMap().containsKey(product)){
            return cart.getCartMap().get(product);
        }
        return 0;
    }

    @Override
    public int getProductQuantity(Cart cart, Long prodId) {
        Product product = productRepository.findById(prodId);
        return this.getProductQuantity(cart, product);
    }
}
