package com.simple.interest.servicios.service;

import com.simple.interest.servicios.domain.Interest;
import com.simple.interest.servicios.domain.InterestCalculate;
import com.simple.interest.servicios.domain.InterestCalculateResponse;

import java.util.List;

public interface InterestService {
  public List<Interest> list();

  public Interest save(Interest interest);

  public List<InterestCalculateResponse> calculate(InterestCalculate body);
}
