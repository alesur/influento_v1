package com.influencer.management.app.model.dao;

import com.influencer.management.app.model.entity.AssignedProducts;
import org.springframework.data.jpa.repository.JpaRepository;
public interface AssignedProductsRepository extends JpaRepository<AssignedProducts, Integer> {
}
