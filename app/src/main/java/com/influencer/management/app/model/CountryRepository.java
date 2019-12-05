package com.influencer.management.app.model;

import com.influencer.management.app.model.data.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Integer> {

}
