package com.geekbrains.spring.demo5;

import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Component
public interface IItemRepository {
    Item findById(Long id);
    List<Item> findAll();
    void save(Item item);
}
