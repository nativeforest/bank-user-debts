package com.bankuserdebts.bankuser.autowiredList;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Circle implements Figure {
  @Value("${circle.radius:0}") // value or 0 if not found
  private Integer radius;
  @Override
  public Integer calculateArea() {
    return (int) (Math.PI * Math.pow(radius, 2));
  }

  
}
