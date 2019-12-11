package com.influencer.management.app.model.entity;

import lombok.Data;

import javax.persistence.*;

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


//    public boolean detailsIsEmpty(){
//        if(this.getFirstName().trim().isEmpty() || this.getLastName().trim().isEmpty() ||
//                this.getPhone().trim().isEmpty() || this.getEmail().trim().isEmpty() || this.getAddress().trim().isEmpty()){
//            return true;
//        }else return false;
//    }

}
