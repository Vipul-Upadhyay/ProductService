package com.productservice.services;

import com.productservice.exceptions.ProductNotFoundException;
import com.productservice.dtos.GenericProductDto;

import java.util.List;

public interface ProductService {
    GenericProductDto getProductById(String authToken, Long id) throws ProductNotFoundException;
    List<GenericProductDto> getAllProducts();
    GenericProductDto deleteProductById(Long id);
    GenericProductDto createProduct(GenericProductDto genericProductDto);
    void updateProductById();
}
