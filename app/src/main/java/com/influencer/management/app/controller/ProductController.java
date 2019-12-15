package com.influencer.management.app.controller;

import com.influencer.management.app.model.dao.ProductRepository;

import com.influencer.management.app.model.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


/**
 * This Controller manages operations with Products
 *
 * @productList shows the list of existing products
 * @edit Get method, shows a prefilled form with the actual value of the Product ({id})to be edited
 * @edit Post method, performs the update of the give product, or creation of new product
 * @delete , performs the deletion of the product by {id}
 * @showFormForAdd , shows a form to create new product
 */
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

    /**
     * mapping to edit products
     */
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model model) {

        Product product = productRepository.getOne(id);

        model.addAttribute("product", product);

        return "product-edit.html";
    }

    /**
     * mapping to edit existing product records or save new products
     */
    @PostMapping("/edit")
    public String edit(@Valid Product product, Model theModel) {

        if (product.getName().trim().isEmpty()) {
            return "redirect:/products";
        }
        productRepository.save(product);
        return "redirect:/products";
    }

    /**
     * mapping to delete products
     */
    @GetMapping("/delete")
    public String delete(@RequestParam("productId") int id) {

        productRepository.deleteById(id);

        return "redirect:/products/";

    }

    /**
     * mapping to add products
     */

    @GetMapping("/add")
    public String showFormForAdd(Model model) {

        Product product = new Product();

        model.addAttribute("product", product);

        return "product-add.html";
    }

}
