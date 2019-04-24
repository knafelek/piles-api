package com.github.knafelek.pilesapi.web.controllers;

import com.github.knafelek.pilesapi.domain.model.Investition;
import com.github.knafelek.pilesapi.domain.repositories.InvestitionRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

@Controller
@RequestMapping("/investition")
public class InvestitionController {

    private InvestitionRepository investitionRepository;

    public InvestitionController(InvestitionRepository investitionRepository) {
        this.investitionRepository = investitionRepository;
    }

    @GetMapping("/form")
    public String prepareInvestitionsPage(Model model) {
        Investition investition = new Investition();
        model.addAttribute("investition", investition);
        return "investition-form";
    }

    @PostMapping("/form")
    public String saveInvestition(@Valid @ModelAttribute("investition") Investition investition, BindingResult result){
        if (result.hasErrors()) {
            return "investition-form";
        }
        investitionRepository.save(investition);
        return "investitions-saved";
    }

    @ModelAttribute("findallinvestitions")
    public List<Investition> findAllInvestitions (){
        return investitionRepository.findAll();
    }

/*    @ModelAttribute("lastinvestition")
    public Investition findLastInvestition (){
        return investitionRepository.getFirstById();
    }*/

    @GetMapping("/page")
    public String showInvestitions(){
        return "investitions-page";
    }

}
