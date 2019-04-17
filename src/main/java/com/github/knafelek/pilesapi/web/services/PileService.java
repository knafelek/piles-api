package com.github.knafelek.pilesapi.web.services;

import com.github.knafelek.pilesapi.domain.repositories.PileRepository;
import com.github.knafelek.pilesapi.dtos.PileCalculateDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class PileService {

    public static final Logger logger = LoggerFactory.getLogger(PileService.class);

    private PileRepository pileRepository;

    public PileService(PileRepository pileRepository) {
        this.pileRepository = pileRepository;
    }

    public Double calculatePileLength(PileCalculateDTO calculatedpile) {
        Double length = 4.0; //wartość wyjściowa długości do obliczeń
        Double diameter = calculatedpile.getDiameter();
        Double bearingCapacity = calculatedpile.getBearingCapacity();

        Double Ap = Math.PI*diameter*diameter*0.25; //na razie tylko podstawa dodać pobocznicę

        String zag = calculatedpile.getZag();

        BigDecimal zagBG = new BigDecimal(calculatedpile.getZag());

        //BigDecimal add = zagBG.add(new BigDecimal("50.00")); przykłąd dodawania

        Double q=0.0;
        switch(zag){
            case "1.00":
                q=7750.0;
                break;
            case "0.67":
                q=5100.0;
                break;
            case "0.33":
                q=3000.0;
                break;
            default:
                q=1950.0;
        }

        Double t=0.0;
        switch(zag){
            case "1.00":
                t=165.0;
                break;
            case "0.67":
                t=110.0;
                break;
            case "0.33":
                t=74.0;
                break;
            default:
                t=59.0;
        }

        Double Sp = 1.1; //współczynnik technologiczny na razie na sztywno

        Double Np = Sp*q*Ap;


        length = diameter*bearingCapacity; // !!!


        return length;
    }
}
