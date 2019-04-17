package com.github.knafelek.pilesapi.domain.model;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name="piles")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Pile {

    @Id
    private Long id;
    @Column(nullable = false, unique=true)
    private Long signature;
    @Column(columnDefinition = "NUMERIC(15,2)")
    private Double diameter;
    @Column(columnDefinition = "NUMERIC(15,2)")
    private Double length;
    @Column(name="bearing_capacity", columnDefinition = "NUMERIC(25,2)")
    private Double bearingCapacity;
    private Boolean loadTest;

    @ManyToOne
    private Investition investition;

    @Override
    public String toString() {
        return "Pile{" +
                "signature=" + signature +
                ", diameter=" + diameter +
                ", length=" + length +
                ", bearingCapacity=" + bearingCapacity +
                ", loadTest=" + loadTest +
                '}';
    }
}
