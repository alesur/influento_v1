package com.influencer.management.app.model.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * This object represents the Instagram profile of the influencer, storing its main properties
 * Fields:
 *      id, profilelink, followerNumbers, averageLikes, averageComments
 */
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

    @OneToOne(mappedBy = "instagramProfile",cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    private Influencer influencer;


//    public boolean profileIsEmpty(){
//        if(this.profileLink.trim().isEmpty()){
//            return true;
//        }else return false;
//    }
}
