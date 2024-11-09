package com.productservice.services;

import com.productservice.dtos.GenericProductDto;
import com.productservice.models.Product;
import com.productservice.models.SortParam;
import com.productservice.repositories.ProductRepository;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SearchService {
    private ProductRepository productRepository;
    public SearchService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<GenericProductDto> searchProducts(String query, int pageNumber, int pageSize, List<SortParam> sortParams){

        Sort sort = null;

        if(sortParams.get(0).getSortType().equals("ASC")){
            sort = Sort.by(sortParams.get(0).getSortParamName()).ascending();
        }else{
            sort = Sort.by(sortParams.get(0).getSortParamName()).descending();
        }

        for(int i=1; i<sortParams.size(); i++){
            if(sortParams.get(i).getSortType().equals("ASC")){
                sort.and(Sort.by(sortParams.get(i).getSortParamName()).ascending());
            }else{
                sort.and(Sort.by(sortParams.get(i).getSortParamName()).descending());
            }
        }

        PageRequest pageRequest = PageRequest.of(pageNumber, pageSize, sort);
        List<Product> products = productRepository.findAllByTitleContainingIgnoreCase(query, pageRequest );
        List<GenericProductDto> genericProductDtos = new ArrayList<>();
        for (Product product : products) {
            genericProductDtos.add(GenericProductDto.from(product));
        }
        return genericProductDtos;
    }
}
