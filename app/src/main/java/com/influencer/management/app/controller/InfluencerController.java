package com.influencer.management.app.controller;

import com.influencer.management.app.model.dao.InfluencerRepository;
import com.influencer.management.app.model.entity.Influencer;
import com.influencer.management.app.model.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.criteria.CriteriaBuilder;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/")
public class InfluencerController {

    @Autowired
    private InfluencerRepository influencerRepository;

    @GetMapping()
    public String influencerList(Model model) {
        List<Influencer> influencers = influencerRepository.findAll();
        model.addAttribute("influencer", influencers);
        return "index.html";
    }

    @GetMapping("/view/{id}")
    public String view(@PathVariable int id, Model model) {
        Influencer influencer = influencerRepository.getOne(id);
        model.addAttribute("influencer", influencer);

        return "influencer-view.html";
    }

    @GetMapping("/edit/{id}")
    public String editget(@PathVariable int id, Model model) {

        Influencer influencer = influencerRepository.getOne(id);

        model.addAttribute("influencer", influencer);

        return "influencer-edit.html";
    }

    @PostMapping("/edit")
    public String editpost(@Valid Influencer influencer) {

        influencerRepository.save(influencer);

        return "redirect:/";
    }
    @GetMapping("/add")
    public String showFormForAdd(Model model) {

        Influencer influencer = new Influencer();

        model.addAttribute("influencer", influencer);

        return "influencer-edit.html";
    }





}
