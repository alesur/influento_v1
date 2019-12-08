package com.influencer.management.app.model.dao;

import com.influencer.management.app.model.entity.Country;
import com.influencer.management.app.model.entity.InstagramProfile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstagramProfileRepository extends JpaRepository<InstagramProfile, Integer> {

}
