package com.bankuserdebts.bankuser.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(1)
public class MyAspect2 {
  //this method before will interecpt targetObject.method1()
  @Before("PointCutExample.pointCutBridgeTest()")
  public void before() {
    System.out.println("1 before method1");
    System.out.println("1 before interceptor");
  }
  
  
}
