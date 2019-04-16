package com.github.knafelek.pilesapi.web.services;

import com.github.knafelek.pilesapi.domain.model.User;
import com.github.knafelek.pilesapi.dtos.RegistrationFormDTO;
import com.github.knafelek.pilesapi.web.dtos.UserDTO;

public class Converters {

    public static User convertToUser(RegistrationFormDTO form) {
        User user = new User();
        user.setUsername(form.getUsername());
        user.setPassword(form.getPassword());
        user.setFirstName(form.getFirstName());
        user.setLastName(form.getLastName());
        return user;
    }

    public static UserDTO convertToUserDTO(User user) {
        UserDTO userDTO = new UserDTO();
        userDTO.setUsername(user.getUsername());
        userDTO.setFirstName(user.getFirstName());
        userDTO.setLastName(user.getLastName());
        return userDTO;
    }

}
