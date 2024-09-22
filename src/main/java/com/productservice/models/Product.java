package com.productservice.models;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@AllArgsConstructor
@NoArgsConstructor
public class Product  extends BaseModel{

    private String title;
    private String description;
    private String image;

    @ManyToOne
    private Category category;

    @OneToOne(cascade = {CascadeType.REMOVE, CascadeType.PERSIST})
    private Price price;
}
