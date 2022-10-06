package com.bankuserdebts.bankuser.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.bankuserdebts.bankuser.models.Bank;
import com.bankuserdebts.bankuser.models.Debt;
import com.bankuserdebts.bankuser.models.User;
import com.bankuserdebts.bankuser.repositories.BankRepository;
import com.bankuserdebts.bankuser.repositories.DebtRepository;
import com.bankuserdebts.bankuser.repositories.UserRepository;

@Service
public class BankService {
  @Autowired
  private BankRepository bankRepository;
  @Autowired
  private UserRepository userRepository;
  @Autowired
  private DebtRepository debtRepository;

  public Bank registerBankToUser(long bankId, long userId)  {
    System.out.println("bankId: " + bankId);
    System.out.println("userId: " + userId);
    try{
      Bank bank = bankRepository.findById(bankId).get();
      User user = userRepository.findById(userId).get();
      bank.setUsersBank(user);
      Boolean x =  bank.getUsersBank().add(user);
      return bankRepository.save(bank);

    }catch(Exception e) {
      return new Bank();
    }
    
     
  }
  public Bank registerDebtToUser(long bankId, long userId) {
    Bank bank = bankRepository.findById(bankId).get();
    Debt debt = debtRepository.findById(userId).get();
    return bankRepository.save(bank);
     
  }
  public List<Debt> getDebtsByBankId(long bankId) {
    List<Debt> debts = debtRepository.findDebtsByBankBankId(bankId);
    return debts;
     
  }
  public ResponseEntity<List<Bank>> getAllBanksByUserId(long userId) {
    if (!userRepository.existsById(userId)) {
      throw new RuntimeException("user not found");
    }
    List<Bank> banks = bankRepository.findBanksByUsersBankUserId(userId);
    return new ResponseEntity<>(banks, HttpStatus.OK);
  }
  

  
}
