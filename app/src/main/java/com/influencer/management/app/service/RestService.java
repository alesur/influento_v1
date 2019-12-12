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
        String url = "https://www.instagram.com/p/B1basSko4v5/?__a=1";
        return this.restTemplate.getForObject(url, String.class);
    }

    public Post[] getPostsAsObject() {
        String url = "https://jsonplaceholder.typicode.com/posts";
        return this.restTemplate.getForObject(url, Post[].class);
    }

    public Post getPostWithUrlParameters() {
        String url = "https://jsonplaceholder.typicode.com/posts/{id}";
        return this.restTemplate.getForObject(url, Post.class, 1);
    }

    public Post getPostWithResponseHandling() {
        String url = "https://jsonplaceholder.typicode.com/posts/{id}";
        ResponseEntity<Post> response = this.restTemplate.getForEntity(url, Post.class, 1);
        if (response.getStatusCode() == HttpStatus.OK) {
            return response.getBody();
        } else {
            return null;
        }
    }


}
