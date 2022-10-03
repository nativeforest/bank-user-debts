package com.bankuserdebts.bankuser.models;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "debts")
public class Debt {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private Integer amount;
  private String dateRegistered;

  @JsonIgnore
  @ManyToOne
  @JoinColumn(name = "userId", nullable = false)
  private User userDebt;

  // @JsonIgnore
  @ManyToOne //(fetch = FetchType.LAZY)
  @JoinColumn(name = "bankId", referencedColumnName = "id",nullable = false)
  private Bank bank;
  
//setters getters
  public Integer getAmount() {
    return amount;
  }
  public void setAmount(Integer amount) {
    this.amount = amount;
  }
  public String getDateRegistered() {
    return dateRegistered;
  }
  public void setDateRegistered(String dateRegistered) {
    this.dateRegistered = dateRegistered;
  }
  public User getUser() {
    return userDebt;
  }
  public void setUser(User user) {
    this.userDebt = user;
  }
  public Bank getBank() {
    return bank;
  }
  public void setBank(Bank bank) {
    this.bank = bank;
  }

}
