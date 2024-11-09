package com.productservice.controllers;

import com.productservice.dtos.GenericProductDto;
import com.productservice.dtos.SearchRequestDto;
import com.productservice.services.SearchService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/search")
public class SearchController {

    private SearchService searchService;

    public SearchController(SearchService searchService) {
        this.searchService = searchService;
    }

//    @PostMapping
//    public List<GenericProductDto> searchProducts(@RequestBody SearchRequestDto searchRequestDto){
//        return searchService.searchProducts(searchRequestDto.getQuery(), searchRequestDto.getPageNumber(), searchRequestDto.getItemsPerPage());
//    }

    @PostMapping
    public Page<GenericProductDto> searchProductsPage(@RequestBody SearchRequestDto searchRequestDto){
        List<GenericProductDto> genericProductDtos = searchService.searchProducts(searchRequestDto.getQuery(), searchRequestDto.getPageNumber(), searchRequestDto.getItemsPerPage(), searchRequestDto.getSortParam());
        Page<GenericProductDto> genericProductDtoPage = new PageImpl<>(genericProductDtos);
        return genericProductDtoPage;
    }
}
