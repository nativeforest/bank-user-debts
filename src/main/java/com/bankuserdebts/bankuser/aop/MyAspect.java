package com.bankuserdebts.bankuser.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Order(0)
public class MyAspect {
  //this method before will interecpt targetObject.method1()
  // @Before("execution(* com.bankuserdebts.bankuser.aop.Pointcut.*(..))")
  @Before("PointCutExample.pointCutBridgeTest()")
  public void before(JoinPoint joinPoint) {
    joinPoint.getSignature().getName();
    System.out.println("before method1");
    System.out.println("before interceptor");
    System.out.println("before interceptor"+joinPoint.getSignature().getName());
    System.out.println("before interceptor"+joinPoint.getSignature().getModifiers());
    System.out.println("before interceptor"+joinPoint.getArgs());

  }
  
}
