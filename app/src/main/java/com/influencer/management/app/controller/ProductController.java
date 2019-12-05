package com.influencer.management.app.controller;

import com.influencer.management.app.model.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @GetMapping("/products")
    public String productList(Model model) {

        model.addAttribute("products", productRepository.findAll());

        return "products.html";
    }
}
