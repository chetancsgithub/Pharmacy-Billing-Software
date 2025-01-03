package com.pharmacy.pharmacy_billing.controller;



import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.pharmacy.pharmacy_billing.model.User;
import com.pharmacy.pharmacy_billing.service.UserService;

@Controller
public class LoginController {
    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/login")
    public String login() {
        return "login";
    }

    @PostMapping("/login")
    public String authenticateUser(@RequestParam String username, @RequestParam String password, Model model) {
        User user = userService.authenticate(username, password);
        if (user != null) {
            if (user.getRole().equalsIgnoreCase("Admin")) {
                return "redirect:/inventory";
            } else {
                return "redirect:/pharmacist/dashboard";
            }
        } else {
            model.addAttribute("error", "Invalid username or password");
            return "login";
        }
    }
}
