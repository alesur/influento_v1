package com.influencer.management.app.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * This controller  manages the login operations
 * @viewLoginPage Get method, shows login page
 */

@Controller
public class LoginController {
    @GetMapping("/login")
    public String viewLoginPage() {

        return "login.html";
    }
}

