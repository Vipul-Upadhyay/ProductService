package com.productservice.security;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Optional;

@Component
public class TokenValidator {

    private RestTemplateBuilder restTemplateBuilder;

    TokenValidator(RestTemplateBuilder restTemplateBuilder){
        this.restTemplateBuilder = restTemplateBuilder;
    }
    public Optional<JWTObject> validateToken(String token){
        RestTemplate restTemplate= restTemplateBuilder.build();
        //Make an HTTP call to UserService to call the validateToken method.
        return Optional.empty();
    }
}
