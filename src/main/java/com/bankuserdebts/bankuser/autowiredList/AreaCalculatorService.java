package com.bankuserdebts.bankuser.autowiredList;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AreaCalculatorService {
  @Autowired
  private List<Figure> figures;

  public Integer getCalculateArea() {
    Integer area = 0;
    for (Figure figure : figures) {
      area += figure.calculateArea();
    }
    return area;
  }
  
}
