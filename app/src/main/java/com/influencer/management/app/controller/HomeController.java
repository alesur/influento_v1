package com.influencer.management.app.controller;

import com.influencer.management.app.model.dao.InfluencerRepository;
import com.influencer.management.app.model.dao.ProductRepository;
import com.influencer.management.app.model.dao.ReviewRepository;
import com.influencer.management.app.model.entity.Influencer;
import com.influencer.management.app.model.entity.Product;
import com.influencer.management.app.service.Post;
import com.influencer.management.app.service.RestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class HomeController {
    @Autowired
    private InfluencerRepository influencerRepository;

    @Autowired
    private ReviewRepository reviewRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private RestService restService;

    @GetMapping("/")
    public String home() {

        return "redirect:/influencer";
    }

    @GetMapping("/dashboard")
    public String dashboard(Model model) {


        System.out.println(restService.getPostsPlainJSON());

        long totalInfluencers = influencerRepository.count();
        long totalReviews = reviewRepository.count();
        long totalProducts = productRepository.count();

        model.addAttribute("totalInfluencers", totalInfluencers);
        model.addAttribute("totalReviews", totalReviews);
        model.addAttribute("totalProducts", totalProducts);

        return "dashboard.html";
    }
}
