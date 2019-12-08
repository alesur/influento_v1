package com.influencer.management.app.model.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "instagramProfile")
@Data
public class InstagramProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String profileLink;

    private int followersNumbers;

    private int averageLikes;

    private int averageComments;

    @OneToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REFRESH,CascadeType.DETACH})
    @JoinColumn(name = "influencer_id")
    private Influencer influencer;

}
