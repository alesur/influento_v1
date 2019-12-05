package com.influencer.management.app.model.data;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;

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




}
