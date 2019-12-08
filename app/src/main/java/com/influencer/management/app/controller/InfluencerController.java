package com.influencer.management.app.controller;

import com.influencer.management.app.model.dao.InfluencerRepository;
import com.influencer.management.app.model.entity.Influencer;
import com.influencer.management.app.model.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
public class InfluencerController {

    @Autowired
    private InfluencerRepository influencerRepository;

    @GetMapping("/")
    public String influencerList(Model model) {
        model.addAttribute("influencer", influencerRepository.findAll());

        return "index.html";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model model) {

        Influencer influencer = influencerRepository.getOne(id);

        model.addAttribute("influencer", influencer);

        return "influencer-edit.html";
    }


}
