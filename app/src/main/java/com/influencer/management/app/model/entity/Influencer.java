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
 *      id, profileName, notes, status, assignedProducts, personalDetails, InstagramProfiel, daysContacted, reviews,productsSent
 * Methods:
 *      lastDayContacted(): returns a String, with the value
 *      addDate(): checks if List<DayContacted> exists and then adds new DayContacted
 *      addReview(): checks if List<Review> exists and then adds new Review
 *      influCheckEmpty(): for form-validation purposes, checks if profileName is a String of blank spaces
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


    //@OneToMany(mappedBy = "influencer", orphanRemoval = true)
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
    //@OneToMany(mappedBy = "influencer", orphanRemoval = true)
    @OneToMany(mappedBy = "influencer",cascade = {CascadeType.ALL})
    private List<DayContacted> daysContacted;

    /**
     * Here is added the List of the reviews the Influencer has done
     */
    //@OneToMany(mappedBy = "influencerf", orphanRemoval = true)
    @OneToMany(mappedBy = "influencerf",cascade = {CascadeType.ALL})
    private List<Review> reviews;

    /**
     * Here is added the List of the products sent to the Influencer
     */
    @ManyToMany
    @JoinTable(name = "products_influencer",
            joinColumns = @JoinColumn(name = "influencer_id"),
            inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<Product> productsSent;

    public String lastDayContacted() {
        /**
         * Trying to develop new logic for LastDayContacted
         */
        Date max = new Date(Long.MIN_VALUE);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String strDate = null;
        String resultDate = null;

        if (daysContacted.size()<1) {
            max = new Date();
            strDate = dateFormat.format(max);
            resultDate = strDate.substring(0, 16);
            return "add first contact";
        }

        for (DayContacted d : daysContacted) {
            if (d.getCreatedAt().compareTo(max) > 0) {
                max = d.getCreatedAt();
            }
        }
        strDate = dateFormat.format(max);
        resultDate = strDate.substring(0, 16);
        return resultDate;
    }

    /**
     * HERE are 3 "convenience" methods, to be able to add dayContacted, productSent, and Review  to the three lists
     */

    public void addDate(DayContacted dayContacted) {
        if (daysContacted == null) {
            daysContacted = new ArrayList<>();
        }

        daysContacted.add(dayContacted);
    }

    public void addReview(Review review) {
        if (reviews == null) {
            reviews = new ArrayList<>();
        }
        reviews.add(review);
    }

    public void addProduct(Product productSent) {
        if (productsSent == null) {
            productsSent = new ArrayList<>();
        }
        productsSent.add(productSent);
    }

    public boolean influCheckEmpty() {
        if (this.getProfileName().trim().isEmpty()) {
            return true;
        } else return false;
    }
}
