package com.bankuserdebts.bankuser.models;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.JoinColumn;

import lombok.Data;

@Entity
@Table(name = "banks")
public class Bank {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private String name;
  
  @JsonIgnore
  @ManyToMany(targetEntity = User.class, cascade = CascadeType.ALL)
  @JoinTable(
    name = "bankUser",
    joinColumns =@JoinColumn(name="bankId"),
    inverseJoinColumns=@JoinColumn(name="userId")
    )
  private Set<User> usersBank = new HashSet<>();

  @JsonIgnore
  @OneToMany(mappedBy = "bank", fetch = FetchType.LAZY)
  private List<Debt> debts;

// GETTERS SETTERS
public long getId() {
  return id;
}
public void setId(long id){
        this.id=id;
    }
  public String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public Set<User> getUsersBank() {
    return usersBank;
  }
  public void setUsersBank(User user) {
    this.usersBank.add(user);
  }
  public List<Debt> getDebts() {
    return debts;
  }
  public void setDebts(Debt debt) {
    this.debts.add(debt);
  }
  
}
