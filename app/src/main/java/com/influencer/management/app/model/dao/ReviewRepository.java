package com.influencer.management.app.model.dao;

import com.influencer.management.app.model.entity.Country;
import com.influencer.management.app.model.entity.Review;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReviewRepository extends JpaRepository<Review, Integer> {

}
