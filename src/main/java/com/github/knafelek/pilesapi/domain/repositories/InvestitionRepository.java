package com.github.knafelek.pilesapi.domain.repositories;

import com.github.knafelek.pilesapi.domain.model.Investition;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InvestitionRepository extends JpaRepository<Investition, Long> {

}
