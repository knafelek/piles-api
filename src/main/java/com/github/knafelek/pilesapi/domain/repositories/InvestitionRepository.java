package com.github.knafelek.pilesapi.domain.repositories;

import com.github.knafelek.pilesapi.domain.model.Investition;
import com.github.knafelek.pilesapi.domain.model.Pile;
import com.github.knafelek.pilesapi.domain.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface InvestitionRepository extends JpaRepository<Investition, Long> {


    @Query("select i from Investition i order by i.id desc")
    Investition getFirstById();

}
