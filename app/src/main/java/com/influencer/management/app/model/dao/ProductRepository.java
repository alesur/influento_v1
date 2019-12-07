package com.influencer.management.app.model.dao;

import com.influencer.management.app.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Integer> {

//    Product findByName(String name);
//
//    List<Product> findAllByOrderBySortingAsc();


}
