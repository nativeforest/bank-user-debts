package com.bankuserdebts.bankuser.services;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.bankuserdebts.bankuser.models.Bank;
import com.bankuserdebts.bankuser.models.User;
import com.bankuserdebts.bankuser.models.UserBank;
import com.bankuserdebts.bankuser.repositories.BankRepository;
import com.bankuserdebts.bankuser.repositories.UserRepository;

@Service
public class UserService {
  @Autowired
  private BankRepository bankRepository;
  @Autowired
  private UserRepository userRepository;  

  
  // public Set<User> getBanksByUserId(Long userId) {
  //   return userRepository.findAllBanksByUserId(userId);
  // }
  
  public List<User> getAllUsers(){
    List<User> users = new ArrayList<>();
    userRepository.findAll().forEach(users::add);
    return users;
  }
  public User getUserById(Long id) {
    return userRepository.findById(id).get();
  }
  // public ResponseEntity<List<Bank>> findAllBanksByUserId(Long userId) {
  //   // Set<Bank> banks = userRepository.findById(userId).get().getBanks();
  //   // return banks;
  //     // Set<Bank> x = new HashSet<>();
  //     // System.out.println("---->userRepository.findAllBanksByUserId(userId): " + userRepository.findAllBanksByUserId(userId));
  //     if (!bankRepository.existsById(userId)) {
  //       throw new RuntimeException("Bank not found");
  //     }
  //     List<Bank> banks = bankRepository.findBanksByUserId(userId);
  //     return new ResponseEntity<>(banks, HttpStatus.OK);
  //     // return users;
  // }

  public ResponseEntity<List<User>> getAllUsersByBanksId(long bankId) {
     if (!userRepository.existsById(bankId)) {
        throw new RuntimeException("Bank not found");
      }
      List<User> users = userRepository.findUsersByBanksBankId(bankId);
      return new ResponseEntity<>(users, HttpStatus.OK);
      // return users;
  }
}
