package com.github.knafelek.pilesapi.web.controllers;

import com.github.knafelek.pilesapi.domain.model.Investition;
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
@RequestMapping("/investition")
public class InvestitionController {

    @GetMapping("/form")
    public String prepareInvestitionPage(Model model) {
        Investition investition = new Investition();
        model.addAttribute("investition", investition);
        return "investition-form";
    }

/*    @PostMapping("/form")
    public String showInvestitions(@Valid @ModelAttribute("investition") Investition investition, BindingResult result){
        if (result.hasErrors()) {
            return "investition-form";
        }
        return "investitions-page";
    }*/
}
