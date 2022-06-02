package com.geekbrains.spring.hwlesson2.persistence;

import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ConcurrentHashMap;

@Component
public class ProductRepository {

    private final Map<Long, Product> productMap = new ConcurrentHashMap<>();

    {
        for (long i = 0; i <6 ; i++) {
            BigDecimal randomPrice = BigDecimal.valueOf(new Random().nextInt(100000)).divide(BigDecimal.valueOf(100));
            productMap.put(i, new Product(i, "Product" + i, randomPrice));
        }

        // ручное заполнение
        productMap.put(1L, new Product(1L, "Product 1", BigDecimal.valueOf(80.10)));
        productMap.put(1L, new Product(2L, "Product 2", BigDecimal.valueOf(35.05)));
        productMap.put(1L, new Product(3L, "Product 3", BigDecimal.valueOf(110.20)));
        productMap.put(1L, new Product(4L, "Product 4", BigDecimal.valueOf(400.10)));
        productMap.put(1L, new Product(5L, "Product 5", BigDecimal.valueOf(250.70)));
    }

    // получить список всех  продуктов
    public List<Product> findAll(){
        return new ArrayList<>(productMap.values());
    }

    //сохранить продукт
    // если в меитрл передан новый прродукт без заданного dб то будет заменен на новый
    //если продукт с заданным id уже есть в мапе, то он будет заменен на новый
    public void saveOrUpdate(Product product){
        if(product.getId() == null){
            Long id = (long) (productMap.size() +1);
            product.setId(id);
        }
        productMap.put(product.getId(), product);
    }

    //найти продукт по id
    public Product findById(Long id){
        return productMap.get(id);
    }

    //удалить продукт по id
    public void removeById(Long id){
        productMap.remove(id);
    }

}
