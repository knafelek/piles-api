package com.github.knafelek.pilesapi.web.dtos;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserDTO {

    //dane z poziomu użytkownika w warstwie widoku
    //reprezentacja danych zapisanych więc bez walidacji

    private String username;
    private String firstName;
    private String lastName;

}
