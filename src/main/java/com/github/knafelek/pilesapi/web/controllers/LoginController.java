package com.github.knafelek.pilesapi.web.controllers;

import com.github.knafelek.pilesapi.domain.model.User;
import com.github.knafelek.pilesapi.dtos.PileCalculateDTO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/login")
public class LoginController {

    @GetMapping
    public String prepareLoginPage() {
        return "login-page";
    }

/*    @GetMapping
    public String prepareLoginPage(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "login-page";
    }*/

/*    @PostMapping
    public String showUserPage(@Valid @ModelAttribute("user") User user, BindingResult result, Model model){
        if (result.hasErrors()) {
            return "login-page";
        }
        model.addAttribute("user", user);
        return "redirect:user-page";
    }*/

}
