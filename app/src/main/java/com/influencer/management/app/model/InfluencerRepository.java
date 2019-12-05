package com.influencer.management.app.model;

import com.influencer.management.app.model.data.Influencer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InfluencerRepository extends JpaRepository<Influencer, Integer> {

}
