package com.influencer.management.app;


import com.influencer.management.app.model.dao.InfluencerRepository;
import com.influencer.management.app.model.entity.Influencer;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import javax.persistence.EntityManager;
import javax.swing.text.html.parser.Entity;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.in;


//not working
@RunWith(SpringRunner.class)
@DataJpaTest
@AutoConfigureTestDatabase(replace = AutoConfigureTestDatabase.Replace.NONE)
class InfluencerRepositoryFindByProfileNameIntegrationTest {

    /**
     * not replacing Datasource with embebbed datasource issue:
     * https://stackoverflow.com/questions/41315386/spring-boot-1-4-datajpatest-error-creating-bean-with-name-datasource/41316559
     */
    @Autowired
    private InfluencerRepository influencerRepository;

    @Autowired
    TestEntityManager testEntityManager;

    @Test
    public void whenFindByProfileName_thenReturnInfluencer(){
        Influencer influencer = new Influencer();
        influencer.setProfileName("testProfileName");
        testEntityManager.persist(influencer);
        testEntityManager.flush();

        Influencer found = influencerRepository.findByProfileName(influencer.getProfileName());
        assertThat(found.getProfileName())
                .isEqualTo(influencer.getProfileName());
    }
}

