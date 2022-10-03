package com.bankuserdebts.bankuser.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bankuserdebts.bankuser.models.Debt;

@Repository
public interface DebtRepository extends JpaRepository<Debt, Long> {
  List<Debt> findDebtsByBankId(long bankId);
  List<Debt> findDebtsByUserDebtId(long userId);
}
  

