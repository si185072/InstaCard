package com.app.instacard.entity;

import javax.persistence.*;

@Entity(name="account_details")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="account_no")
    private String accountNo;
    @Column(name="account_holder_name")
    private String accountHolderName;
    @Column(name="account_holder_mobile")
    private String accountHolderMobile;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAccountNo() {
        return accountNo;
    }

    public void setAccountNo(String accountNo) {
        this.accountNo = accountNo;
    }

    public String getAccountHolderName() {
        return accountHolderName;
    }

    public void setAccountHolderName(String accountHolderName) {
        this.accountHolderName = accountHolderName;
    }

    public String getAccountHolderMobile() {
        return accountHolderMobile;
    }

    public void setAccountHolderMobile(String accountHolderMobile) {
        this.accountHolderMobile = accountHolderMobile;
    }
}
