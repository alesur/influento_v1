package com.influencer.management.app.controller;

import com.influencer.management.app.model.dao.InfluencerRepository;
import com.influencer.management.app.model.dao.ProductRepository;
import com.influencer.management.app.model.dao.ReviewRepository;
import com.influencer.management.app.model.entity.DayContacted;
import com.influencer.management.app.model.entity.Influencer;
import com.influencer.management.app.model.entity.Review;
import com.influencer.management.app.service.Owner;
import com.influencer.management.app.service.RestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;


/**
 *
 * This Controller manages the Dashboard (view dashboard.html) and handles /error
 * @home , maps "/", shows the Dashboard
 * @error, maps "/error", shows the Dashboard
 * @dashboard, maps "/dashboard", shows the Dashboard
 *
 */
@Controller
public class HomeController {


    @Autowired
    private InfluencerRepository influencerRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private ProductRepository productRepository;


    @GetMapping("/")
    public String home() {

        return "redirect:/dashboard";
    }

    @GetMapping("/error")
    public String error() {

        return "redirect:/";
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model) {

        List<Influencer> influencers = influencerRepository.findAll();
        List<Review> reviews = reviewRepository.findAll();
        long totalInfluencers = influencerRepository.count();
        long totalReviews = reviewRepository.count();
        long totalProducts = productRepository.count();



        model.addAttribute("totalInfluencers", totalInfluencers);
        model.addAttribute("totalReviews", totalReviews);
        model.addAttribute("totalProducts", totalProducts);
        model.addAttribute("influencer", influencers);
        model.addAttribute("reviews", reviews);

        return "dashboard.html";
    }
}
