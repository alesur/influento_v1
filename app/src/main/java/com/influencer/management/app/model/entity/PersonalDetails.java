package com.influencer.management.app.model.entity;

import lombok.Data;

import javax.persistence.*;

@Entity
@Table(name = "personalDetails")
@Data
public class PersonalDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String firstName;

    private String lastName;

    private String phone;

    private String email;

    private String address;

    @OneToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REFRESH,CascadeType.DETACH})
    @JoinColumn(name = "influencer_id")
    private Influencer influencer;




}
