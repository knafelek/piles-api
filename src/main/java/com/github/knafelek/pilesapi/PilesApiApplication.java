package com.github.knafelek.pilesapi;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication //tutaj jest zaszyty komponent Scan dlatego wszystkie klasy muszą być w tym pakiecie!!!!
public class PilesApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(PilesApiApplication.class, args);
	}
}
