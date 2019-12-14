package com.influencer.management.app.service;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.time.Duration;

@Service
public class RestService {

    private final RestTemplate restTemplate;

    public RestService(RestTemplateBuilder restTemplateBuilder) {
        // set connection and read timeouts
        this.restTemplate = restTemplateBuilder
                .setConnectTimeout(Duration.ofSeconds(500))
                .setReadTimeout(Duration.ofSeconds(500))
                .build();
    }

    public String getPostsPlainJSON() {
        String url = "https://www.instagram.com/p/B5_B_-tHuzD/?__a=1";
        return this.restTemplate.getForObject(url, String.class);
    }

    public Owner[] getPostsAsObject() {
        String url = "https://www.instagram.com/p/B5_B_-tHuzD/?__a=1";
        return this.restTemplate.getForObject(url, Owner[].class);
    }

    public Owner getPostWithUrlParameters() {
        String url = "https://jsonplaceholder.typicode.com/posts/{id}";
        return this.restTemplate.getForObject(url, Owner.class, 1);
    }

    public Owner getPostWithResponseHandling() {
        String url = "https://www.instagram.com/p/B5_B_-tHuzD/?__a=1";
        ResponseEntity<Owner> response = this.restTemplate.getForEntity(url, Owner.class, 1);
        if (response.getStatusCode() == HttpStatus.OK) {
            return response.getBody();
        } else {
            return null;
        }
    }

}
