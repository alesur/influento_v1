package com.influencer.management.app.model.dao;

import com.influencer.management.app.model.entity.Influencer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InfluencerRepository extends JpaRepository<Influencer, Integer> {

}
