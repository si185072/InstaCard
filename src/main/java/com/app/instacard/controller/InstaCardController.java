package com.app.instacard.controller;

import com.app.instacard.entity.Account;
import com.app.instacard.entity.Card;
import com.app.instacard.entity.CardRestrictions;
import com.app.instacard.model.InstantCardRequestDTO;
import com.app.instacard.model.InstantCardRestrictionRequestDTO;
import com.app.instacard.service.InstaCardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;
import java.util.List;

@RestController
public class InstaCardController {

    @Autowired
    InstaCardService instaCardService;

    @GetMapping("/primaryCards")
    public List<Card> getAllPrimaryCards(){
        return instaCardService.getAllPrimaryCards();
    }

    @GetMapping("/instantCards/{primaryCardNo}")
    public List<Card> getInstantCards(@PathVariable("primaryCardNo") String primaryCardNo ){
        return instaCardService.getInstantCards(primaryCardNo);
    }

    @PostMapping("/generateInstantCard")
    public Card generateInstantCard( @RequestBody @Validated InstantCardRequestDTO instantCard) throws NoSuchAlgorithmException {
        Card card = new Card();
        card.setParentCardId(instantCard.getParentCardId());
        card.setExpiryDate(instantCard.getExpiryDate());
        card.setActivationDate(instantCard.getActivationDate());
        return instaCardService.save(card);
    }

    @PostMapping("/getInstantCardRestriction/{instantCardNo}")
    public CardRestrictions getInstantCardRestriction(@PathVariable("instantCardNo") String instantCardNo) {
        return instaCardService.getInstantCardsRestrictions(instantCardNo);
    }

    @PostMapping("/instantCardRestriction")
    public CardRestrictions setInstantCardRestriction(@RequestBody @Validated InstantCardRestrictionRequestDTO instantCardRestrictionRequestDTO) {
        CardRestrictions cardRestrictions = new CardRestrictions();
        cardRestrictions.setCardId(instantCardRestrictionRequestDTO.getCardId());
        cardRestrictions.setCountry(instantCardRestrictionRequestDTO.getCountry());
        cardRestrictions.setCurrency(instantCardRestrictionRequestDTO.getCurrency());
        cardRestrictions.setLimit(instantCardRestrictionRequestDTO.getLimit());
        return instaCardService.setInstantCardRestriction(cardRestrictions);
    }
}
