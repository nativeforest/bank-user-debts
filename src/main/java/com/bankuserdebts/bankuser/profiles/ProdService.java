package com.bankuserdebts.bankuser.profiles;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

@Service
@Profile(value = {"prod"})
public class ProdService implements EnviromentService {

  @Override
  public String getEnviroment() {
    return "running as prod enviroment";
  }


  
}
