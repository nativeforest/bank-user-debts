package com.bankuserdebts.bankuser.autowiredList;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class Square implements Figure {
  @Value("3")
  private Integer side;

  
  public Integer calculateArea() {
    return side * side;
  }
}
