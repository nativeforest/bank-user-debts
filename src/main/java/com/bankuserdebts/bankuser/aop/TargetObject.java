package com.bankuserdebts.bankuser.aop;

import org.springframework.stereotype.Component;

@Component
public class TargetObject {
  public void method1() {
    System.out.println("hello target method1");
  }
  
}
