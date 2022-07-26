package com.app.instacard.model;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class InstantCardRequestDTO {
    @NotNull
    private Long parentCardId;
    @NotNull
    private Date activationDate;
    @NotNull
    private Date expiryDate;
    public Long getParentCardId() {
        return parentCardId;
    }

    public void setParentCardId(Long parentCardId) {
        this.parentCardId = parentCardId;
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

}
