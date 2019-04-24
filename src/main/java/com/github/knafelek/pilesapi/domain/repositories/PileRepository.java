package com.github.knafelek.pilesapi.domain.repositories;

import com.github.knafelek.pilesapi.domain.model.Investition;
import com.github.knafelek.pilesapi.domain.model.Pile;
import com.github.knafelek.pilesapi.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PileRepository extends JpaRepository<Pile, Long> {

    @Query("select p from Pile p where p.investition = :investition")
    List<Pile> getPileByInvestition(@Param("investition") Investition investition);

}
