package com.bankuserdebts.bankuser.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bankuserdebts.bankuser.models.Debt;
import com.bankuserdebts.bankuser.repositories.DebtRepository;
import com.bankuserdebts.bankuser.services.DebtService;

@RestController
public class DebtController {
  //@Autowired
  //private DebtRepository debtRepository;
  @Autowired
  private DebtService debtService;

  @GetMapping("api/v1/debt")
  public String getDebt() {
    return "debt";
  }
  
  @GetMapping("api/v1/debts")
  public List<Debt> getAllDebts() {
    return debtService.getDebts();
  }
  @PutMapping("api/v1/debt")
  public Debt addDebt(Debt debt) {
    return debtService.addDebt(debt);
  }
  @PutMapping("api/v1/debt/bank/{bankId}/user/{userId}")
  public Debt updateDebtById( 
    @PathVariable long bankId, 
    @PathVariable long userId,
    @RequestBody Integer amount) {
     //System.out.println("bankId: " + bankId+ "userId: " + userId +"amount: " + amount);
    // return new Debt();

    return debtService.updateDebtById( bankId,  userId, amount);
  }

  
}
