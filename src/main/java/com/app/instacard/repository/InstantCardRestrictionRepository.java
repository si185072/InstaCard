package com.app.instacard.repository;

import com.app.instacard.entity.Card;
import com.app.instacard.entity.CardRestrictions;
import org.springframework.data.jpa.repository.JpaRepository;

public interface InstantCardRestrictionRepository extends JpaRepository<CardRestrictions,Long>  {
    CardRestrictions findByCardId(Long id);
}
