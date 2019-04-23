package com.github.knafelek.pilesapi.web.controllers;

import com.github.knafelek.pilesapi.dtos.PileCalculateDTO;
import com.github.knafelek.pilesapi.web.services.PileService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.Arrays;
import java.util.List;

@Controller
@RequestMapping("/pile")
public class PileController {

    private PileService pileService;

    public PileController(PileService pileService) {
        this.pileService = pileService;
    }

    @GetMapping("/calculate")
    public String prepareCalculatePage(Model model) {
        PileCalculateDTO pile = new PileCalculateDTO();
        model.addAttribute("pile", pile);
        return "calculate-form";
    }

    @PostMapping("/calculate")
    public String showResultPage(@Valid @ModelAttribute("pile") PileCalculateDTO calculatedpile, BindingResult result, Model model){
        if (result.hasErrors()) {
            return "calculate-form";
        }
        Double length = pileService.calculatePileLength(calculatedpile);
        model.addAttribute("pileLength", length);
        return "calculate-result";
    }

    @ModelAttribute("ID")
    public List<String> checkID(){
        return Arrays.asList("1.00", "0.67", "0.33", "0.20");
    }

    @ModelAttribute("type")
    public List<String> checkType(){
        return Arrays.asList("Pal prefabrykowany żelbetowy wbijany",
                "Pal prefabrykowany żelbetowy wpłukiwany",
                "Pal prefabrykowany żelbetowy wwibrowywany",
                "Pal Franki",
                "Pal Vibro");
    }

    @ModelAttribute("ground")
    public List<String> checkGround(){
        return Arrays.asList("Żwir, pospółka",
                "Piasek gruby i średni",
                "Piasek drobny",
                "Piasek pylasty");
    }
}
