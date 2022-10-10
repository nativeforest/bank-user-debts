package com.bankuserdebts.bankuser.scopes;

import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service
@Scope(value = "prototype") 
// @Scope(value = "singleton") // this is the default scope
public class ScopeTest {
  
}
