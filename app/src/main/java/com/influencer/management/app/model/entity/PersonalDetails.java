package com.influencer.management.app.model.entity;

import lombok.Data;

import javax.persistence.*;

/**
 * This object represents the personal information of the Influencer
 * Fields:
 *      id, firstName, lastName, phone, email, address
 */
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

    @OneToOne(mappedBy = "personalDetails",cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    private Influencer influencer;

}
