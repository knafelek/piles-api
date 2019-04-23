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

        String zag = calculatedpile.getZag(); //ID
        String ground = calculatedpile.getGround(); //rodzaj gruntu
        String type = calculatedpile.getType(); //typ pala
        Double bearingCapacity = calculatedpile.getBearingCapacity(); // wymagana nośność

        BigDecimal zagBG = new BigDecimal(calculatedpile.getZag()); //ID w jednostceBD
        //BigDecimal add = zagBG.add(new BigDecimal("50.00")); przykłąd dodawania

        Double q=0.0;
        switch(zag){
            case "1.00":
                switch (ground){
                    case "Żwir, pospółka":
                        q=7750.0;
                        break;
                    case "Piasek gruby i średni":
                        q=5850.0;
                        break;
                    case "Piasek drobny":
                        q=4100.0;
                        break;
                    case "Piasek pylasty":
                        q=3350.0;
                        break;
                }
                break;
            case "0.67":
                switch (ground){
                    case "Żwir, pospółka":
                        q=5100.0;
                        break;
                    case "Piasek gruby i średni":
                        q=3600.0;
                        break;
                    case "Piasek drobny":
                        q=2700.0;
                        break;
                    case "Piasek pylasty":
                        q=2100.0;
                        break;
                }
                break;
            case "0.33":
                switch (ground){
                    case "Żwir, pospółka":
                        q=3000.0;
                        break;
                    case "Piasek gruby i średni":
                        q=2150.0;
                        break;
                    case "Piasek drobny":
                        q=1650.0;
                        break;
                    case "Piasek pylasty":
                        q=1150.0;
                        break;
                }
                break;
            default:
                switch (ground){
                    case "Żwir, pospółka":
                        q=1950.0;
                        break;
                    case "Piasek gruby i średni":
                        q=1450.0;
                        break;
                    case "Piasek drobny":
                        q=1050.0;
                        break;
                    case "Piasek pylasty":
                        q=700.0;
                        break;
                }
        }

        Double t=0.0; //kPa
        switch(zag){
            case "1.00":
                switch (ground){
                    case "Żwir, pospółka":
                        t=165.0;
                        break;
                    case "Piasek gruby i średni":
                        t=132.0;
                        break;
                    case "Piasek drobny":
                        t=100.0;
                        break;
                    case "Piasek pylasty":
                        t=75.0;
                        break;
                }
                break;
            case "0.67":
                switch (ground) {
                    case "Żwir, pospółka":
                        t = 110.0;
                        break;
                    case "Piasek gruby i średni":
                        t = 74.0;
                        break;
                    case "Piasek drobny":
                        t = 62.0;
                        break;
                    case "Piasek pylasty":
                        t = 45.0;
                        break;
                }
                break;
            case "0.33":
                switch (ground) {
                    case "Żwir, pospółka":
                        t = 74.0;
                        break;
                    case "Piasek gruby i średni":
                        t = 47.0;
                        break;
                    case "Piasek drobny":
                        t = 31.0;
                        break;
                    case "Piasek pylasty":
                        t = 25.0;
                        break;
                }
                break;
            default:
                switch (ground) {
                    case "Żwir, pospółka":
                        t = 59.0;
                        break;
                    case "Piasek gruby i średni":
                        t = 34.0;
                        break;
                    case "Piasek drobny":
                        t = 22.0;
                        break;
                    case "Piasek pylasty":
                        t = 16.0;
                        break;
                }
        }

        Double tr = t*0.9; //współczynnik materiałowy 0.9

        Double diameter = calculatedpile.getDiameter();
        Double hc=10.0;
        Double hci = hc*Math.sqrt(diameter/0.4);
        Double h=0.0;
        if(hci>hc){ //
            h=hci;
        }else{
            h=hc;
        }

        //WSPÓŁCZYNNIKI TECHNOLOGICZNE
        Double Sp = 0.0;
        Double Ss = 0.0;
        if(zag=="1.00"){ //>0.67
            switch (type){
                case "Pal prefabrykowany żelbetowy wbijany":
                    Sp=1.0;
                    Ss=1.0;
                    break;
                case "Pal prefabrykowany żelbetowy wpłukiwany":
                    Sp=1.0;
                    Ss=0.8;
                    break;
                case "Pal prefabrykowany żelbetowy wwibrowywany": //
                    Sp=1.0;
                    Ss=1.0;
                    break;
                case "Pal Franki":
                    Sp=1.3;
                    Ss=1.1;
                    break;
                default:
                    Sp=1.1;
                    Ss=1.0;
                    break;
            }
        } else {
            switch (type){
                case "Pal prefabrykowany żelbetowy wbijany":
                    Sp=1.1;
                    Ss=1.1;
                    break;
                case "Pal prefabrykowany żelbetowy wpłukiwany":
                    Sp=1.0;
                    Ss=0.8;
                    break;
                case "Pal prefabrykowany żelbetowy wwibrowywany": //
                    Sp=1.0;
                    Ss=0.8;
                    break;
                case "Pal Franki":
                    Sp=1.8;
                    Ss=1.6;
                    break;
                default:
                    Sp=1.4;
                    Ss=1.1;
                    break;
            }
        }

        //PRZEPROWADZENIE OBLICZEŃ DLA DŁUGOŚCI WYJŚIOWEJ = 4,0 m
        Double length = 4.0; //wartość wyjściowa długości do obliczeń
        Double qr = (length*q/h)*0.9; //sprawdzić interpolację!!! //współczynnik materiałowy 0.9
        Double Ap = Math.PI*diameter*diameter*0.25; //na razie tylko podstawa dodać pobocznicę
        if(type=="Pal Franki"){ //poszerzenie podstawy przy palach Franki - pozostałe warunki dla gruntów spoistych!
            Ap=1.75*Ap;
        }

        //NOŚNOŚĆ PODSTAWY DLA ZAGŁĘBIENIA 4,0 m
        Double Np = Sp*qr*Ap;

        //NOŚNOŚĆ POBOCZNICY DLA ZAGŁĘBIENIA 4,0 m
        Double As = Math.PI*diameter*length; //pole pobocznicy
        Double Ns = Ss*tr*As;

        //NOŚNOŚĆ CAŁKOWITA
        Double Nt = Np+Ns;

        if(Nt*0.9>=bearingCapacity){ // JEŻELI NOŚNOŚĆ WYSTARCZAJĄCA - KONIEC OBLICZEŃ
            return length;
        }

        // JEŻELI NOŚNOŚĆ NIEWYSTARCZAJĄCA:
        while (Nt*0.9<bearingCapacity){
            length += 0.5;
            qr = (length*q/h)*0.9;
            Np = Sp*qr*Ap;
            As = Math.PI*diameter*length;
            Ns = Ss*tr*As;
            Nt = Np+Ns;
        }
        return length;
    }
}
