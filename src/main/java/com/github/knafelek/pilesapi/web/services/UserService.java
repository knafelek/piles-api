package com.github.knafelek.pilesapi.web.services;

import com.github.knafelek.pilesapi.domain.model.User;
import com.github.knafelek.pilesapi.domain.repositories.UserRepository;
import com.github.knafelek.pilesapi.dtos.RegistrationFormDTO;
import com.github.knafelek.pilesapi.web.dtos.UserDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import static com.github.knafelek.pilesapi.web.services.Converters.convertToUser;
import static com.github.knafelek.pilesapi.web.services.Converters.convertToUserDTO;

@Service
public class UserService {

    public static final Logger logger = LoggerFactory.getLogger(UserService.class); //Springboot daje spójność

    private UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Transactional //ze springframework!! - lepiej nad metodą a nie nad klasą, jeżeli tylko wyciągają to nie trzeba transakcji
    public void registerUser(RegistrationFormDTO form) { //metoda do rejestracji użytkownika - proces transakcyjny
        User user = Converters.convertToUser(form); //zamiast kawałka kodu z set get

        logger.info("Rejestracja użytkownika: " + user);
        userRepository.save(user);
        logger.info("Zarejestrowany użytkownik: " + user);
    }



    public UserDTO findUser(String username) {
        if(username == null){ //jest adnotacja notnull ale piszemy metodę uniwersjalną
            throw new IllegalArgumentException("Nazwa użytkownika musi być podana");
        }
        //obiekt opcional - obecna wersja spring data 2.0 więc metody w repozytoriach //zwraca listę lub pustą listę jeśli nieznajdzie; pojedynczy obiektu a jeśli nie znajdzie to wyjątek - zaiast zwracać obiekt usera zwracamy opakowany w obiekt optional żeby nie było wyjątku - w obiekcie optional mamy swój obiekt (po to żeby zamiast wyjątku był pusty obiekt optional)
        Optional<User> optionalUser = userRepository.findByUsername(username);
        User user = optionalUser.orElse(null); //zamiast obsługi wyjątku return null
        if(user == null){
            logger.debug("Nie znaleziono użytkownika dla nazwy '" + username + "'");
            return null;
        }
        logger.debug("Znaleziono użytkownia dla nazwy '" + username + "'");
        return Converters.convertToUserDTO(user); //po przeniesieniu metod do klasy converters dopisać Converters.


/*      ten fragment kodu
        UserDTO userDTO = new UserDTO(); //to lepiej do metody konwert
        userDTO.setUsername(user.getUsername());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        return userDTO;*/

    }


}
