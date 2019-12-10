package com.influencer.management.app.model.entity;

import lombok.Data;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


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

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "country_id", nullable = false)
    private Country country;



    /**
     * Here is added the field for the Personal Details Object of the Influencer
     *
     */
    @OneToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REFRESH,CascadeType.DETACH})
    @JoinColumn(name = "personal_details_id", unique = true)
    private PersonalDetails personalDetails;


    /**
     * Here is added the field for the Instagram Profile Object of the Influencer
     *
     */

    @OneToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REFRESH,CascadeType.DETACH})
    @JoinColumn(name = "instagram_profile_id")
    private InstagramProfile instagramProfile;

    /**
     * Here is added the List of the days when Influencer has been contacted
     *
     */
    @OneToMany(mappedBy = "influencer")
    private List<DayContacted> daysContacted;

/**
 * Here is added the List of the reviews the Influencer has done
 *
 */
        @OneToMany(mappedBy = "influencer")
        private List<Review> reviews;

    /**
     * Here is added the List of the products sent to the Influencer
     *
     */
    @ManyToMany
    @JoinTable(name = "products_influencer",
    joinColumns = @JoinColumn(name = "influencer_id"),
    inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<Product> productsSent;

    public String lastDayContacted(){
        /**
         * Trying to develop new logic for LastDayContacted
         */
        Date max= new Date(Long.MIN_VALUE);
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String strDate = null;
        String resultDate = null;

        if(daysContacted==null){
            max = new Date();
            strDate = dateFormat.format(max);
            resultDate = strDate.substring(0,16);
            return resultDate;
        }

        for(DayContacted d:daysContacted){
            if(d.getCreatedAt()==null){
                max = new Date();
                 strDate = dateFormat.format(max);
                 resultDate = strDate.substring(0,16);
                return resultDate;
            }
            if(d.getCreatedAt().compareTo(max)>0){
                max = d.getCreatedAt();
            }
        }
        strDate = dateFormat.format(max);
        resultDate = strDate.substring(0,16);
        return resultDate;
    }

    /**
     *
     * HERE are 3 "convenience" methods, to be able to add dayContacted, productSent, and Review  to the three lists
     */

 public void addDate(DayContacted dayContacted){
        if(daysContacted==null){
            daysContacted = new ArrayList<>();
        }

        daysContacted.add(dayContacted);
 }

    public void addProduct(Product productSent){
        if(productsSent==null){
            productsSent = new ArrayList<>();
        }
        productsSent.add(productSent);
    }

    public void addReview(Review review){
        if(reviews==null){
            reviews = new ArrayList<>();
        }
        reviews.add(review);
    }



}
