package com.productservice.thirdPartyClients.fakeStoreClient;

import com.productservice.dtos.FakeStoreProductDto;
import com.productservice.exceptions.ProductNotFoundException;
import com.productservice.dtos.GenericProductDto;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

import java.util.List;
@Component
public class FakeStoreClient {
    private RestTemplateBuilder restTemplateBuilder;
    private String specificProductUrl = "https://fakestoreapi.com/products/{id}";
    private String genericProductsUrl = "https://fakestoreapi.com/products";

    FakeStoreClient(RestTemplateBuilder restTemplateBuilder){
        this.restTemplateBuilder = restTemplateBuilder;
    }


    public FakeStoreProductDto getProductById(Long id) throws ProductNotFoundException {

        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> responseEntity =
                restTemplate.getForEntity(specificProductUrl, FakeStoreProductDto.class, id);
        FakeStoreProductDto fakeStoreProductDto = responseEntity.getBody();

        if(fakeStoreProductDto == null){
            throw new ProductNotFoundException("Product with id : "+ id+" doesn't exit.");
        }
        return responseEntity.getBody();
    }


    public List<FakeStoreProductDto> getAllProducts() {
        RestTemplate restTemplate = restTemplateBuilder.build();

        ResponseEntity<FakeStoreProductDto[]> responseEntity =
                restTemplate.getForEntity(genericProductsUrl, FakeStoreProductDto[].class);
        return   List.of(responseEntity.getBody());
    }


    public FakeStoreProductDto deleteProductById(Long id) {
        RestTemplate restTemplate = restTemplateBuilder.build();

        RequestCallback requestCallback = restTemplate.acceptHeaderRequestCallback(FakeStoreProductDto.class);
        ResponseExtractor<ResponseEntity<FakeStoreProductDto>> responseExtractor =
                restTemplate.responseEntityExtractor(FakeStoreProductDto.class);
        ResponseEntity<FakeStoreProductDto> responseEntity =
                restTemplate.execute(specificProductUrl, HttpMethod.DELETE, requestCallback, responseExtractor, id);

        return responseEntity.getBody();
    }

    public FakeStoreProductDto createProduct(GenericProductDto genericProductDto) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> responseEntity =
                restTemplate.postForEntity(genericProductsUrl, genericProductDto, FakeStoreProductDto.class);
        return responseEntity.getBody();
    }


    public void updateProductById() {

    }
}
