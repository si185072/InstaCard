package com.app.instacard.entity;

import javax.persistence.*;
import javax.validation.constraints.Size;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity(name="card_details")
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="card_type")
    private String cardType;
    @Column(name="parent_card_id")
    private Long parentCardId;
    @Column(name="account_id")
    private String accountId;
    @Column(name="card_no")
    private String cardNo;
    @Column(name="cvv")
    private String cvv;
    @Column(name="activation_date")
    @NotNull
    private Date activationDate;
    @Column(name="expiry_date")
    @NotNull
    private Date expiryDate;
    @Column(name="card_holder_name")
    private String cardHolderName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCardType() {
        return cardType;
    }

    public void setCardType(String cardType) {
        this.cardType = cardType;
    }

    public Long getParentCardId() {
        return parentCardId;
    }

    public void setParentCardId(Long parentCardId) {
        this.parentCardId = parentCardId;
    }

    public String getAccountId() {
        return accountId;
    }

    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }

    public String getCardNo() {
        return cardNo;
    }

    public void setCardNo(String cardNo) {
        this.cardNo = cardNo;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public Date getActivationDate() {
        return activationDate;
    }

    public void setActivationDate(Date activationDate) {
        this.activationDate = activationDate;
    }

    public Date getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(Date expiryDate) {
        this.expiryDate = expiryDate;
    }

    public String getCardHolderName() {
        return cardHolderName;
    }

    public void setCardHolderName(String cardHolderName) {
        this.cardHolderName = cardHolderName;
    }
}
