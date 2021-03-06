package com.github.knafelek.pilesapi.web.controllers;

import com.github.knafelek.pilesapi.domain.model.Investition;
import com.github.knafelek.pilesapi.domain.model.Pile;
import com.github.knafelek.pilesapi.domain.model.User;
import com.github.knafelek.pilesapi.domain.repositories.InvestitionRepository;
import com.github.knafelek.pilesapi.domain.repositories.PileRepository;
import com.github.knafelek.pilesapi.domain.repositories.UserRepository;
import com.github.knafelek.pilesapi.dtos.PileCalculateDTO;
import com.github.knafelek.pilesapi.web.services.PileService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.security.Principal;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/pile")
public class PileController {

    private PileService pileService;
    private PileRepository pileRepository;
    private UserRepository userRepository;
    private InvestitionRepository investitionRepository;

    public PileController(PileService pileService, PileRepository pileRepository, UserRepository userRepository, InvestitionRepository investitionRepository) {
        this.pileService = pileService;
        this.pileRepository = pileRepository;
        this.userRepository = userRepository;
        this.investitionRepository = investitionRepository;
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


    @ModelAttribute("allInvestition")
    public List<Investition> findAllInvestitions (Principal principal){
        User user = userRepository.findByUsername(principal.getName()).get();
        return user.getInvestitionsList();
    }

    @ModelAttribute("ground")
    public List<String> checkGround(){
        return Arrays.asList("Żwir, pospółka",
                "Piasek gruby i średni",
                "Piasek drobny",
                "Piasek pylasty");
    }

    @GetMapping("/form")
    public String preparePilePage(Model model, Pile pile) {
        model.addAttribute("pile", pile);
        return "pile-form";
    }

    @PostMapping("/form")
    public String savePile(@Valid @ModelAttribute("pile") Pile pile,  BindingResult result, Long investitionId){
        if (result.hasErrors()) {
            return "pile-form";
        }
        Investition investition = investitionRepository.getOne(investitionId);
        pile.setInvestition(investition);
        pileRepository.save(pile);
        return "redirect:/pile/page";
    }

    @GetMapping("/page")
    public String showPilesPage(Model model) {
        Pile pile = new Pile();
        model.addAttribute("pile", pile);
        return "piles-page";
    }

    @ModelAttribute("allPiles")
    public List<Pile> findAllPiles (Principal principal){
        return pileRepository.getAllPilesByUsername(principal.getName());
    }

    @GetMapping("/edit")
    public String editPile(Model model, Long id){
        Pile pile = pileRepository.getOne(id);
        model.addAttribute("pile", pile);
        return "pile-form";
    }

    @PostMapping("/edit")
    public String saveEditedPile(@Valid @ModelAttribute("pile") Pile pile,  BindingResult result, Long investitionId){
        if (result.hasErrors()) {
            return "pile-form";
        }
        Investition investition = investitionRepository.getOne(investitionId);
        pile.setInvestition(investition);
        pileRepository.save(pile);
        return "redirect:/pile/page";
    }

    @GetMapping("/delete")
    public String deletePile(Model model, Long id){
        Pile pile = pileRepository.getOne(id);
        pileRepository.delete(pile);
        return"redirect:/pile/page";
    }

//    // ZAPYTAĆ
//    @ModelAttribute("allInvestitionPiles")
//    public List<Pile> findAllInvestitionsPiles (Long investitionId){
//        Investition investition = investitionRepository.getOne(investitionId);
//        return investition.getPilesList();
//    }

    @GetMapping("/list")
    public String showInvestitionsPilesList(Long investitionId, Model model){
        Investition investition = investitionRepository.getOne(investitionId);
        model.addAttribute("investition", investition);
        model.addAttribute("allInvestitionPiles", investition.getPilesList());
        return "piles-list";
    }

}
