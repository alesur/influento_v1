package com.influencer.management.app.model.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "influencer")
@Data
public class Influencer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Size(min = 2, message = "Name must be at least 2 characters long")
    private String profileName;

    private String notes;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "country_id", nullable = false)
    private Country country;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "personal_details_id", nullable = false)
    private PersonalDetails personalDetails;


}
