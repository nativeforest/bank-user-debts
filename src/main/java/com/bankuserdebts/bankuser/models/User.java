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
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Data;


@Entity
@Table(name = "users")
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private long id;
  private String name;
  private String email;
  private String password;

  @JsonIgnore
  @ManyToMany(fetch = FetchType.LAZY,mappedBy = "usersBank", cascade = CascadeType.ALL)
  private List<Bank> banks = new ArrayList<>();
  // findUsers By BanksId

  @JsonIgnore
  @OneToMany(mappedBy = "userDebt")
  private List<Debt> debts = new ArrayList<>();
  //GETTERS SETTERS
  public long getId() {
    return id;
  }
  public void setId(long id){
    this.id=id;
}
  public  String getName() {
    return name;
  }
  public void setName(String name) {
    this.name = name;
  }
  public  String getEmail() {
    return email;
  }
  public void setEmail(String email) {
    this.email = email;
  }
  public  String getPassword() {
    return password;
  }
  public void setPassword(String password) {
    this.password = password;
  }
  public List<Bank> getBanks() {
    return banks;
  }
  public void setBanks(Bank bank) {
    this.banks.add(bank);
  }
  

}
