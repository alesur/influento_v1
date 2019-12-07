package com.influencer.management.app.model.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;
import java.util.ArrayList;
import java.util.List;

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
    @JoinColumn(name = "personal_details_id", nullable = true)
    private PersonalDetails personalDetails;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "instagram_profile_id", nullable = true)
    private InstagramProfile instagramProfile;

    @OneToMany(mappedBy = "influencer")
//    @JoinColumn(name = "influencer_id", nullable = false)
    private List<DayContacted> daysContacted;

    public String lastDayContacted(){
        System.out.println("size of daysContacted: " + daysContacted.size());
        return daysContacted.get(daysContacted.size()-1).getDate();
    }

 public void addDate(DayContacted dayContacted){
        if(daysContacted==null){
            daysContacted = new ArrayList<>();
        }

        daysContacted.add(dayContacted);
 }
}
