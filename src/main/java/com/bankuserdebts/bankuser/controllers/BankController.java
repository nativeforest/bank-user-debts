package com.bankuserdebts.bankuser.controllers;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bankuserdebts.bankuser.models.Bank;
import com.bankuserdebts.bankuser.models.Debt;
import com.bankuserdebts.bankuser.models.User;
import com.bankuserdebts.bankuser.services.BankService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class BankController {
  @Autowired
  private BankService bankService;

  @PutMapping("/api/v1/bank/{BankId}/user/{userId}")
  public Bank registerBankToUser(
    @PathVariable long BankId, 
    @PathVariable long userId) {

    return bankService.registerBankToUser(BankId, userId);


  }
  @PutMapping("/api/v1/bank/{BankId}/debt/{debtId}")
  public Bank registerDebtToUser(
    @PathVariable long BankId, 
    @PathVariable long debtId) {

    return bankService.registerDebtToUser(BankId, debtId);


  }
 
  @GetMapping("/api/v1/bank/{BankId}/debts")
  public List<Debt> getDebtsByBankId(@PathVariable long BankId) {

    return bankService.getDebtsByBankId(BankId);

  }
  
  
}
