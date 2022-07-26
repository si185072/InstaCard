package com.app.instacard.model;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;

public class InstantCardRestrictionRequestDTO {
    @NotNull
    private Long cardId;
    @Column(name="country")
    private String country;
    @Column(name="limit")
    private Long limit;
    @Column(name="currency")
    private String currency;

    public Long getCardId() {
        return cardId;
    }

    public void setCardId(Long cardId) {
        this.cardId = cardId;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Long getLimit() {
        return limit;
    }

    public void setLimit(Long limit) {
        this.limit = limit;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }
}
