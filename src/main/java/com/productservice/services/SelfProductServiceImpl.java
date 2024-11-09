package com.productservice.services;

import com.productservice.dtos.GenericProductDto;
import com.productservice.dtos.UserDto;
import com.productservice.exceptions.ProductNotFoundException;
import com.productservice.repositories.ProductRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class SelfProductServiceImpl  implements ProductService{

    private ProductRepository productRepository;
    private RestTemplate restTemplate;

    SelfProductServiceImpl(ProductRepository productRepository, RestTemplate restTemplate){
        this.productRepository = productRepository;
        this.restTemplate = restTemplate;
    }
    @Override
    public GenericProductDto getProductById(String authToken, Long id) throws ProductNotFoundException {
        GenericProductDto genericProductDto = new GenericProductDto();
        ResponseEntity<UserDto> userDtoResponseEntity = restTemplate.getForEntity("http://userservice/users/1", UserDto.class);
        return genericProductDto;
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
