package com.productservice.services;

import com.productservice.exceptions.ProductNotFoundException;
import com.productservice.dtos.GenericProductDto;
import com.productservice.repositories.ProductRepository;

import java.util.List;

public class SelfProductServiceImpl  implements ProductService{

    private ProductRepository productRepository;

    SelfProductServiceImpl(ProductRepository productRepository){
        this.productRepository = productRepository;
    }
    @Override
    public GenericProductDto getProductById(String authToken, Long id) throws ProductNotFoundException {
        GenericProductDto genericProductDto = new GenericProductDto();
        return null;
    }

    @Override
    public List<GenericProductDto> getAllProducts() {
        return null;
    }

    @Override
    public GenericProductDto deleteProductById(Long id) {
        return null;
    }

    @Override
    public GenericProductDto createProduct(GenericProductDto genericProductDto) {
        return null;
    }

    @Override
    public void updateProductById() {

    }
}
