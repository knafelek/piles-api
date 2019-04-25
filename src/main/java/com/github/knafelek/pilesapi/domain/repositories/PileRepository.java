package com.github.knafelek.pilesapi.domain.repositories;

import com.github.knafelek.pilesapi.domain.model.Pile;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PileRepository extends JpaRepository<Pile, Long> {


    @Query(value ="select p.* from piles p join investitions i on p.investition_id = i.id join users_investitions_list ui on i.id = ui.investitions_list_id join users u on ui.user_id = u.id where u.username=?1", nativeQuery = true)
    List<Pile> getAllPilesByUsername (String username);

}
