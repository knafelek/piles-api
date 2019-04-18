package com.github.knafelek.pilesapi.web.controllers;

import com.github.knafelek.pilesapi.web.dtos.UserDTO;
import com.github.knafelek.pilesapi.web.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;

@Controller
public class HomePageController {

    private UserService service;

    public HomePageController(UserService service) {
        this.service = service;
    }

    @GetMapping("/home")
    public String prepareHomePage() {
        return "home-page";
    }

    @GetMapping("/user") //zwracanie zalogowanego użytkownika
    @ResponseBody
    public UserDTO prepareHomePage (Principal principal){
        UserDTO user = service.findUser(principal.getName());
        return user;
    }
}
