package com.app.instacard.repository;

import com.app.instacard.entity.Account;
import com.app.instacard.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface InstaCardRepository extends JpaRepository<Card,Long> {
    List<Card> findCardByCardType(String cardType);
    Card findCardByCardNo(String cardNo);
    List<Card> findByParentCardId(Long id);
}
