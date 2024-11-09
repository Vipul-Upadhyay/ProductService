package com.productservice.controllers;

import com.productservice.dtos.GenericProductDto;
import com.productservice.exceptions.ProductNotFoundException;
import com.productservice.services.ProductService;
import org.springframework.http.HttpHeaders;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    ProductController(ProductService productService){
        this.productService = productService;
    }

    @GetMapping("{id}")
    public GenericProductDto getProductById(@RequestHeader(HttpHeaders.AUTHORIZATION) String authToken,@PathVariable("id") Long id) throws ProductNotFoundException {
        return productService.getProductById(authToken, id);
    }

    @GetMapping
    public List<GenericProductDto> getAllProducts(){
        return productService.getAllProducts();
    }

    @DeleteMapping("/{id}")
    public GenericProductDto deleteProductById(@PathVariable("id") Long id ){
        return productService.deleteProductById(id);
    }

    @PostMapping
    public GenericProductDto createProduct(@RequestBody GenericProductDto genericProductDto){
        return productService.createProduct(genericProductDto);
    }
    @PatchMapping("/{id}")
    public void updateProductById(@PathVariable("id") Long id){

    }

}
