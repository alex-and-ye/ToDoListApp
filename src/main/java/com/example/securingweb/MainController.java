package com.example.securingweb;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.JdbcUserDetailsManager;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.ui.Model;

import jakarta.validation.Valid;


@Controller
public class MainController {

    @Autowired
    private JdbcUserDetailsManager userManager;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/register") 
    public String showRegisterForm(UserForm userForm) {
        return "register";
    }

    
    @PostMapping("/register")
    public String registerForm(@Valid UserForm userForm, BindingResult bindingResult, Model model) {
        if (bindingResult.hasErrors()) {
            return ("register");
        }
        if (userManager.userExists(userForm.getUsername())) {
            model.addAttribute("exists", true);
            return ("register");
        }
        UserDetails user = User.builder().username(userForm.getUsername()).password(passwordEncoder.encode(userForm.getPassword())).roles("USER").build();
        userManager.createUser(user);
        return "redirect:/home";
    }
}
