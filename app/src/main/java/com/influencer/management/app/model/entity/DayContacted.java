package com.influencer.management.app.model.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@Table(name = "dayscontacted")
@Data
public class DayContacted {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Size(min = 3, message = "Date must be at least 3 characters long")
    private String date;

    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REFRESH,CascadeType.DETACH})
    @JoinColumn(name = "influencer_id")
    private Influencer influencer;

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

}
