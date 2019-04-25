package com.github.knafelek.pilesapi.web.controllers;

import com.github.knafelek.pilesapi.domain.model.Investition;
import com.github.knafelek.pilesapi.domain.model.User;
import com.github.knafelek.pilesapi.domain.repositories.InvestitionRepository;
import com.github.knafelek.pilesapi.domain.repositories.UserRepository;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.security.Principal;
import java.util.List;

@Controller
@RequestMapping("/investition")
public class InvestitionController {

    private InvestitionRepository investitionRepository;
    private UserRepository userRepository;

    public InvestitionController(InvestitionRepository investitionRepository, UserRepository userRepository) {
        this.investitionRepository = investitionRepository;
        this.userRepository = userRepository;
    }

    @GetMapping("/form")
    public String prepareInvestitionsPage(Model model) {
        Investition investition = new Investition();
        model.addAttribute("investition", investition);
        return "investition-form";
    }

    @PostMapping("/form")
    public String saveInvestition(@Valid @ModelAttribute("investition") Investition investition, BindingResult result, Principal principal){
        if (result.hasErrors()) {
            return "investition-form";
        }
        User user = userRepository.findByUsername(principal.getName()).get(); //!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
        investitionRepository.save(investition);
        user.getInvestitionsList().add(investition);
        userRepository.save(user);
        return "investitions-saved";
    }

    @ModelAttribute("allInvestition")
    public List<Investition> findAllInvestitions (Principal principal){
        User user = userRepository.findByUsername(principal.getName()).get();
        return user.getInvestitionsList();
    }

/*
    @GetMapping("/edit")
    public String editInvestition(Model model, HttpServletRequest request){
        String param = request.getParameter("id");
        Long id = Long.parseLong(param);
        Investition investition = investitionRepository.getOne(id);
        model.addAttribute("investition", investition);
        return "investition/form";
    }
*/
/*
    @GetMapping("/delete")
    public String deleteInvestition(HttpServletRequest request){
        String param = request.getParameter("id");
        Long id = Long.parseLong(param);


        return"redirect:list";
    }
*/



    @GetMapping("/page")
    public String showInvestitions(){
        return "investitions-page";
    }

}
