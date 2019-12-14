package com.influencer.management.app.model.entity;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.Size;

/**
 * This object represents the countries
 * Fields:
 *      id, name
 */
@Entity
@Table(name = "country")
@Data
public class Country {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Size(min = 3, message = "Country name must be at least 3 characters long")
    private String name;


}
