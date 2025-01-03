package com.pharmacy.pharmacy_billing.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pharmacy.pharmacy_billing.model.User;
import com.pharmacy.pharmacy_billing.service.UserService;

@Controller
public class RegistrationController {
    private final UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }
    @GetMapping("/")
    public String redirectToRegistration() {
        return "redirect:/register";
    }

    @GetMapping("/register")
    public String showRegistrationForm() {
        return "register";
    }

    @PostMapping("/register")
    public String registerUser(@RequestParam String username, @RequestParam String password, @RequestParam String role, Model model) {
        if (userService.findByUsername(username) != null) {
            model.addAttribute("error", "Username already exists!");
            return "register";
        }

        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setRole(role);
        userService.registerUser(user);

        return "redirect:/login";
    }
}