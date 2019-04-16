package com.github.knafelek.pilesapi.dtos;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegistrationFormDTO { //pozwoli przechować dane z widoku

    //tutaj wrzucamy walidację!!! na obiekt wrzucany z zewnątrz
    //grupy walidacyjne - do kitu
    //teraz więcej klas ale o to chodzi!

    @NotNull @Size(min = 3, max = 20)
    private String username;
    @NotNull @Size(min = 3, max = 20)
    private String password;
    @NotNull @Size(min = 3, max = 20)
    private String confirmedPassword;
    @NotBlank
    private String firstName;
    @NotBlank
    private String lastName;

}
