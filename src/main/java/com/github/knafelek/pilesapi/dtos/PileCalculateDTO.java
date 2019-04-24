package com.github.knafelek.pilesapi.dtos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Column;
import javax.validation.constraints.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PileCalculateDTO {

    @NotNull
    private Long signature;
    @Positive
    @Column(columnDefinition = "NUMERIC(15,2)")
    private Double diameter;
    @Column(name="bearing_capacity", columnDefinition = "NUMERIC(25,2)")
    @NotNull @Positive
    private Double bearingCapacity;
    private Boolean loadTest;

    private String zag;
    private String zwg;
    private String type;
    private String ground;

}
