package com.influencer.management.app.model.dao;

import com.influencer.management.app.model.entity.InstagramProfile;
import com.influencer.management.app.model.entity.PersonalDetails;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonalDetailsReposiroty extends JpaRepository <PersonalDetails, Integer> {
}
