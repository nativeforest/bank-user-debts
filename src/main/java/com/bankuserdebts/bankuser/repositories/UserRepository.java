package com.bankuserdebts.bankuser.repositories;

import java.util.List;
import java.util.Set;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.bankuserdebts.bankuser.models.Bank;
import com.bankuserdebts.bankuser.models.User;
import com.bankuserdebts.bankuser.models.UserBank;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
  // @Query(value="SELECT B.ID,B.NAME FROM BANK_USER BU INNER JOIN BANKS B ON BU.bank_id=B.id WHERE BU.user_id=?1", nativeQuery=true)
  // public List<UserBank> findAllBanksByUserId(Long userId);
  public List<User> findUsersByBanksId(final long bankId);
  //findTagsByTutorialsId()
}
  

