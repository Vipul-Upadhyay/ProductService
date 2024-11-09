package com.productservice.repositories;

import com.productservice.models.Product;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {
    @Override
    List<Product> findAll();

    List<Product> findAllByTitle(String title);
    List<Product> findAllByTitleContainingIgnoreCase(String title, Pageable pageable);

    List<Product> findAllByTitleAndDescription(String title, String description);

    @Override
    <S extends Product> List<S> findAll(Example<S> example);

    List<Product> findAllByPrice_ValueLessThan(Integer x);
    List<Product> findAllByPrice_ValueBetween(Integer x, Integer y);
}
