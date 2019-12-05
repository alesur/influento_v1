package com.influencer.management.app.model.data;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "products")
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Size(min = 3, message = "Product name must be at least 3 characters long")
    private String name;
}
