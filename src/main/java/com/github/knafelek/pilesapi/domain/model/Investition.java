package com.github.knafelek.pilesapi.domain.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name="investitions")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Investition {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "signature", nullable = false, unique=true)
    private String investitionSignature;
    @Column(name = "title", nullable = false)
    private String investitionTitle;
    @Column(name = "description")
    private String investitionDecription;

    @OneToMany(mappedBy = "investition")
    private List<Pile> pilesList = new ArrayList<>();

    @Override
    public String toString() {
        return "Investition{" +
                "id=" + id +
                ", investitionSignature='" + investitionSignature + '\'' +
                ", investitionTitle='" + investitionTitle + '\'' +
                ", investitionDecription='" + investitionDecription + '\'' +
                '}';
    }
}
