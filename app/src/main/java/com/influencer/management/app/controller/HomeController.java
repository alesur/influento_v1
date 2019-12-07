package com.influencer.management.app.controller;

import com.influencer.management.app.model.dao.InfluencerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {

    @Autowired
    private InfluencerRepository influencerRepository;

    @GetMapping("/")
    public String influencerList(Model model) {
        model.addAttribute("influencer", influencerRepository.findAll());

        return "index.html";
    }

}