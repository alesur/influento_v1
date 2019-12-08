package com.influencer.management.app.controller;

import com.influencer.management.app.model.dao.ProductRepository;

import com.influencer.management.app.model.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductRepository productRepository;

    @GetMapping
    public String productList(Model model) {

        model.addAttribute("products", productRepository.findAll());

        return "products.html";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model model) {

        Product product = productRepository.getOne(id);

        model.addAttribute("product", product);

        return "product-edit.html";
    }

    @PostMapping("/edit")
    public String edit(@Valid Product product) {

        productRepository.save(product);

        return "redirect:/products/";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam("productId") int id) {

        productRepository.deleteById(id);

        return "redirect:/products/";

    }

    @GetMapping("/add")
    public String showFormForAdd(Model model) {

        Product product = new Product();

        model.addAttribute("product", product);

        return "product-add.html";
    }

}
