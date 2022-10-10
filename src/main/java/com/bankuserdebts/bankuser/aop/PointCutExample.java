package com.bankuserdebts.bankuser.aop;

import org.aspectj.lang.annotation.Pointcut;

public class PointCutExample {
  @Pointcut("execution(* com.bankuserdebts.bankuser.aop.TargetObject.*(..))")
  public void pointCutBridgeTest() {
    
  }
  
}
