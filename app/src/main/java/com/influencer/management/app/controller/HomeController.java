package com.influencer.management.app.controller;

import com.influencer.management.app.model.InfluencerRepository;
import com.influencer.management.app.model.data.Country;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
//testing Juan
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
