package com.app.instacard.service;

import com.app.instacard.entity.Card;
import com.app.instacard.entity.CardRestrictions;
import com.app.instacard.repository.InstaCardRepository;
import com.app.instacard.repository.InstantCardRestrictionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.*;
import java.util.stream.Collectors;

@Service
public class InstaCardService {
    @Autowired
    InstaCardRepository instaCardRepository;

    @Autowired
    InstantCardRestrictionRepository instantCardRestrictionRepository;

    private static String CARD_TYPE_PARENT = "P";
    private static String CARD_TYPE_CHILD = "C";

    @PostConstruct
    private void init(){
        Card card1 = new Card();
        card1.setCardNo("5349871197805727");
        card1.setCardType(CARD_TYPE_PARENT);
        card1.setParentCardId(null);
        card1.setCardHolderName("Sara Udipi");
        card1.setAccountId("8088579830");
        Calendar cal = Calendar.getInstance();
        card1.setActivationDate(cal.getTime());
        cal.add(Calendar.YEAR, 4);
        card1.setExpiryDate(cal.getTime());
        card1.setCvv("366");

        Card card2 = new Card();
        card2.setCardNo("5332885716415221");
        card2.setCardType(CARD_TYPE_PARENT);
        card2.setParentCardId(null);
        card2.setCardHolderName("Svikas Abdella");
        card2.setAccountId("8634303617");
        Calendar cal1 = Calendar.getInstance();
        card2.setActivationDate(cal1.getTime());
        cal1.add(Calendar.YEAR, 4);
        card2.setExpiryDate(cal1.getTime());
        card2.setCvv("366");
        instaCardRepository.save(card1);
        instaCardRepository.save(card2);
    }

    public List<Card> getAllPrimaryCards() {
        return instaCardRepository.findCardByCardType(CARD_TYPE_PARENT);
    }

    public Card save(Card card) throws NoSuchAlgorithmException {
        Optional<Card> parentCardOp = instaCardRepository.findById(card.getParentCardId());
        Card parentCard = parentCardOp.orElseGet(Card::new);
        String cardNo = generateCardNo(parentCard.getCardNo());
        String cvv = generateCvv();
        card.setCardNo(cardNo);
        card.setCardType(CARD_TYPE_CHILD);
        card.setParentCardId(parentCard.getId());
        card.setCardHolderName(parentCard.getCardHolderName());
        card.setCvv(cvv);
        card.setAccountId(parentCard.getAccountId());
        instaCardRepository.save(card);
        return card;
    }

    private String generateCvv() throws NoSuchAlgorithmException {
        Random rnd = SecureRandom.getInstanceStrong();
        int number = rnd.nextInt(999);
        return String.format("%03d", number);
    }

    private String generateCardNo(String cardNo) throws NoSuchAlgorithmException {
        Random rnd = SecureRandom.getInstanceStrong();
        int number = rnd.nextInt(9999999);
        String cardNoInitial = cardNo.substring(0,8)+String.format("%07d", number);
        return cardNoInitial + generateCheckDigit(Long.parseLong(cardNoInitial));
    }

    private int generateCheckDigit(long l) {
        String str = Long.toString(l);
        int[] ints = new int[str.length()];
        for(int i = 0;i< str.length(); i++){
            ints[i] = Integer.parseInt(str.substring(i, i+1));
        }
        for(int i = ints.length-2; i>=0; i=i-2){
            int j = ints[i];
            j = j*2;
            if(j>9){
                j = j%10 + 1;
            }
            ints[i]=j;
        }
        int sum=0;
        for (int anInt : ints) {
            sum += anInt;
        }
        if(sum%10==0){
            return 0;
        }else return 10-(sum%10);
    }

    public List<Card> getInstantCards(String primaryCardNo) {
        Card parentCard = instaCardRepository.findCardByCardNo(primaryCardNo);
        return instaCardRepository.findByParentCardId(parentCard.getId());
    }

    public CardRestrictions getInstantCardsRestrictions(String instantCardNo) {
        Card card = instaCardRepository.findCardByCardNo(instantCardNo);
        return instantCardRestrictionRepository.findByCardId(card.getId());
    }

    public CardRestrictions setInstantCardRestriction(CardRestrictions cardRestrictions) {
        instantCardRestrictionRepository.save(cardRestrictions);
        return cardRestrictions;
    }
}
