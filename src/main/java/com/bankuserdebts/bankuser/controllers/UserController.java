package com.bankuserdebts.bankuser.controllers;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.bankuserdebts.bankuser.models.Bank;
import com.bankuserdebts.bankuser.models.Debt;
import com.bankuserdebts.bankuser.models.User;
import com.bankuserdebts.bankuser.models.UserBank;
import com.bankuserdebts.bankuser.services.BankService;
import com.bankuserdebts.bankuser.services.DebtService;
import com.bankuserdebts.bankuser.services.UserService;



@RestController
public class UserController {
  @Autowired
  private UserService userService;
  @Autowired
  private DebtService debtService;
  @Autowired
  private BankService bankService;

  @GetMapping("/api/v1/bank/{bankId}/users")
  public ResponseEntity<List<User>> getAllUsersByBankId(@PathVariable long bankId) {

    ResponseEntity<List<User>> users= userService.getAllUsersByBanksId(bankId);
    return users;
  }

  @GetMapping("/api/v1/user/{userId}/debts")
  public ResponseEntity<List<Debt>> getAllDebtsByUserId(@PathVariable long userId) {

    ResponseEntity<List<Debt>> debts= debtService.getAllDebtsByUserId(userId);
    return debts;
  }
  @GetMapping("/api/v1/user/{userId}/banks")
  public ResponseEntity<List<Bank>> getAllBanksByUserId(@PathVariable long userId) {

    ResponseEntity<List<Bank>> banks= bankService.getAllBanksByUserId(userId);
    return banks;
  }
  

  

}
