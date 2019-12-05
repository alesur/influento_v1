package com.influencer.management.app.model;

import com.influencer.management.app.model.data.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {

}
