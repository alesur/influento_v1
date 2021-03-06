package com.influencer.management.app.model.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;

/**
 * This object represents the reviews created by the Influencer, stores its link to the actual Instagram review
 * Fields:
 *      id, link, influencerf
 */
@Entity
@Table(name = "reviews")
@Data
public class Review {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Size(min = 3, message = "link must be at least 3 characters long")
    private String link;

    @ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE,CascadeType.REFRESH,CascadeType.DETACH})
    @JoinColumn(name = "influencer_id")
    private Influencer influencerf;

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

}
