package com.influencer.management.app.service;


import lombok.Data;

import java.io.Serializable;

@Data
public class Owner implements Serializable {

    private String username;
    private String profile_pic_url;
    private String full_name;

    private String logging_page_id;

    public Owner() {}

    public Owner(String username, String profile_pic_url, String full_name) {
        this.username = username;
        this.profile_pic_url = profile_pic_url;
        this.full_name = full_name;
    }

    @Override
    public String toString() {
        return "Owner{" +
                "username='" + username + '\'' +
                ", profile_pic_url='" + profile_pic_url + '\'' +
                ", full_name='" + full_name + '\'' +
                '}';
    }
}
