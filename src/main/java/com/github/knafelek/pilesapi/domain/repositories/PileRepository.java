package com.github.knafelek.pilesapi.domain.repositories;

import com.github.knafelek.pilesapi.domain.model.Pile;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PileRepository extends JpaRepository<Pile, Long> {

}
