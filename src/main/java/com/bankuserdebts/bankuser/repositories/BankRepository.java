package com.bankuserdebts.bankuser.repositories;
import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bankuserdebts.bankuser.models.Bank;





@Repository
public interface BankRepository extends JpaRepository<Bank, Long> {
  // List<Bank> findBanksByUserId(long userId);
  List<Bank> findBanksByUsersBankId(long userId);
  // findUsersByBanksId

}

  

