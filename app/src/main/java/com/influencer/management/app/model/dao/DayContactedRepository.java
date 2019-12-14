package com.influencer.management.app.model.dao;

import com.influencer.management.app.model.entity.DayContacted;
import com.influencer.management.app.model.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DayContactedRepository extends JpaRepository<DayContacted, Integer> {

}
