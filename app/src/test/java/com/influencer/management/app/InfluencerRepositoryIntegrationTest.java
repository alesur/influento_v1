package com.influencer.management.app;


import com.influencer.management.app.model.dao.InfluencerRepository;
import com.influencer.management.app.model.entity.Influencer;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class InfluencerRepositoryIntegrationTest{

    /**
     * Testing InfluencerRepository
     * not replacing Datasource with embebbed datasource issue:
     * https://stackoverflow.com/questions/41315386/spring-boot-1-4-datajpatest-error-creating-bean-with-name-datasource/41316559
     */
    @Autowired
    private InfluencerRepository influencerRepository;

    @Test
    public void whenFindAll_thenReturnPopulatedList(){
        List<Influencer> influencers = influencerRepository.findAll();
        assertThat(influencers.size())
                .isGreaterThan(0);
    }
}

