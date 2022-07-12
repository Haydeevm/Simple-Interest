package com.simple.interest.servicios.rest;

import com.simple.interest.servicios.domain.Interest;
import com.simple.interest.servicios.domain.InterestCalculate;
import com.simple.interest.servicios.domain.InterestCalculateResponse;

import java.util.List;

public interface InterestController {


  public List<Interest> list();
  public List<InterestCalculateResponse> calculate(InterestCalculate body);

}
