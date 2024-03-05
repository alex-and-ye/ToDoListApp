package com.example.securingweb;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class RegistrationController {

    @GetMapping("/register")
    public String showRegistrationForm() {
        return "register";
    }


    @PostMapping("/register")
    public String processRegistrationForm(@RequestParam String username, @RequestParam String password, Model model) {
        // saving data to the database
        return "redirect:/hello";
    }
}
