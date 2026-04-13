package com.example.springpracticetamerlan.controller;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
public class ProductController {
    List<Product> products = List.of(
            new Product("Яблоко", 450, ProductType.FRUIT),
            new Product("Банан", 700, ProductType.FRUIT),
            new Product("Морковь", 300, ProductType.VEGETABLE),
            new Product("Помидор", 600, ProductType.VEGETABLE),
            new Product("Апельсин", 800, ProductType.FRUIT),
            new Product("Огурец", 400, ProductType.VEGETABLE),
            new Product("Виноград", 1200, ProductType.FRUIT),
            new Product("Картофель", 200, ProductType.VEGETABLE),
            new Product("Говядина", 4500, ProductType.MEAT),
            new Product("Курица", 2000, ProductType.MEAT),
            new Product("Молоко", 500, ProductType.DAIRY),
            new Product("Сыр", 1500, ProductType.DAIRY),
            new Product("Йогурт", 800, ProductType.DAIRY)
    );

    // ?minPrice=500 - получить товары со стоимостью от 500
    // ?maxPrice=1500 - получить товары со стоимостью до 1500
    // ?minPrice&maxPrice=1500 - получить товары со стоимостью от 500 до 1500

    @GetMapping("/products")
    public List<Product> getProducts(@RequestParam(required = false) Integer minPrice,
                                     @RequestParam(required = false) Integer maxPrice,
                                     @RequestParam(required = false) List<ProductType> type
    ) {
        log.info("type=" + type);
        return products.stream()
                .filter(product -> minPrice == null || product.getPrice() >= minPrice)
                .filter(product -> maxPrice == null || product.getPrice() <= maxPrice)
                .filter(product -> type == null || type.contains(product.getType()))
                .toList();

//        List<Product> result = new ArrayList<>();
//        for (Product product : products) {
//            if (
//                    (minPrice == null || product.getPrice() >= minPrice)
//                            && (maxPrice == null || product.getPrice() <= maxPrice)
//                            && (type == null || product.getType().equals(type))
//            ) {
//                result.add(product);
//            }
//
//        }
//        return result;

    }


    @Data // @RequiredArgsConstructor + @Getter + @Setter + @ToString + @EqualsAndHashcode
    public static class Product {
        private final String name;
        private final int price;
        private final ProductType type;
    }

    public enum ProductType {FRUIT, VEGETABLE, MEAT, DAIRY}
}

