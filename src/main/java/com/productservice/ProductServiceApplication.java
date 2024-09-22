package com.productservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductServiceApplication {

//    private final CategoryRepository categoryRepository;
//    private final ProductRepository productRepository;

//    public ProductServiceApplication(CategoryRepository categoryRepository,
//                                     ProductRepository productRepository) {
//        this.categoryRepository = categoryRepository;
//        this.productRepository = productRepository;
//    }

    public static void main(String[] args) {
        SpringApplication.run(ProductServiceApplication.class, args);

    }

 //   @Override
  // public void run(String... args) throws Exception {

//        Category category = new Category();
//        category.setName("Apple Devices");
//        Category savedCategory = categoryRepository.save(category);
//
//        Price price = new Price();
//        price.setValue(100000);
//        price.setCurrency("INR");
//
//        Product product = new Product();
//        product.setPrice(price);
//        product.setTitle("iPhone 15 pro");
//        product.setDescription("Best iPhone ever");
//        product.setImage("img");
//        product.setCategory(savedCategory);
//        Product savedProduct = productRepository.save(product);
   // }
}
