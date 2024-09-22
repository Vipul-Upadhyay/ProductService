package com.productservice.services;

import com.productservice.dtos.FakeStoreProductDto;
import com.productservice.dtos.GenericProductDto;
import com.productservice.exceptions.ProductNotFoundException;
import com.productservice.security.JWTObject;
import com.productservice.security.TokenValidator;
import com.productservice.thirdPartyClients.fakeStoreClient.FakeStoreClient;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service("fakeStoreProductService")
public class FakeStoreProductService implements ProductService {

    private FakeStoreClient fakeStoreAdapter;
    private TokenValidator tokenValidator;

    FakeStoreProductService(FakeStoreClient fakeStoreAdapter, TokenValidator tokenValidator){
        this.fakeStoreAdapter = fakeStoreAdapter;
        this.tokenValidator = tokenValidator;
    }

    private static GenericProductDto convertToGenericProductDto(FakeStoreProductDto fakeStoreProductDto){
        GenericProductDto genericProductDto = new GenericProductDto();
        genericProductDto.setId(fakeStoreProductDto.getId());
        genericProductDto.setImage(fakeStoreProductDto.getImage());
        genericProductDto.setCategory(fakeStoreProductDto.getCategory());
        genericProductDto.setDescription(fakeStoreProductDto.getDescription());
        genericProductDto.setPrice(fakeStoreProductDto.getPrice());
        genericProductDto.setTitle(fakeStoreProductDto.getTitle());
        return genericProductDto;
    }
    @Override
    public GenericProductDto getProductById(String authToken, Long id) throws ProductNotFoundException {

        Optional<JWTObject> jwtObjectOptional = tokenValidator.validateToken(authToken);

        if(jwtObjectOptional.isEmpty()){
            //Invalid token
            //reject the request;
            return null;
        }

        JWTObject jwtObject = jwtObjectOptional.get();
        Long userId = jwtObject.getUserId();


        return convertToGenericProductDto(fakeStoreAdapter.getProductById(id));
    }

    @Override
    public List<GenericProductDto> getAllProducts() {
        List<FakeStoreProductDto> fakeStoreProductDtos = fakeStoreAdapter.getAllProducts();
        List<GenericProductDto> genericProductDtos = new ArrayList<>();

        for(FakeStoreProductDto fakeStoreProductDto : fakeStoreProductDtos){
            genericProductDtos.add(convertToGenericProductDto(fakeStoreProductDto));
        }

        return genericProductDtos;
    }

    @Override
    public GenericProductDto deleteProductById(Long id) {
        return convertToGenericProductDto(fakeStoreAdapter.deleteProductById(id));
    }
    @Override
    public GenericProductDto createProduct(GenericProductDto genericProductDto) {
        return convertToGenericProductDto(fakeStoreAdapter.createProduct(genericProductDto));
    }

    @Override
    public void updateProductById() {

    }
}
