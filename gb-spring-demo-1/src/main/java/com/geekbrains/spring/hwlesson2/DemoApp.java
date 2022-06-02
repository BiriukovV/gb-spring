package com.geekbrains.spring.hwlesson2;

import com.geekbrains.spring.hwlesson2.config.AppConfig;
import com.geekbrains.spring.hwlesson2.service.CartServiceImpl;
import com.geekbrains.spring.hwlesson2.service.ProductService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class DemoApp {

    private final ProductService productService;
    private CartServiceImpl cartService;

    public DemoApp(ProductService productService, CartServiceImpl cartService) {
        this.productService = productService;
        this.cartService = cartService;
    }

    public static void main(String[] args) {
        new AnnotationConfigApplicationContext(AppConfig.class);
    }

    public static void printSeparator(){
        System.out.println("-------------------");
    }

    private static void printList(List<?> list){
        System.out.println("Список продуктов");
        for (Object e1 : list) {
            System.out.println(e1.toString());
        }
    }


}
