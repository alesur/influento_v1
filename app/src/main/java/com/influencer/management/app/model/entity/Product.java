package com.influencer.management.app.model.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.List;

@Entity
@Table(name = "products")
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Size(min = 3, message = "Product name must be at least 3 characters long")
    private String name;

    @ManyToMany
    @JoinTable(name = "products_influencer",
    joinColumns = @JoinColumn(name = "product_id"),
    inverseJoinColumns = @JoinColumn(name = "influencer_id"))
    private List<Influencer> influencers;
}
