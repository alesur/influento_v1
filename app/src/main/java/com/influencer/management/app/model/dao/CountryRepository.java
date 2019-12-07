package com.influencer.management.app.model.dao;

import com.influencer.management.app.model.entity.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Integer> {

}
