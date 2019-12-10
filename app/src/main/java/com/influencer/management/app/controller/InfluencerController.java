package com.influencer.management.app.controller;

import com.influencer.management.app.model.dao.CountryRepository;
import com.influencer.management.app.model.dao.InfluencerRepository;
import com.influencer.management.app.model.dao.InstagramProfileRepository;
import com.influencer.management.app.model.dao.PersonalDetailsReposiroty;
import com.influencer.management.app.model.entity.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/influencer")
public class InfluencerController {

    @Autowired
    private InfluencerRepository influencerRepository;

    @Autowired
    private CountryRepository countryRepository;

    @Autowired
    private PersonalDetailsReposiroty personalDetailsReposiroty;

    @Autowired
    private InstagramProfileRepository instagramProfileReposiroty;

    @GetMapping()
    public String influencerList(Model model) {
        List<Influencer> influencers = influencerRepository.findAll();
        model.addAttribute("influencer", influencers);
        return "index.html";
    }

    @GetMapping("/view/{id}")
    public String view(@PathVariable int id, Model model) {

        Influencer influencer = influencerRepository.getOne(id);
        Country country = countryRepository.getOne(id);
        PersonalDetails personalDetails = personalDetailsReposiroty.getOne(id);
        InstagramProfile instagramProfile = instagramProfileReposiroty.getOne(id);



        model.addAttribute("influencer", influencer);
        model.addAttribute("country", country);
        model.addAttribute("personalDetails", personalDetails);
        model.addAttribute("instagramProfile", instagramProfile);

        return "influencer-view.html";
    }

    @GetMapping("/edit/{id}")
    public String editget(@PathVariable int id, Model model) {

        List<Country> countryList = countryRepository.findAll();
        Influencer influencer = influencerRepository.getOne(id);
        PersonalDetails personalDetails = personalDetailsReposiroty.getOne(id);
        InstagramProfile instagramProfile = instagramProfileReposiroty.getOne(id);

        model.addAttribute("influencer", influencer);
        model.addAttribute("country", countryList);
        model.addAttribute("personalDetails", personalDetails);
        model.addAttribute("instagramProfile", instagramProfile);

        return "influencer-edit.html";
    }

    @PostMapping("/edit")
    public String editpost(@Valid Influencer influencer, PersonalDetails personalDetails, InstagramProfile instagramProfile) {

        influencerRepository.save(influencer);
        personalDetailsReposiroty.save(personalDetails);
        instagramProfileReposiroty.save(instagramProfile);

        return "redirect:/influencer";
    }

    @GetMapping("/add")
    public String showFormForAdd(Model model) {



        Influencer influencer = new Influencer();
        PersonalDetails personalDetails = new PersonalDetails();
        InstagramProfile instagramProfile = new InstagramProfile();
        List<Country> countryList = countryRepository.findAll();

        model.addAttribute("influencer", influencer);
        model.addAttribute("personalDetails", personalDetails);
        model.addAttribute("instagramProfile", instagramProfile);
        model.addAttribute("country", countryList);

        return "influencer-add.html";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("influencerId") int id) {

        influencerRepository.deleteById(id);
        personalDetailsReposiroty.deleteById(id);
        instagramProfileReposiroty.deleteById(id);

        return "redirect:/influencer";

    }


}
