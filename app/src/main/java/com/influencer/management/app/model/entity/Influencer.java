package com.influencer.management.app.model.entity;

import lombok.Data;

import javax.persistence.*;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * This class represents the Influencer, base entity of the app
 * Fields:
 *      id, profileName, notes, status, assignedProducts, personalDetails, InstagramProfile, daysContacted, reviews, productsSent
 */
@Entity
@Table(name = "influencer")
@Data
public class Influencer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String profileName;

    private String notes;

    private String status;

    @ManyToOne(fetch = FetchType.LAZY, optional = false,cascade = {CascadeType.DETACH,CascadeType.MERGE,CascadeType.PERSIST,CascadeType.REFRESH})
    @JoinColumn(name = "country_id", nullable = false)
    private Country country;

    @OneToMany(mappedBy = "influencer",cascade = {CascadeType.ALL})
    private List<AssignedProducts> assignedProducts;

    /**
     * Here is added the field for the Personal Details Object of the Influencer
     */
    @OneToOne(cascade = {CascadeType.ALL})
    private PersonalDetails personalDetails;


    /**
     * Here is added the field for the Instagram Profile Object of the Influencer
     */

    @OneToOne(cascade = {CascadeType.ALL})
    private InstagramProfile instagramProfile;

    /**
     * Here is added the List of the days when Influencer has been contacted
     */
    @OneToMany(mappedBy = "influencer",cascade = {CascadeType.ALL})
    private List<DayContacted> daysContacted;

    /**
     * Here is added the List of the reviews the Influencer has done
     */
    @OneToMany(mappedBy = "influencerf",cascade = {CascadeType.ALL})
    private List<Review> reviews;
}
