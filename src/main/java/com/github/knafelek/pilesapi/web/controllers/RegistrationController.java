package com.github.knafelek.pilesapi.web.controllers;

import com.github.knafelek.pilesapi.dtos.RegistrationFormDTO;
import com.github.knafelek.pilesapi.web.dtos.UserDTO;
import com.github.knafelek.pilesapi.web.services.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;

@Controller
@RequestMapping("/register")
public class RegistrationController {

    private UserService userService;

    public RegistrationController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public String prepareRegistrationForm(Model model){
        model.addAttribute("registrationForm", new RegistrationFormDTO());
        return "registration-page";
    }

    @PostMapping
    public String processRegistrationPage(@Valid @ModelAttribute ("registrationForm") RegistrationFormDTO form, BindingResult result){ //tu trzeba powtórzyć nazwę bo by szukał registrationFormDTO
        if(result.hasErrors()){
            return "registration-page";
        }
        if (!checkPasswordsEquality(form)){ //tu już jest zwalidowane
            result.rejectValue("password", null, "Niezgodność haseł"); //metoda rejectValue! dorzucenie błędu do widoku: nazwa błędnego pola, kod błędu (na razie null bo nie mamy pliku z tekstami błędów), wyświetlenie wiadomości
            return "registration-page";
        }
        //ta walidacja wymaga kontaktu z bazą danych dlatego na końcu:
        if (!checkIfUserNameAvailable(form)){
            result.rejectValue("username", null, "Nazwa użytkownika zajęta");
            return "registration-page";
        }
        //konwersja registrationformDTO na user (encja) + wywołąnie userRepository.save() - zamiaste tego:
        userService.registerUser(form);
        return "redirect:/";
    }

    private boolean checkIfUserNameAvailable(RegistrationFormDTO form) {
        UserDTO user = userService.findUser(form.getUsername());
        if (user == null){
            return true;
        }
        return false;
    }

    private boolean checkPasswordsEquality(RegistrationFormDTO form) { //porównanie haseł
        return form.getPassword().equals(form.getConfirmedPassword());
    }
}
