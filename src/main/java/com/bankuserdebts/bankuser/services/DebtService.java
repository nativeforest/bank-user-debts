package com.bankuserdebts.bankuser.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.bankuserdebts.bankuser.models.Debt;
import com.bankuserdebts.bankuser.repositories.DebtRepository;
import com.bankuserdebts.bankuser.repositories.UserRepository;

@Service
public class DebtService {
  @Autowired
  private DebtRepository debtRepository;
  @Autowired UserRepository userRepository;

  public List<Debt> getDebts() {

    return debtRepository.findAll();
  }
 
  public Debt addDebt(Debt debt) {
    return debtRepository.save(debt);
  }
  public List<Debt> getDebtsByBankId(long bankId) {
    List<Debt> debts = debtRepository.findDebtsByBankBankId(bankId);
    return debts;
     
  }
  public ResponseEntity<List<Debt>> getAllDebtsByUserId(long userId) {
    if (!debtRepository.existsById(userId)) {
      throw new RuntimeException("user not found");
    }
    List<Debt> debts = debtRepository.findDebtByUserDebtUserId(userId);
    return new ResponseEntity<>(debts, HttpStatus.OK);

     
  }
  public Debt getDebtById(long id) {
    return debtRepository.findById(id).get();
  }
  public Debt updateDebt(Debt debt) {
    return debtRepository.save(debt);
  }
  public Debt updateDebtById( long bankId, long userId,Integer amount) {
    Debt debt = debtRepository.findDebtsByUserDebtUserIdAndBankBankId(userId, bankId);
    Integer newAmount = debt.getAmount() - amount;
    debt.setAmount(newAmount);
    return debtRepository.save(debt);
    // return debtRepository.save(debt);
    // return new Debt();
    // return debt;
  }
}
