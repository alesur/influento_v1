package com.influencer.management.app.controller;

import com.influencer.management.app.model.dao.CountryRepository;
import com.influencer.management.app.model.dao.ProductRepository;
import com.influencer.management.app.model.entity.Country;
import com.influencer.management.app.model.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/countries")
public class CountryController {
    @Autowired
    private CountryRepository countryRepository;

    @GetMapping
    public String productList(Model model) {

        model.addAttribute("countries", countryRepository.findAll());

        return "countries.html";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model model) {

        Country country = countryRepository.getOne(id);

        model.addAttribute("country", country);

        return "country-edit.html";
    }

    @PostMapping("/edit")
    public String edit(@Valid Country country) {
        if (country.getName().trim().isEmpty()) {
            return "redirect:/countries";
        }
        countryRepository.save(country);
        return "redirect:/countries";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("countryId") int id) {

        countryRepository.deleteById(id);

        return "redirect:/countries/";

    }

    @GetMapping("/add")
    public String showFormForAdd(Model model) {

        Country country = new Country();

        model.addAttribute("country", country);

        return "/country-add.html";
    }

}
